/* 
 * NetworkMessageServiceImpl.cpp
 *
 * This file is part of the IHMC Network Message Service Library
 * Copyright (c) 1993-2016 IHMC.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 3 (GPLv3) as published by the Free Software Foundation.
 *
 * U.S. Government agencies and organizations may redistribute
 * and/or modify this program under terms equivalent to
 * "Government Purpose Rights" as defined by DFARS 
 * 252.227-7014(a)(12) (February 2014).
 *
 * Alternative licenses that allow for use within commercial products may be
 * available. Contact Niranjan Suri at IHMC (nsuri@ihmc.us) for details.
 *
 * Author: Giacomo Benincasa    (gbenincasa@ihmc.us)
 * Created on May 15, 2015, 1:59 PM
 */

#include "NetworkMessageServiceImpl.h"

#include "BufferReader.h"
#include "ConfigManager.h"
#include "Logger.h"
#include "MessageFactory.h"
#include "NetUtils.h"
#include "NetworkMessageServiceListener.h"
#include "NLFLib.h"
#include "NMSProperties.h"
#include "Reassembler.h"
#include "SequentialArithmetic.h"
#include "NetworkMessage.h"
#include "NetworkMessageV2.h"
#include "Fragmenter.h"

#include <stdio.h>
#include <stdlib.h>

#if defined (UNIX)
    #include <netinet/in.h>
    #define UINT32_ADDRESS s_addr
#else
    #define UINT32_ADDRESS S_un.S_addr
#endif

#define checkAndLogMsg if (pLogger) pLogger->logMsg

namespace NOMADSUtil
{
    const char ** strArrayDup (const char **ppszString, uint8 ui8NStrings)
    {
        if (ppszString == NULL || ui8NStrings == 0) {
            return NULL;
        }
        char **ppszStringCpys = (char **) calloc (sizeof (char*), ui8NStrings+1);
        for (uint8 ui8 = 0; ppszString[ui8] != NULL; ui8++) {
            ppszStringCpys[ui8] = strDup (ppszString[ui8]);
        }
        return (const char**) ppszStringCpys;
    }
}

using namespace NOMADSUtil;

namespace IHMC_NMS
{
    class Instrumentation
    {
        public:
            Instrumentation (void);
            ~Instrumentation (void);

            void receivedBytes (const char *pszSrc, const char *pszDst, uint32 ui32Bytes);
            void sentBytes (const char *pszSrc, const char *pszDst, uint32 ui32Bytes);

        private:
            uint8 _ui8CounterRcvd;
            uint8 _ui8CounterSent;
            uint64 _ui64RcvdBytes;
            uint64 _ui64SendBytes;
    };

    Instrumentation::Instrumentation (void)
        : _ui8CounterRcvd (0), _ui8CounterSent (0), _ui64RcvdBytes (0U), _ui64SendBytes (0U)
    {
    }

    Instrumentation::~Instrumentation (void)
    {
    }
    
    void Instrumentation::receivedBytes (const char *pszSrc, const char *pszDst, uint32 ui32Bytes)
    {
        const char *pszMethodName = "Instrumentation::receivedBytes";
        _ui64RcvdBytes += ui32Bytes;
        if (++_ui8CounterRcvd == 0xFF) {
            checkAndLogMsg (pszMethodName, Logger::L_Info, "received %lld bytes.\n", _ui64RcvdBytes);
        }
    }

    void Instrumentation::sentBytes (const char *pszSrc, const char *pszDst, uint32 ui32Bytes)
    {
        const char *pszMethodName = "Instrumentation::sentBytes";
        _ui64SendBytes += ui32Bytes;
        if (++_ui8CounterSent == 0xFF) {
            checkAndLogMsg (pszMethodName, Logger::L_Info, "sent %lld bytes.\n", _ui64SendBytes);
        }
    }
}

NetworkMessageServiceImpl::NetworkMessageServiceImpl (PROPAGATION_MODE mode, bool bAsyncDelivery,
                                                      uint8 ui8MessageVersion, NetworkInterfaceManager *pNetIntMgr)
    : _mode (mode),
      _bAsyncDelivery (bAsyncDelivery),
      _ui8DefMaxNumOfRetransmissions (NetworkMessageService::DEFAULT_MAX_NUMBER_OF_RETRANSMISSIONS),
      _ui32RetransmissionTimeout (NetworkMessageService::DEFAULT_RETRANSMISSION_TIME),
      _ui16BroadcastedMsgCounter (0U),
      _msgFactory (ui8MessageVersion),
      _reassembler (_ui32RetransmissionTimeout),
      _pNetIntMgr (pNetIntMgr),
      _pInstr (NULL),
      _lastMsgs (true, true),
      _cvDeliveryQueue (&_mDeliveryQueue)
{
}

NetworkMessageServiceImpl::~NetworkMessageServiceImpl (void)
{
    if (_bAsyncDelivery) {
        if (_ostDeliveryThread.wasStarted()) {
            _ostDeliveryThread.waitForThreadToTerminate (0);
        }
    }
    for (StringHashtable<ByInterface>::Iterator iInterface = _tQueueLengthByInterface.getAllElements(); !iInterface.end(); iInterface.nextElement()) {
        ByInterface* pInterface = iInterface.getValue();
        for (NOMADSUtil::UInt32Hashtable<ByNeighbor>::Iterator iNeighbor = pInterface->_tByNeighbor.getAllElements(); !iNeighbor.end(); iNeighbor.nextElement()) {
            ByNeighbor* pNeighbor = iNeighbor.getValue();
            delete pNeighbor;
        }
        pInterface->_tByNeighbor.removeAll();
        delete pInterface;
    }
    _tQueueLengthByInterface.removeAll();

    _lastMsgs.removeAll();
}

