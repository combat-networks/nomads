#ifndef INCL_PROXY_COMM_INTERFACE_H
#define INCL_PROXY_COMM_INTERFACE_H

/*
 * ProxyCommInterface.h
 *
 * This file is part of the IHMC Mockets Library/Component
 * Copyright (c) 2002-2014 IHMC.
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

#include "CommInterface.h"

#include "InetAddr.h"
#include "ProxyDatagramSocket.h"
#include "StrClass.h"


class ProxyCommInterface : public CommInterface
{
    public:
        ProxyCommInterface (const char *pszProxyServerAddr, uint16 ui16ProxyServerPort);
        virtual ~ProxyCommInterface (void);

        virtual CommInterface * newInstance (void);

        virtual int bind (uint16 ui16Port);
        virtual int bind (NOMADSUtil::InetAddr *pLocalAddr);
        virtual NOMADSUtil::InetAddr getLocalAddr (void);
        virtual int getLocalPort (void);
        virtual int close (void);
        virtual int shutdown (bool bReadMode, bool bWriteMode);
        virtual int setReceiveTimeout (uint32 ui32TimeoutInMS);
        virtual int setReceiveBufferSize (uint32 ui32BufferSize);
        virtual int sendTo (NOMADSUtil::InetAddr *pRemoteAddr, const void *pBuf, int iBufSize, const char *pszHints = nullptr);
        virtual int receive (void *pBuf, int iBufSize, NOMADSUtil::InetAddr *pRemoteAddr);
        virtual int getLastError (void);
        virtual int isRecoverableSocketError (void);

    private:
        NOMADSUtil::String _proxyServerAddr;
        uint16 _ui16ProxyServerPort;
        NOMADSUtil::ProxyDatagramSocket *_pPDGS;
};

#endif   // #ifndef INCL_PROXY_COMM_INTERFACE_H
