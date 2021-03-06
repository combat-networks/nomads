/*
 * PushReplicationController.h
 *
 * This file is part of the IHMC DisService Library/Component
 * Copyright (c) 2006-2016 IHMC.
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
 * Created on January 25, 2009, 6:35 PM
 */

#ifndef INCL_PUSH_REPLICATION_CONTROLLER_H
#define	INCL_PUSH_REPLICATION_CONTROLLER_H

#include "DataCacheReplicationController.h"

#include "ConditionVariable.h"
#include "ManageableThread.h"
#include "Mutex.h"
#include "PtrQueue.h"
#include "StringHashtable.h"

namespace NOMADSUtil
{
    class String;
}

namespace IHMC_ACI
{
    /**
     * DataCacheReplicationController implementation with a PUSHER behaviour.
     *
     * PushReplicationController keeps track of the peers he has come in contact with
     * and the time of the last replication to the peer.
     *
     * If PushReplicationController can retrieve the subscription information of the
     * new peer, it replicates all the messages matching the new peer's subscription
     * since the last replication to the node until current time.
     *
     * If the new node's subsctiptions can not be retrieved all the messages in the
     * cache since the last replication to the node until current time are replicated.
     */
    class DisServiceCacheEmptyMsg;

    class PushReplicationController : public DataCacheReplicationController
    {
        public:
            PushReplicationController (DisseminationService *pDisService,
                                       bool bRequireAck = DataCacheReplicationController::DEFAULT_REQUIRE_ACK);
            virtual ~PushReplicationController();

            virtual void newNeighbor (const char *pszNodeUUID, const char *pszPeerRemoteAddr,
                                      const char *pszIncomingInterface);
            virtual void deadNeighbor (const char *pszNodeUUID);
            virtual void newLinkToNeighbor (const char *pszNodeUID, const char *pszPeerRemoteAddr,
                                            const char *pszIncomingInterface);
            virtual void droppedLinkToNeighbor (const char *pszNodeUID, const char *pszPeerRemoteAddr);
            virtual void stateUpdateForPeer (const char *pszNodeUID, PeerStateUpdateInterface *pUpdate);
            virtual void dataCacheUpdated (MessageHeader *pMH, const void *pPayLoad);

        protected:
            virtual void disServiceControllerMsgArrived (ControllerToControllerMsg *pCtrlMsg);
            virtual void disServiceControlMsgArrived (DisServiceCtrlMsg *pCtrlMsg);
            virtual void disServiceDataMsgArrived (DisServiceDataMsg *pDataMsg);

        private:
            int64 _i64LastCacheUpdate;

            NOMADSUtil::ConditionVariable _cv;
            NOMADSUtil::Mutex _m;
    };
}

#endif  // INCL_PUSH_REPLICATION_CONTROLLER_H