int NetworkMessageServiceImpl::init (ConfigManager *pCfgMgr)
{
    
    if (pCfgMgr == NULL) {
        return -1;
    }

    const uint32 ui32MTU = pCfgMgr->getValueAsUInt32 (NMSProperties::NMS_MTU, NetworkMessageService::DEFAULT_MTU);
    const uint32 ui33MaxOutgoingQueingTime = pCfgMgr->getValueAsUInt32 ("nms.transmission.maxAggregationPeriod", 5000U);
    const uint32 ui32RetransmissionTimeout = pCfgMgr->getValueAsUInt32 ("nms.retransmission.timeout", NetworkMessageService::DEFAULT_RETRANSMISSION_TIME);
    const uint32 ui32DefMaxNumOfRetransmissions = pCfgMgr->getValueAsUInt32 ("nms.retransmission.maxNumber", NetworkMessageService::DEFAULT_MAX_NUMBER_OF_RETRANSMISSIONS);
    if (ui32DefMaxNumOfRetransmissions > 0xFF) {
        return -3;
    }
    if (pCfgMgr->getValueAsBool("nms.instrumented", true)) {
        _pInstr = new IHMC_NMS::Instrumentation();
    }
    if (_bAsyncDelivery) {
        _ostDeliveryThread.start (deliveryThread, this);
    }
    return 0;
}

int NetworkMessageServiceImpl::registerHandlerCallback (uint8 ui8MsgType, NetworkMessageServiceListener *pListener)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::registerHandlerCallback";
    NMSListerList *ptrLListeners = _listeners.get (ui8MsgType);
    if (ptrLListeners == NULL) {
        checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                        "initializing listener list for msgtype=%d\n", ui8MsgType);

        ptrLListeners = new NMSListerList();
        _listeners.put (ui8MsgType, ptrLListeners);
    }
    checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                    "adding a listener for msgtype=%d\n", ui8MsgType);

    ptrLListeners->append (pListener);
    ptrLListeners = NULL;

    return 0; //to handle!!
}

int NetworkMessageServiceImpl::deregisterHandlerCallback (uint8 ui8MsgType, NetworkMessageServiceListener *pListener)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::deregisterHandlerCallback";
    NMSListerList *ptrLListeners = _listeners.get (ui8MsgType);
    if (ptrLListeners == NULL) {
        return 1;
    }
    if (ptrLListeners->remove (pListener) != NULL) {
        checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                        "removed listener for msgtype=%d\n", ui8MsgType);
    }
    return 0;
}

int NetworkMessageServiceImpl::transmit (TransmissionInfo &trInfo, MessageInfo &msgInfo)
{
    _pNetIntMgr->resolveProxyDatagramSocketAddresses();
    if (!_pNetIntMgr->isPrimaryIfaceSet()) {
        return -1;
    }
    return 0;
}

int NetworkMessageServiceImpl::broadcastMessage (TransmissionInfo &trInfo, MessageInfo &msgInfo)
{
    _pNetIntMgr->resolveProxyDatagramSocketAddresses();
    if (!_pNetIntMgr->isPrimaryIfaceSet()) {
        return -1;
    }
    if ((trInfo.ui32DestinationAddress != 0U) && (!_pNetIntMgr->isSupportedManycastAddr (trInfo.ui32DestinationAddress))) {
        return -2;
    }

    _m.lock();
    const char * const pszMethodName = "NetworkMessageServiceImpl::broadcastMessage";

    checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug, "outgoing packet src: %u\n",
                    NetUtils::getLocalIPAddress().s_addr); //can I consider this the "main" ip address?

    NetworkMessage *pNetMsg = _msgFactory.getDataMessage (_pNetIntMgr->getPrimaryInterface(), _ui16BroadcastedMsgCounter++,
                                                          NetworkMessage::CT_DataMsgComplete, trInfo, msgInfo);

    if (sendNetworkMessage (pNetMsg, trInfo, true) != 0) {
        checkAndLogMsg (pszMethodName, Logger::L_MildError, "no interface available to broadcast\n");
        _m.unlock();
        return -3;
    }

    _m.unlock();
    return 0;
}

int NetworkMessageServiceImpl::transmitMessage (TransmissionInfo &trInfo, MessageInfo &msgInfo)
{
    _m.lock();

    // !!!
    // !!! NOTE: unreliable transmission is still not supported, set bReliable on true for now!
    // !!!
    trInfo.bReliable = true;
    int rc = fragmentAndTransmitMessage (trInfo, msgInfo);
    _m.unlock();
    return rc;
}

int NetworkMessageServiceImpl::transmitReliableMessage (TransmissionInfo &trInfo, MessageInfo &msgInfo)
{
    _m.lock();
    checkAndLogMsg ("NetworkMessageServiceImpl::transmitReliableMessage", Logger::L_MediumDetailDebug,
                    "transmitting a reliable message of size %d\n", (int) msgInfo.ui16MsgLen);
    trInfo.bExpedited = true;
    int rc = fragmentAndTransmitMessage (trInfo, msgInfo);
    _m.unlock();
    return rc;
}

