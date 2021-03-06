/**
 * DSProProxyAdaptor.h
 *
 * This file is part of the IHMC DSPro Library/Component
 * Copyright (c) 2008-2016 IHMC.
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
 */

#ifndef INCL_DISSERVICE_PRO_PROXY_ADOPTOR_H
#define INCL_DISSERVICE_PRO_PROXY_ADOPTOR_H

#include "ControlMessageListener.h"
#include "DSProListener.h"
#include "MatchmakingLogListener.h"
#include "Listener.h"

#include "DisseminationServiceProxyAdaptor.h"
#include "Marshaling.h"

#include "StringHashset.h"

namespace NOMADSUtil
{
    class Logger;
    class Reader;
}

namespace IHMC_VOI
{
    class NodePath;
}

namespace IHMC_ACI
{
    class DSPro;
    class DSProProxyServer;

    class DSProProxyAdaptor : public NOMADSUtil::ManageableThread,
                              public DSProListener,
                              public ControlMessageListener,
                              public MatchmakingLogListener,
                              public SearchListener,
                              public IHMC_MISC::ChunkerInterface,
                              public IHMC_MISC::ChunkReassemblerInterface
    {
        public:
            explicit DSProProxyAdaptor (DSProProxyServer *pDSPProxyServer);
            virtual ~DSProProxyAdaptor (void);

            int init (NOMADSUtil::SimpleCommHelper2 *pCommHelper, uint16 ui16Id);

            void setCallbackCommHelper (NOMADSUtil::SimpleCommHelper2 *pCommHelper);

            uint16 getClientID (void);

            void run (void);

            const char * getNodeId (void);

            // Data Callbacks
            int dataArrived (const char *pszId, const char *pszGroupName,
                             const char *pszObjectId, const char *pszInstanceId,
                             const char *pszAnnotatedObjMsgId, const char *pszMimeType,
                             const void *pBuf, uint32 ui32Len, uint8 ui8NChunks,
                             uint8 ui8TotNChunks, const char *pszQueryId);
            int metadataArrived (const char *pszId, const char *pszGroupName,
                                 const char *pszObjectId, const char *pszInstanceId,
                                 const char *pszXMLMetadada, const char *pszReferredDataId,
                                 const char *pszQueryId);
            int dataAvailable (const char *pszId, const char *pszGroupName,
                               const char *pszObjectId, const char *pszInstanceId,
                               const char *pszReferredDataId, const char *pszMimeType,
                               const void *pMetadata, uint32 ui32MetadataLength,
                               const char *pszQueryId);

            // Topology Callbacks
            void newPeer (const char *pszPeerNodeId);
            void deadPeer (const char *pszPeerNodeId);

            bool pathRegistered (IHMC_VOI::NodePath *pNodePath, const char *pszNodeId,
                                 const char *pszTeam, const char *pszMission);
            bool positionUpdated (float latitude, float longitude, float altitude,
                                  const char *pszNodeId);

            // Logging Callbacks
            bool informationMatched (const char *pszLocalNodeID, const char *pszPeerNodeID,
                                     const char *pszMatchedObjectID, const char *pszMatchedObjectName,
                                     const char **ppszRankDescriptors, float *pRanks, float *pWeights,
                                     uint8 ui8Len, const char *pszComment, const char *pszOperation);
            bool informationSkipped (const char *pszLocalNodeID, const char *pszPeerNodeID,
                                     const char *pszSkippedObjectID, const char *pszSkippedObjectName,
                                     const char **ppszRankDescriptors, float *pRanks, float *pWeights,
                                     uint8 ui8Len, const char *pszComment, const char *pszOperation);

            bool contextUpdateMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool contextVersionMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool messageRequestMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool chunkRequestMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool positionMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool searchMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool topologyReplyMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool topologyRequestMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool updateMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool versionMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool waypointMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);
            bool wholeMessageArrived (const char *pszSenderNodeId, const char *pszPublisherNodeId);

