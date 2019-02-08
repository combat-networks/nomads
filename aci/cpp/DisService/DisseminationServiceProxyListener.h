/*
 * DisseminationServiceProxyListener.h
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
 */

#ifndef INCL_DISSEMINATION_SERVICE_PROXY_LISTENER_H
#define INCL_DISSEMINATION_SERVICE_PROXY_LISTENER_H

namespace IHMC_ACI
{
    class DisseminationServiceProxyListener
    {
        public:
            virtual ~DisseminationServiceProxyListener (void);

            /**
             * Callback function that is invoked when new data arrives.
             *
             * pszSender - id of the sender.
             *
             * pszGroupName - the group to which the message was addressed.
             *
             * pszId - id of the message.
             *
             * pData - the data that was received.
             *
             * ui32Length - the length of the data in bytes.
             *
             * ui16HistoryWindow - the number of messages previously transmitted that are recommended to be
             *                     retrieved before processing the current message.
             *
             * ui16Tag - the tag that was specified for the message.
             *
             * ui8Priority - the priority value that was specified for the message.
             */
            virtual bool dataArrived (const char *pszSender, const char *pszGroupName, uint32 ui32SeqId,
                                      const char *pszObjectId, const char *pszInstanceId, const char *pszMimeType,
                                      const void *pData, uint32 ui32Length, uint32 ui32MetadataLength,
                                      uint16 ui16Tag, uint8 ui8Priority, const char *pszQueryId) = 0;

            virtual bool chunkArrived (const char *pszSender, const char *pszGroupName, uint32 ui32SeqId, const char *pszObjectId,
                                       const char *pszInstanceId, const char *pszMimeType, const void *pChunk, uint32 ui32Length,
                                       uint8 ui8NChunks, uint8 ui8TotNChunks, const char *pszChunkedMsgId,
                                       uint16 ui16Tag, uint8 ui8Priority, const char *pszQueryId) = 0;

            /**
             * Callback function that is invoked when new metadata arrives.
             *
             * pszSender - id of the sender.
             *
             * pszGroupName - the group to which the message was addressed.
             *
             * pszId - id of the message.
             *
             * pMetadata - the metadata that was received.
             *
             * ui32MetadataLength - the length of the metadata in bytes.
             *
             * ui16HistoryWindow - the number of messages previously transmitted that are recommended to be
             *                     retrieved before processing the current message.
             *
             * ui16Tag - the tag that was specified for the message.
             *
             * ui8Priority - the priority value that was specified for the message.
             */
            virtual bool metadataArrived (const char *pszSender, const char *pszGroupName, uint32 ui32SeqId,
                                          const char *pszObjectId, const char *pszInstanceId, const char *pszMimeType,
                                          const void *pMetadata, uint32 ui32MetadataLength, bool bDataChunked,
                                          uint16 ui16Tag, uint8 ui8Priority, const char *pszQueryId) = 0;

            /**
             * Callback function that is invoked when new metadata arrives.
             *
             * pszSender - id of the sender.
             *
             * pszGroupName - the group to which the message was addressed.
             *
             * pszId - id of the message.
             *
             * pMetadata - the metadata that was received.
             *
             * ui32MetadataLength - the length of the metadata in bytes.
             *
             * ui16HistoryWindow - the number of messages previously transmitted that are recommended to be
             *                     retrieved before processing the current message.
             *
             * ui16Tag - the tag that was specified for the message.
             *
             * ui8Priority - the priority value that was specified for the message.
             */
            virtual bool dataAvailable (const char *pszSender, const char *pszGroupName, uint32 ui32SeqId,
                                        const char *pszObjectId, const char *pszInstanceId, const char *pszMimeType,
                                        const char *pszId, const void *pMetadata, uint32 ui32MetadataLength,
                                        uint16 ui16Tag, uint8 ui8Priority, const char *pszQueryId) = 0;

            virtual void serverConnected (void) {};
            virtual void serverDisconnected (void) {};
    };

    inline DisseminationServiceProxyListener::~DisseminationServiceProxyListener (void)
    {
    }
}

#endif   // #ifndef INCL_DISSEMINATION_SERVICE_PROXY_LISTENER_H