int NetworkMessageServiceImpl::fragmentAndTransmitMessage (TransmissionInfo &trInfo, MessageInfo &msgInfo)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::fragmentAndTransmitMessage";

    _pNetIntMgr->resolveProxyDatagramSocketAddresses();
    if (!_pNetIntMgr->isPrimaryIfaceSet()) {
        return -1;
    }

    //uint32 ui32BindingInterface = (_bPrimaryInterfaceIdSet ? _ui32PrimaryInterface : NetUtils::getLocalIPAddress().s_addr);
    //checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug, "outgoing packet src addr: %u\n", ui32BindingInterface);

    const uint16 ui16MinMTU = _pNetIntMgr->getMinMTU();
    const uint16 ui16PayLoadLen = ui16MinMTU - NetworkMessage::FIXED_HEADER_LENGTH;
    const uint32 ui32TotDataLen = msgInfo.ui16MsgMetaDataLen + msgInfo.ui16MsgLen;
    if (ui16PayLoadLen < NetworkMessage::FIXED_HEADER_LENGTH) {
        checkAndLogMsg (pszMethodName, Logger::L_Warning, "minimum MTU is %d, which is "
                        "smaller that even the header length of %d - cannot transmit message\n",
                        (int) ui16MinMTU, (int) NetworkMessage::FIXED_HEADER_LENGTH);
        return -2;
    }   
    checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug, "MTU = %d; payload "
                    "length = %d; total data length = %d\n", (int) ui16MinMTU,
                    (int) ui16PayLoadLen, (int) ui32TotDataLen);

    if (ui32TotDataLen <=  ui16PayLoadLen) {
        // No need to fragment
        NetworkMessage *pNetMsg = trInfo.bReliable ? _msgFactory.getReliableDataMessage (_pNetIntMgr->getPrimaryInterface(),
                                                                  NetworkMessage::CT_DataMsgComplete,
                                                                  trInfo, msgInfo.pMsgMetaData, msgInfo.ui16MsgMetaDataLen,
                                                                  msgInfo.pMsg, msgInfo.ui16MsgLen) :
                              _msgFactory.getDataMessage (_pNetIntMgr->getPrimaryInterface(),
                                                          _ui16BroadcastedMsgCounter++,
                                                          NetworkMessage::CT_DataMsgComplete,
                                                          trInfo, msgInfo);

        return sendNetworkMessage (pNetMsg, trInfo, true);
    }

    // The message must be fragmented    
    Fragmenter fragment (ui16PayLoadLen, msgInfo.pMsgMetaData, msgInfo.ui16MsgMetaDataLen, msgInfo.pMsg, msgInfo.ui16MsgLen);
    MessageInfo miCurr = msgInfo;
    NetworkMessage::ChunkType chunkType;
    for (const void *pFragment; (pFragment = fragment.getNext (miCurr.ui16MsgMetaDataLen, miCurr.ui16MsgLen, chunkType)) != NULL;) {
        const void *pMetadata, *pData;
        pMetadata = pData = NULL;
        if (miCurr.ui16MsgMetaDataLen > 0) {
            pMetadata = pFragment;
        }
        else if (miCurr.ui16MsgLen > 0) {
            pData = pFragment;
        }

        NetworkMessage *pNetMsg = trInfo.bReliable ? _msgFactory.getReliableDataMessage (_pNetIntMgr->getPrimaryInterface(), chunkType, trInfo,
                                                                         pMetadata, miCurr.ui16MsgMetaDataLen, pData, miCurr.ui16MsgLen) :
                              _msgFactory.getDataMessage (_pNetIntMgr->getPrimaryInterface(), _ui16BroadcastedMsgCounter++, chunkType, trInfo, miCurr);

        sendNetworkMessage (pNetMsg, trInfo, true);
    }

    return 0;
}

void NetworkMessageServiceImpl::run()
{
    started();
    uint8 ui8Count = 0;
    while(!terminationRequested()) {
        sendSAckMessagesNetworkMessage();
        if (ui8Count == NetworkMessageService::K) {
            resendUnacknowledgedMessages();
            ui8Count = 0;
        }
        sleepForMilliseconds (_ui32RetransmissionTimeout / NetworkMessageService::K);
        ui8Count++;
        //periodically reset queue length of dead/silent neighbors to 0
        cleanOldNeighborQueueLengths();
    }
    terminating();
}

PROPAGATION_MODE NetworkMessageServiceImpl::getPropagationMode()
{
    return _mode;
}

uint32 NetworkMessageServiceImpl::getDeliveryQueueSize (void)
{
    _mDeliveryQueue.lock();
    uint32 ui32QueueSize = _deliveryQueue.sizeOfQueue();
    _mDeliveryQueue.unlock();
    return ui32QueueSize;
}

uint8 NetworkMessageServiceImpl::getNeighborQueueLength (const char *pchIncomingInterface,
                                                     unsigned long int ulSenderRemoteAddr)
{
    _mQueueLengthsTable.lock();
    ByInterface* pInterface = _tQueueLengthByInterface.get (pchIncomingInterface);
    if (pInterface == NULL) {
        _mQueueLengthsTable.unlock();
        return 0;
    }
    ByNeighbor* pNeighbor = pInterface->_tByNeighbor.get (ulSenderRemoteAddr);
    if (pNeighbor == NULL) {
        _mQueueLengthsTable.unlock();
        return 0;
    }
    _mQueueLengthsTable.unlock();
    return pNeighbor->_ui8QueueLength;
}

//////////////////////////// Private Methods ///////////////////////////////////

bool NetworkMessageServiceImpl::checkOldMessages (uint32 ui32SourceAddress, uint16 ui16SessionId, uint16 ui16MsgId)

{
    PeerState *pPS = _lastMsgs.get (ui32SourceAddress);

    if (pPS == NULL) {
        // New host
        return true;
    }
    else {
        if (ui16SessionId != pPS->ui16SessionId) {
            return true;
        }
        return !pPS->checkIfReceived (ui16MsgId);
    }
}