            void searchArrived (const char *pszQueryId, const char *pszGroupName,  const char *pszQuerier,
                                const char *pszQueryType, const char *pszQueryQualifiers, const void *pszQuery,
                                unsigned int uiQueryLen);
            void searchReplyArrived (const char *pszQueryId, const char **ppszMatchingMessageIds, const char *pszMatchingNodeId);
            void volatileSearchReplyArrived (const char *pszQueryId, const void *pReply, uint16 ui162ReplyLen, const char *pszMatchingNodeId);

            // Chunking Plugin Callbacks
            NOMADSUtil::PtrLList<IHMC_MISC::Chunker::Fragment> * fragmentBuffer (const void *pBuf, uint32 ui32Len, const char *pszInputChunkMimeType,
                                                                                 uint8 ui8NoOfChunks, const char *pszOutputChunkMimeType,
                                                                                 uint8 ui8ChunkCompressionQuality);
            NOMADSUtil::PtrLList<IHMC_MISC::Chunker::Fragment> * fragmentFile (const char *pszFileName, const char *pszInputChunkMimeType,
                                                                               uint8 ui8NoOfChunks, const char *pszOutputChunkMimeType,
                                                                               uint8 ui8ChunkCompressionQuality);
            IHMC_MISC::Chunker::Fragment * extractFromBuffer (const void *pBuf, uint32 ui32Len, const char *pszInputChunkMimeType,
                                                              const char *pszOutputChunkMimeType, uint8 ui8ChunkCompressionQuality,
                                                              IHMC_MISC::Chunker::Interval **ppPortionIntervals);
            IHMC_MISC::Chunker::Fragment * extractFromFile (const char *pszFileName, const char *pszInputChunkMimeType,
                                                            const char *pszOutputChunkMimeType, uint8 ui8ChunkCompressionQuality,
                                                            IHMC_MISC::Chunker::Interval **ppPortionIntervals);

            NOMADSUtil::BufferReader * reassemble (NOMADSUtil::DArray2<NOMADSUtil::BufferReader> *pFragments,
                                                   IHMC_MISC::Annotations *pAnnotations, const char *pszChunkMimeType,
                                                   uint8 ui8NoOfChunks, uint8 ui8CompressionQuality);

        protected:
            bool ctrlMsgArrived (const char *pszType, const char *pszSenderNodeId, const char *pszPublisherNodeId);

            virtual bool doGetDisService (CommHelperError & error);

            bool doAddUserId (CommHelperError & error);
            bool doSetSelectivity (CommHelperError & error);
            bool doSetRangeOfInluence (CommHelperError & error);
            bool doSetDefUsefulDistance (CommHelperError & error);
            bool doSetUsefulDistance (CommHelperError & error);
            bool doSetRankingWeights (CommHelperError & error);