void NetworkMessageServiceImpl::updateOldMessagesList (uint32 ui32SourceAddress, uint16 ui16SessionId, uint16 ui16MsgId)
{
    PeerState *pPS = _lastMsgs.get (ui32SourceAddress);
    if (pPS == NULL) {
        pPS = new PeerState;
        pPS->ui16SessionId = ui16SessionId;
        _lastMsgs.put (ui32SourceAddress, pPS);
    }
    else if (pPS->ui16SessionId != ui16SessionId) {
        pPS->ui16SessionId = ui16SessionId;
        pPS->resetMessageHistory();
    }
    pPS->setAsReceived (ui16MsgId);
}

int NetworkMessageServiceImpl::messageArrived (NetworkMessage *pNetMsg, const char *pszIncomingInterface,
                                               unsigned long ulSenderRemoteAddress)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::messageArrived";

    String incoming (pszIncomingInterface);
    if (incoming.length() <= 0) {
        incoming = _pNetIntMgr->tryToGuessIncomingIface();
    }
    
    const uint32 ui32SourceAddress = pNetMsg->getSourceAddr();
    _pNetIntMgr->addFwdingAddrToManycastIface (ui32SourceAddress, incoming);
    if (_pInstr != NULL) {
        InetAddr addr (ui32SourceAddress);
        _pInstr->receivedBytes (addr.getIPAsString(), pszIncomingInterface, pNetMsg->getMsgLen());
    }

    _mxMessageArrived.lock();
    _reassembler.refresh (ui32SourceAddress);

    //if the message contains a queue length, update the value for the corresponding neighbor
    uint8 ui8QueueLength;
    if (pNetMsg->getVersion() == 2) {
        ui8QueueLength = ((NetworkMessageV2*) pNetMsg)->getQueueLength();
    }
    else {
        ui8QueueLength = 0;
    }
    setNeighborQueueLength (ulSenderRemoteAddress, ui8QueueLength);

    if (pNetMsg->getChunkType() == NetworkMessage::CT_SAck) {
        checkAndLogMsg (pszMethodName, Logger::L_LowDetailDebug,
                        "SAck message arrived\n");
        ackArrived (pNetMsg, pszIncomingInterface);
    }
    else {
        const uint16 ui16MsgId = pNetMsg->getMsgId();
        if (_pNetIntMgr->isUnicast (pNetMsg->getDestinationAddr(), pszIncomingInterface)) {
            checkAndLogMsg (pszMethodName, Logger::L_LowDetailDebug,
                            "isUnicast() returned true for address %u\n",
                            pNetMsg->getDestinationAddr());
            if (!_reassembler.hasTSN (ui32SourceAddress, ui16MsgId) ||
                _reassembler.isNewSessionId (ui32SourceAddress, pNetMsg->getSessionId())) {
                // It MAY be a new message
                int ret = _reassembler.push (ui32SourceAddress, pNetMsg);
                if (ret == 0) {
                    // It is a new message and it has been added to the reassembler
                    for (NetworkMessage *pInnerNetMsg = _reassembler.pop (ui32SourceAddress);
                         pInnerNetMsg != NULL; pInnerNetMsg = _reassembler.pop (ui32SourceAddress)) {
                        notifyListeners (pInnerNetMsg, pszIncomingInterface, ulSenderRemoteAddress);
                        delete pInnerNetMsg;
                        pInnerNetMsg = NULL;
                    }
                }
                else if (ret > 0) {
                    // There is no need to deleted it, it is deleted by the
                    // Reassembler
                    checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug,
                                    "duplicated message - discarding\n");
                }
                else {
                    delete pNetMsg;
                    pNetMsg = NULL;
                    checkAndLogMsg (pszMethodName, Logger::L_SevereError,
                                    "the message could not be stored in the reassembler.\n");
                }
            }
            // Send an SAck to the node that just sent us a unicast message
            int rc;
            uint32 ui32MsgLen;
            void *pSAck = _reassembler.getSacks (ui32SourceAddress, _pNetIntMgr->getMTU(), ui32MsgLen);
            if (pSAck == NULL) {
                checkAndLogMsg (pszMethodName, Logger::L_MildError,
                                "getSacks() on Reassembler returned NULL for address %lu\n", ui32SourceAddress);
            }
            else if (_pNetIntMgr->isPrimaryIfaceSet()) {
                _pNetIntMgr->resolveProxyDatagramSocketAddresses();
                NetworkMessage *pSAckMsg = _msgFactory.getSAckMessage (NetworkMessageService::NMS_CTRL_MSG, _pNetIntMgr->getPrimaryInterface(),
                                                                       ui32SourceAddress, 0, 1, NULL, 0, pSAck, ui32MsgLen);
                TransmissionInfo trInfo;
                trInfo.bReliable = false;
                trInfo.bExpedited = true;
                trInfo.ui8HopCount = 0;
                trInfo.ui8TTL = 1;
                trInfo.ui16DelayTolerance = 0;
                trInfo.ui8MsgType = NetworkMessageService::NMS_CTRL_MSG;
                trInfo.ui32DestinationAddress = ui32SourceAddress;
                trInfo.ppszOutgoingInterfaces = NULL;
                trInfo.pszHints = NULL;
                if (0 != (rc = sendNetworkMessage (pSAckMsg, trInfo))) {
                    checkAndLogMsg (pszMethodName, Logger::L_MildError,
                                    "sendNetworkMessage() failed with rc = %d\n", rc);
                }
                else {
                    uint16 ui16CumSak = _reassembler.getCumulativeTSN (ui32SourceAddress);
                    checkAndLogMsg (pszMethodName, Logger::L_LowDetailDebug,
                                    "sendNetworkMessage() succeeded: the cumulative "
                                    "TSN is %d\n", ui16CumSak);
                }
                free (pSAck);
            }
            else {
                checkAndLogMsg (pszMethodName, Logger::L_Warning, "could not "
                                "acknowledge message because primary interface is not set\n");
                free (pSAck);
            }
        }
        else {
            bool bNewMessage = checkOldMessages (ui32SourceAddress, pNetMsg->getSessionId(), ui16MsgId);
            updateOldMessagesList (ui32SourceAddress, pNetMsg->getSessionId(), ui16MsgId);
            if (bNewMessage) {
                // Retransmit and notify (need to be mutex-ed since other
                // interfaces may be re-broadcasting the same message)
                //_mxRebroad.lock();
                rebroadcastMessage (pNetMsg, pszIncomingInterface);
                notifyListeners (pNetMsg, pszIncomingInterface, ulSenderRemoteAddress);
                delete pNetMsg;
                pNetMsg = NULL;
                //_mxRebroad.unlock();
            }
            else {
                checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                                "duplicated message: sessionId: %u, msgId: %u\n",
                                pNetMsg->getSessionId(), ui16MsgId);
                delete pNetMsg;
                pNetMsg = NULL;
            }
        }
    }
    // TODO: delete arrived message ???
    _mxMessageArrived.unlock();
    return 0;
}

int NetworkMessageServiceImpl::messageSent (const NetworkMessage *pNetMsg, const char *pchOutgoingInterface)
{
    if (_pInstr == NULL) {
        return 0;
    }
    InetAddr addr (pNetMsg->getDestinationAddr());
    _pInstr->sentBytes (pchOutgoingInterface, addr.getIPAsString(), pNetMsg->getMsgLen());
    return 0;
}

int NetworkMessageServiceImpl::resendUnacknowledgedMessages (void)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::resendUnacknowledgedMessages";
    // For each target
    _mxUnackedSentMessagesByDestination.lock();
    UnackedSentMessagesByDestination::Iterator i = _unackedSentMessagesByDestination.getAllElements();
    while (!i.end()) {
        uint32 ui32TargetAddress = i.getKey();
        UnackedSentMessagesByMsgId *pByMsgId = i.getValue();
        // resend the unacknowledged messages which timed out
        int64 i64RetransmissionStartingTime = getTimeInMilliseconds();
        UnackedMessageWrapper *pMsgWrap = pByMsgId->getFirst();
        UnackedMessageWrapper *pNextMsgWrap;
        while (pMsgWrap) {
            if (pMsgWrap->_i64SendingTime >= i64RetransmissionStartingTime) {
                // every time a message is retransmitted, its removed from its
                // current location in the UnackedSentMessagesByMsgId queue and
                // re-entered at the end of it.
                // Thus this check in order not to loop indefinitely
                break;
            }
            int64 ui64Now = getTimeInMilliseconds();
            // pMsgWrap may be deleted by the sendNetworkMessage() thus it is
            // necessary to retrieve the reference to the next element here.
            pNextMsgWrap = pByMsgId->getNext();
            uint32 ui32TimeOut = pMsgWrap->_ui32TimeOut * (1 + (pMsgWrap->_ui32RetransmitCount <= 5 ? pMsgWrap->_ui32RetransmitCount : 5));
            checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug,
                            "computed timeout for message %d to be %lu; last transmit time was %lu ms ago\n",
                            (int) pMsgWrap->_pNetMsg->getMsgId(), ui32TimeOut, (uint32) (ui64Now - pMsgWrap->_i64SendingTime));
            if ((pMsgWrap->_i64SendingTime + ui32TimeOut) <= ui64Now) {
                checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug,
                                "resending message %u\n", pMsgWrap->_pNetMsg->getMsgId());
                TransmissionInfo trInfo;
                trInfo.bReliable = true;
                trInfo.bExpedited = true;
                trInfo.ui8HopCount = pMsgWrap->_pNetMsg->getHopCount();
                trInfo.ui8TTL = pMsgWrap->_pNetMsg->getTTL();
                trInfo.ui16DelayTolerance = pMsgWrap->_ui16DelayTolerance;
                trInfo.ui8MsgType = pMsgWrap->_pNetMsg->getMsgType();
                trInfo.ui32DestinationAddress = ui32TargetAddress;
                trInfo.ppszOutgoingInterfaces = pMsgWrap->_ppszOutgoingInterfaces;
                trInfo.pszHints = NULL;
                sendNetworkMessage (pMsgWrap->_pNetMsg, trInfo); // Send this as an expedited message, in order to get around the 300 message limit on the outgoing queue in NetworkInterface
            }
            else {
                // The UnackedMessageWrappers are ordered by time-out time, therefore,
                // if the current UnackedMessageWrapper timeout has not been triggered
                // yet, the further one's will not either.
                checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                                "NOT resending message %u\n", pMsgWrap->_pNetMsg->getMsgId());
                break;
            }
            pMsgWrap = pNextMsgWrap;
        }
        i.nextElement();
    }
    _mxUnackedSentMessagesByDestination.unlock();
    return 0;
}