            bool doSetMissionId (CommHelperError & error);
            bool doSetRole (CommHelperError & error);
            bool doSetTeam (CommHelperError & error);
            bool doSetNodeType (CommHelperError & error);
            bool doAddCustumPoliciesAsXML (CommHelperError & error);
            bool doCancel (CommHelperError & error);
            bool doCancelByObjectAndInstanceId (CommHelperError & error);
            bool doChangeEncryptionKey (CommHelperError & error);
            bool doDisseminate (CommHelperError & error);
            bool doDisseminateMetadata (CommHelperError & error, bool bReadMimeTypeAndMetadata = true);
            bool doConfigureProperties (CommHelperError & error);
            bool doRegisterPath (CommHelperError & error);
            bool doSetCurrentPath (CommHelperError & error);
            bool doGetCurrentPath (CommHelperError & error);
            bool doSetCurrentPosition (CommHelperError & error);
            bool doSetBatteryLevel (CommHelperError & error);
            bool doSetMemoryAvailable (CommHelperError & error);
            bool doAddPeer (CommHelperError & error);
            bool doGetPeerNodeContext (CommHelperError & error);
            bool doGetAdaptorType (CommHelperError & error);
            bool doGetData (CommHelperError & error);
            bool doGetMatchingMetaDataAsJson (CommHelperError & error);
            bool doGetNodeContext (CommHelperError & error);
            bool doGetNodeId (CommHelperError & error);
            bool doGetPeerMsgCounts(CommHelperError & error);
            bool doGetPathForPeer (CommHelperError & error);
            bool doGetPeerList (CommHelperError & error);
            bool doGetSessionId (CommHelperError & error);
            bool doNotUseful (CommHelperError & error);
            bool doSearch (CommHelperError & error);
            bool doReplyToQuery (CommHelperError & error);
            bool doReplyToVolatileQuery (CommHelperError & error);
            bool doAddMessage (CommHelperError & error);
            bool doAddMessage_AVList (CommHelperError & error);
            bool doAddChunk (CommHelperError & error);
            bool doAddChunk_AVList (CommHelperError & error);
            bool doAddAdditionalChunk (CommHelperError & error);
            bool doAddChunkedMessage (CommHelperError & error, bool bSingleChunk = false);
            bool doAddChunkedMessage_AVList (CommHelperError & error, bool bSingleChunk = false);
            bool doChunkAndAddMessage (CommHelperError & error);
            bool doChunkAndAddMessage_AVList (CommHelperError & error);
            bool doAddAnnotation (CommHelperError & error);
            bool doAddAnnotationRef (CommHelperError & error);
            bool doRequestCustomAreaChunk (CommHelperError & error);
            bool doRequestCustomTimeChunk (CommHelperError & error);
            bool doRequestMoreChunks (CommHelperError & error);
            bool doSubscribe (CommHelperError & error);

            bool doRegisterChunkFragmenter (CommHelperError & error);
            bool doRegisterChunkReassembler (CommHelperError & error);

            bool doRegisterPathRegisteredCallback (void);
            bool doRegisterCtrlMsgCallback (void);
            bool doRegisterMatchmakingLogCallback (void);
            bool doRegisterSearchCallback (void);
            bool doDeregisterSearchCallback (void);
            bool doResetTransmissionCounters (CommHelperError & error);

            bool doGetDSProIds (CommHelperError & error);

            bool matchmakingLogListenerCallback (const char *pszLocalNodeID, const char *pszPeerNodeID, const char *pszSkippedObjectID,
                                                 const char *pszSkippedObjectName, const char **ppszRankDescriptors,
                                                 float *pRanks, float *pWeights, uint8 ui8Len, const char *pszComment, bool bSkipped,
                                                 const char *pszOperation);

            CommHelperError readGroupObjectIdInstanceId (NOMADSUtil::String &group, NOMADSUtil::String &objectId, NOMADSUtil::String &instanceId);
            CommHelperError readObjectIdInstanceId (NOMADSUtil::String &objectId, NOMADSUtil::String &instanceId);
            CommHelperError readMetadataAsString (NOMADSUtil::Reader *pReader, NOMADSUtil::String &sMetadata);

        private:
            DSPro *_pDSPro;
            DSProProxyServer *_pDisSvcProProxyServer;
            NOMADSUtil::SimpleCommHelper2 *_pCommHelper;
            NOMADSUtil::SimpleCommHelper2 *_pCallbackCommHelper;
            uint16 _ui16ClientID;
            uint16 _ui16PathRegisteredCbackClientId;
            uint16 _ui16CtrlMsgCbackClientId;
            uint16 _ui16MatchmakingCbackClientId;
            uint16 _ui16SearchListenerClientID;
            bool _bListenerProRegistered;
            bool _bCtrlMsgListenerRegistered;
            bool _bMatchmakingLogListenerRegistered;
            bool _bSearchListenerRegistered;

            NOMADSUtil::Mutex _mChunkers;
            NOMADSUtil::Mutex _mReassemblers;
            NOMADSUtil::StringHashset _registeredChunkers;
            NOMADSUtil::StringHashset _registeredReassemblers;

            static const unsigned int BUF_LEN = 1024;
            char _buf[BUF_LEN];
    };
}

#endif // INCL_DISSERVICE_PRO_PROXY_ADOPTOR_H