int NetworkMessageServiceImpl::ackArrived (NetworkMessage *pNetMsg, const char *)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::ackArrived";
    BufferReader bw (pNetMsg->getMsg(), pNetMsg->getLength());
    SAckTSNRangeHandler tsnhandler;
    tsnhandler.read (&bw, pNetMsg->getLength());

    _mxUnackedSentMessagesByDestination.lock();
    UnackedSentMessagesByMsgId *pByMsgId = _unackedSentMessagesByDestination.get (pNetMsg->getSourceAddr());
    if (pByMsgId != NULL) {
        checkAndLogMsg (pszMethodName, Logger::L_LowDetailDebug,
                        "pByMsgId is not NULL\n");
        uint16 ui16Start, ui16End;
        UI16Wrapper *pWrap = new UI16Wrapper;
        pWrap->ui16 = tsnhandler.getCumulativeTSN();
        _cumulativeTSNByDestination.put (pNetMsg->getSourceAddr(), pWrap);
        // Every message
        // - with msgId less or equal to the cumulative TSN          OR
        // - with msgId included in a TSN range                      OR
        // - that have reached the threshold of retransmissions
        // must be deleted from the queue of the un-acked messages

        // Remove every message with msgId less or equal than the cumulative TSN
        UnackedMessageWrapper * pMsgWrap = pByMsgId->getFirst();
        UnackedMessageWrapper *pNextMsgWrap;
        uint16 ui16MsgId;
        while (pMsgWrap) {
            pNextMsgWrap = pByMsgId->getNext();
            ui16MsgId = pMsgWrap->_pNetMsg->getMsgId();
            if (SequentialArithmetic::lessThanOrEqual (ui16MsgId, tsnhandler.getCumulativeTSN())) {
                checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                                "Removing message %u from UnackedSentMessagesByMsgId, for node %u\n",
                                ui16MsgId, pNetMsg->getSourceAddr());
                pByMsgId->remove (pMsgWrap);
                delete pMsgWrap;
            }
            pMsgWrap = pNextMsgWrap;
        }
        // Remove every message left that is included in a TSN range or that
        // has reached the threshold of retransmissions
        tsnhandler.resetGet();
        pByMsgId->resetGet();
        for (int i = tsnhandler.getFirst (ui16Start, ui16End); i == 0; i = tsnhandler.getNext (ui16Start, ui16End)) {
            pMsgWrap = pByMsgId->getFirst();
            while (pMsgWrap) {
                pNextMsgWrap = pByMsgId->getNext();
                ui16MsgId = pMsgWrap->_pNetMsg->getMsgId();
                if (((SequentialArithmetic::greaterThanOrEqual (ui16MsgId, ui16Start)) &&
                     (SequentialArithmetic::lessThanOrEqual (ui16MsgId, ui16End))) ||
                    ((_ui8DefMaxNumOfRetransmissions != 0) &&
                     (pMsgWrap->_ui32RetransmitCount >= _ui8DefMaxNumOfRetransmissions))) {
                    checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                                    "Removing message %u from UnackedSentMessagesByMsgId, for node %u\n",
                                    ui16MsgId, pNetMsg->getSourceAddr());
                    pByMsgId->remove (pMsgWrap);
                    delete pMsgWrap;
                }
                else {
                   /* checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                                      "NON Removing message %u from UnackedSentMessagesByMsgId, for node %u. the range is %u <= X <= %u\n",
                                      pMsgWrap->_pNetMsg->getMsgId(), pNetMsg->getSourceAddr(), ui16Start, ui16End);*/
                }
                pMsgWrap = pNextMsgWrap;
            }
        }
    }
    _mxUnackedSentMessagesByDestination.unlock();
    delete pNetMsg;
    pNetMsg = NULL;
    this->yield();
    return 0;
 }

int NetworkMessageServiceImpl::rebroadcastMessage (NetworkMessage *pNetMsg, const char *pchIncomingInterface)
{
    const char *const pszMethodName = "NetworkMessageServiceImpl::rebroadcastMessage";
    int returnValue = 0;

    //----------------------------------------------------------------------
    // AGGREGATION
    //----------------------------------------------------------------------
    // if not aggregation -> serialize and broadcast** ("NetworkMessageServiceSender"? - aggregation and serialization)

    //----------------------------------------------------------------------
    // REBROADCAST
    //----------------------------------------------------------------------
    if (pNetMsg->getHopCount() < pNetMsg->getTTL()) {
        // TTL check (hopcount has already been incremented by receiver (caller of this method)
        checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug,
                        "Rebroadcasting message from %s\n", pchIncomingInterface);

        TransmissionInfo trInfo;
        trInfo.bReliable = false;
        trInfo.bExpedited = false;
        trInfo.ui8HopCount = pNetMsg->getHopCount();
        trInfo.ui8TTL = pNetMsg->getTTL();
        trInfo.ui16DelayTolerance = 0;
        trInfo.ui8MsgType = pNetMsg->getMsgType();
        trInfo.ui32DestinationAddress = NetworkMessageService::EMPTY_RECIPIENT;
        trInfo.ppszOutgoingInterfaces = NULL;
        trInfo.pszHints = NULL;
        return sendNetworkMessage (pNetMsg, trInfo);
    }
    else {
        checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                        "Hop limit\n");
    }

    return returnValue;
}

int NetworkMessageServiceImpl::notifyListeners (NetworkMessage *pNetMsg, const char *pszIncomingInterface, unsigned long ulSenderRemoteAddr)
{
    if (!_bAsyncDelivery) {
        return callListeners (pNetMsg, pszIncomingInterface, ulSenderRemoteAddr, getTimeInMilliseconds());
    }

    QueuedMessage *pQMsg = new QueuedMessage();
    pQMsg->pMsg = MessageFactory::createNetworkMessageFromMessage (*pNetMsg, pNetMsg->getVersion());
    pQMsg->incomingInterface = pszIncomingInterface;
    pQMsg->ulSenderRemoteAddress = ulSenderRemoteAddr;
    pQMsg->i64Timestamp = getTimeInMilliseconds();
    _mDeliveryQueue.lock();
    _deliveryQueue.enqueue (pQMsg);
    checkAndLogMsg ("NetworkMessageServiceImpl::notifyListeners", Logger::L_SevereError,
                    "queue size is: %lu\n", _deliveryQueue.sizeOfQueue());
    _cvDeliveryQueue.notifyAll();
    _mDeliveryQueue.unlock();
    return 0;
}

int NetworkMessageServiceImpl::callListeners (NetworkMessage *pNetMsg, const char *pchIncomingInterface, unsigned long ulSenderRemoteAddr, int64 i64Timestamp)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::callListeners";
    // Get the listeners
    checkAndLogMsg (pszMethodName, Logger::L_MediumDetailDebug, "Calling message listeners\n");
    NMSListerList *ptrLListeners = (NMSListerList*) _listeners.get (pNetMsg->getMsgType());
    if (ptrLListeners) {
        for (NetworkMessageServiceListener *pPtrLListener = ptrLListeners->getFirst();
             pPtrLListener; pPtrLListener = ptrLListeners->getNext()) {
            pPtrLListener->messageArrived (pchIncomingInterface, ulSenderRemoteAddr,
                                           pNetMsg->getMsgType(), pNetMsg->getMsgId(),
                                           pNetMsg->getHopCount(), pNetMsg->getTTL(),
                                           pNetMsg->getMetaData(), pNetMsg->getMetaDataLen(),
                                           pNetMsg->getMsg(), pNetMsg->getMsgLen(), i64Timestamp);
        }
    }
    else {        
        checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                        "No listeners for msgtype\n");
    }
    return 0;
}

int NetworkMessageServiceImpl::sendNetworkMessage (NetworkMessage *pNetMsg, TransmissionInfo &trInfo, bool bDeallocatedNetMsg)
{
    const char * const pszMethodName = "NetworkMessageServiceImpl::sendNetworkMessage";

    const bool bAtLeastOneIF = _pNetIntMgr->send (pNetMsg, trInfo.ppszOutgoingInterfaces, trInfo.ui32DestinationAddress, trInfo.bExpedited, trInfo.pszHints);
    uint8 ui8Counter = 0;
    if (trInfo.ppszOutgoingInterfaces != NULL) {
        for (; trInfo.ppszOutgoingInterfaces[ui8Counter] != NULL; ui8Counter++);
    }

    if (trInfo.bReliable && bAtLeastOneIF) {
        // buffer it
        _mxUnackedSentMessagesByDestination.lock();
        UnackedSentMessagesByMsgId *pByMsgId = _unackedSentMessagesByDestination.get (trInfo.ui32DestinationAddress);
        if (pByMsgId == NULL) {
            pByMsgId = new UnackedSentMessagesByMsgId();
            _unackedSentMessagesByDestination.put (trInfo.ui32DestinationAddress, pByMsgId);
        }
        UI16Wrapper *pWrap = _cumulativeTSNByDestination.get (trInfo.ui32DestinationAddress);
        if ((pWrap == NULL) || SequentialArithmetic::greaterThan(pNetMsg->getMsgId(), pWrap->ui16)) {
            // Add the message to the queue of the un-acked messages only if the
            // message has message id greater than the cumulativeTSN.
            UnackedMessageWrapper *pMsgWrapper = new UnackedMessageWrapper (pNetMsg);
            pMsgWrapper->_i64SendingTime = getTimeInMilliseconds();
            pMsgWrapper->_ui32TimeOut = NetworkMessageService::DEFAULT_TIME_OUT;
            pMsgWrapper->_ppszOutgoingInterfaces = strArrayDup (trInfo.ppszOutgoingInterfaces, ui8Counter);
            pMsgWrapper->_ui16DelayTolerance = trInfo.ui16DelayTolerance;
            pMsgWrapper->_ui32RetransmitCount = 0;
            UnackedMessageWrapper *pOldMsgWrapper = pByMsgId->remove (pMsgWrapper);
            if (pOldMsgWrapper != NULL) {
                pOldMsgWrapper->_bDeleteNetMsg = false;
                pMsgWrapper->_ui32RetransmitCount = pOldMsgWrapper->_ui32RetransmitCount + 1;
                delete pOldMsgWrapper;
                pOldMsgWrapper = NULL;
            }
            pByMsgId->append (pMsgWrapper);
            checkAndLogMsg (pszMethodName, Logger::L_HighDetailDebug,
                            "added msg %u; pByMsgId has %d elements\n",
                            pMsgWrapper->_pNetMsg->getMsgId(), pByMsgId->getCount());
        }
        _mxUnackedSentMessagesByDestination.unlock();
    }
    else if (bDeallocatedNetMsg) {
        // delete the message
        delete pNetMsg;
        pNetMsg = NULL;
    }

    if (!bAtLeastOneIF) {
        checkAndLogMsg (pszMethodName, Logger::L_MildError,
                        "no interface available\n");
        return -1;
    }

    return 0;
}

int NetworkMessageServiceImpl::sendSAckMessagesNetworkMessage (void)
{
    const char *pszMethodName = "NetworkMessageServiceImpl::sendSAckMessagesNetworkMessage";
    _pNetIntMgr->resolveProxyDatagramSocketAddresses();
    if (!_pNetIntMgr->isPrimaryIfaceSet()) {
        checkAndLogMsg (pszMethodName, Logger::L_Warning, "could not acknowledge message because "
                        "primary interface is not set\n");
        return -1;
    }
    int rc;
    uint32 ui32NumOfNeighbors, ui32MsgLen;
    checkAndLogMsg (pszMethodName, Logger::L_Info,
                    "entered\n");
    uint32 *pNeighbors = _reassembler.getNeighborsToBeAcknowledged (ui32NumOfNeighbors);
    checkAndLogMsg (pszMethodName, Logger::L_Info,  "number of neighbors that "
                    "should be acknowledged is %lu\n", ui32NumOfNeighbors);
    for (uint32 i = 0; i < ui32NumOfNeighbors; i++) {
        void *pSAck = _reassembler.getSacks (pNeighbors[i], _pNetIntMgr->getMTU(), ui32MsgLen);
        NetworkMessage *pSAckMsg = _msgFactory.getSAckMessage (NetworkMessageService::NMS_CTRL_MSG,
                                                               _pNetIntMgr->getPrimaryInterface(),
                                                               pNeighbors[i], 0, 1, NULL, 0, pSAck,
                                                               ui32MsgLen);
        TransmissionInfo trInfo;
        trInfo.bReliable = false;
        trInfo.bExpedited = true;
        trInfo.ui8HopCount = pSAckMsg->getHopCount();
        trInfo.ui8TTL = pSAckMsg->getTTL();
        trInfo.ui16DelayTolerance = 0;
        trInfo.ui8MsgType = pSAckMsg->getMsgType();
        trInfo.ui32DestinationAddress = pNeighbors[i];
        trInfo.ppszOutgoingInterfaces = NULL;
        trInfo.pszHints = NULL;
        if (0 != (rc = sendNetworkMessage (pSAckMsg, trInfo))) {
            checkAndLogMsg (pszMethodName, Logger::L_MildError,
                            "sendNetworkMessage() failed with rc = %d\n", rc);
            delete[] pNeighbors;
            return -2;
        }
        else {
            uint16 ui16CumSak = _reassembler.getCumulativeTSN (pNeighbors[i]);
            checkAndLogMsg (pszMethodName,
                            Logger::L_LowDetailDebug, "sendNetworkMessage() succeded: "
                            "the cumulative TSN is %d\n", ui16CumSak);
        }
    }
    delete[] pNeighbors;
    return 0;
}

void NetworkMessageServiceImpl::setNeighborQueueLength (unsigned long int ulSenderRemoteAddr, uint8 ui8QueueLength)
{
    const String outgoingIntAddr (_pNetIntMgr->getOutgoingInterfaceForAddr (ulSenderRemoteAddr));
    if (outgoingIntAddr.length() <= 0) {
        return;
    }

    _mQueueLengthsTable.lock();
    ByInterface *pInterface = _tQueueLengthByInterface.get (outgoingIntAddr);
    if (pInterface == NULL) {
        pInterface = new ByInterface;
        _tQueueLengthByInterface.put (outgoingIntAddr, pInterface);
    }
    ByNeighbor *pNeighbor = pInterface->_tByNeighbor.get (ulSenderRemoteAddr);
    if (pNeighbor == NULL) {
        pNeighbor = new ByNeighbor;
        pInterface->_tByNeighbor.put (ulSenderRemoteAddr, pNeighbor);
    }
    pNeighbor->_ui8QueueLength = ui8QueueLength;
    pNeighbor->_bUpdatedSinceLastCheck = true;
    _mQueueLengthsTable.unlock();
}

void NetworkMessageServiceImpl::cleanOldNeighborQueueLengths (void)
{
    _mQueueLengthsTable.lock();
    for (StringHashtable<ByInterface>::Iterator iInterface = _tQueueLengthByInterface.getAllElements();
         !iInterface.end(); iInterface.nextElement()) {
        for (UInt32Hashtable<ByNeighbor>::Iterator iNeighbor = iInterface.getValue()->_tByNeighbor.getAllElements();
             !iNeighbor.end(); iNeighbor.nextElement()) {
            ByNeighbor* pNeighbor = iNeighbor.getValue();
            //if there has been no update, it means no message from the node has
            // been received. set its queue length to 0
            if (!pNeighbor->_bUpdatedSinceLastCheck) {
                pNeighbor->_ui8QueueLength = 0;
            }
            pNeighbor->_bUpdatedSinceLastCheck = false;
        }
    }
    _mQueueLengthsTable.unlock();
}

void NetworkMessageServiceImpl::deliveryThread (void *pArg)
{
    NetworkMessageServiceImpl *pThis = (NetworkMessageServiceImpl *) pArg;
    QueuedMessage *pQMsg;
    while (!pThis->terminationRequested()) {
        pThis->_mDeliveryQueue.lock();
        while (NULL == (pQMsg = (QueuedMessage*) pThis->_deliveryQueue.dequeue())) {
            if (pThis->terminationRequested()) {
                pThis->_mDeliveryQueue.unlock();
                return;
            }
            pThis->_cvDeliveryQueue.wait (1000);
        }
        pThis->_mDeliveryQueue.unlock();
        pThis->callListeners (pQMsg->pMsg, (const char*) pQMsg->incomingInterface,
                              pQMsg->ulSenderRemoteAddress, pQMsg->i64Timestamp);
        delete pQMsg->pMsg;
        delete pQMsg;
    }
}

int NetworkMessageServiceImpl::setRetransmissionTimeout (uint32 ui32Timeout)
{
    _ui32RetransmissionTimeout = ui32Timeout;
    return 0;
}

NetworkMessageServiceImpl::PeerState::PeerState (void)
{
    ui16SessionId = 0;
    resetMessageHistory();
}

NetworkMessageServiceImpl::UnackedMessageWrapper::UnackedMessageWrapper (NetworkMessage *pNetMsg, bool bDeleteNetMsg)
{
    _pNetMsg = pNetMsg;
    _ui32RetransmitCount = 0;
    _bDeleteNetMsg = bDeleteNetMsg;
    _ppszOutgoingInterfaces = NULL;
}

NetworkMessageServiceImpl::UnackedMessageWrapper::~UnackedMessageWrapper ()
{
    if (_ppszOutgoingInterfaces != NULL) {
        char ** ppszOutgoingInterfaces = (char **) _ppszOutgoingInterfaces;
        for (uint8 i = 0; ppszOutgoingInterfaces[i] != NULL; i++) {
            free (ppszOutgoingInterfaces[i]);
        }
        free (ppszOutgoingInterfaces);
        _ppszOutgoingInterfaces = NULL;
    }
    if (_bDeleteNetMsg) {
        delete _pNetMsg;
        _pNetMsg = NULL;
    }
}
