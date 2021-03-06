/*
 * NetworkInterface.cpp
 *
 * This file is part of the IHMC NetProxy Library/Component
 * Copyright (c) 2010-2018 IHMC.
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

#include <stdio.h>
#if defined (WIN32)
    #include <winsock2.h>
    #include <iphlpapi.h>
    #define stricmp _stricmp

    #define MALLOC(x) HeapAlloc(GetProcessHeap(), 0, (x))
    #define FREE(x) HeapFree(GetProcessHeap(), 0, (x))
#elif defined (UNIX)
    #include <unistd.h>
    #include <errno.h>
    #include <net/if.h>
    #include <sys/ioctl.h>
    #include <sys/socket.h>
    #include <net/if.h>
    #include <arpa/inet.h>
    #include <linux/netlink.h>
    #include <linux/rtnetlink.h>
    #define stricmp strcasecmp
#endif

#include "InetAddr.h"
#include "Logger.h"

#include "NetworkInterface.h"

#define BUFFER_SIZE 4096


using namespace ACMNetProxy;

#define checkAndLogMsg(_f_name_, _log_level_, ...) \
    if (NOMADSUtil::pLogger && (NOMADSUtil::pLogger->getDebugLevel() >= _log_level_)) \
        NOMADSUtil::pLogger->logMsg (_f_name_, _log_level_, __VA_ARGS__)

NetworkInterface::NetworkInterface (Type tType, const std::string & sInterfaceName, const std::string & sUserFriendlyInterfaceName) :
    _sInterfaceName{sInterfaceName}, _sUserFriendlyInterfaceName{(sUserFriendlyInterfaceName == "") ? sInterfaceName : sUserFriendlyInterfaceName},
    _tType{tType}, _aui8MACAddr{}, _ipv4Addr{0}, _ipv4Netmask{0}, _ipv4DefaultGateway{0}, _ui16MTU{0}, _bMACAddrFound{false}, _bIPAddrFound{false},
    _bNetmaskFound{false}, _bDefaultGatewayFound{false}, _bMTUFound{false}, _bIsTerminationRequested{false}
{ }

std::string NetworkInterface::getDeviceNameFromUserFriendlyName (const char * const pcUserFriendlyInterfaceName)
{
    #if defined (WIN32)
    DWORD dwRetVal;
    ULONG ulFamily = 0, ulFlags = 0, ulOutBufLen = 1024U * 15U;       // Windows API Documentation recommends a 15KB buffer
    std::string sDeviceName;
    auto * pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
    memset (pAddresses, 0, ulOutBufLen);
    dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
    if (dwRetVal == ERROR_BUFFER_OVERFLOW) {
        FREE (pAddresses);
        // Try once again, increasing the buffer size - the needed buffer size is returned back in ulOutBufLen
        ulOutBufLen += 2048;       // Just for good measure
        pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
        memset (pAddresses, 0, ulOutBufLen);
        dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
    }
    if (dwRetVal == NO_ERROR) {
        const auto * pCurrAddress = pAddresses;
        while (pCurrAddress != nullptr) {
            // GetAdaptersAddresses uses wchar's for the FriendlyName - need to convert it first
            size_t len = wcslen (pCurrAddress->FriendlyName) * 2 + 1;
            char *pszFriendlyName = (char*) malloc (len);
            pszFriendlyName[0] = 0;
            wcstombs (pszFriendlyName, pCurrAddress->FriendlyName, len);
            if (0 == stricmp (pszFriendlyName, pcUserFriendlyInterfaceName)) {
                // Found the device
                free (pszFriendlyName);
                sDeviceName = pCurrAddress->AdapterName;
                break;
            }
            free (pszFriendlyName);
            pCurrAddress = pCurrAddress->Next;
        }
        FREE (pAddresses);
    }
    return sDeviceName;
    #else
        return std::string{pcUserFriendlyInterfaceName};
    #endif

}

const uint8 * const NetworkInterface::getMACAddrForDevice (const char * const pcInterfaceName)
{
    #if defined (WIN32)
        DWORD dwRetVal;
        ULONG ulFlags = 0, ulFamily = 0, ulOutBufLen = 1024U * 15U;     // Windows API Documentation recommends a 15KB buffer
        uint8 *pui8MACAddr = nullptr;
        auto * pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
        memset (pAddresses, 0, ulOutBufLen);
        dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
        if (dwRetVal == ERROR_BUFFER_OVERFLOW) {
            FREE (pAddresses);
            // Try once again, increasing the buffer size - the needed buffer size is returned back in ulOutBufLen
            ulOutBufLen += 2048;       // Just for good measure
            pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
            memset (pAddresses, 0, ulOutBufLen);
            dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
        }
        if (dwRetVal == NO_ERROR) {
            const auto * pCurrAddress = pAddresses;
            while (pCurrAddress != nullptr) {
                // GetAdaptersAddresses uses wchar's for the FriendlyName - need to convert it first
                size_t len = strlen (pCurrAddress->AdapterName) + 1;
                ci_string sIFAdapterName{pCurrAddress->AdapterName};
                if (sIFAdapterName == pcInterfaceName) {
                    // Found the device
                    printf ("IfIndex = %d; Length = %d\n", pCurrAddress->IfIndex, pCurrAddress->Length);
                    printf ("LUID.Info.IfType = %I64d; LUID.Info.NetLuidIndex = %I64d; LUID.Value = %I64d\n",
                            pCurrAddress->Luid.Info.IfType, pCurrAddress->Luid.Info.NetLuidIndex, pCurrAddress->Luid.Value);
                    pui8MACAddr = new uint8 [pCurrAddress->PhysicalAddressLength];
                    memcpy (pui8MACAddr, pCurrAddress->PhysicalAddress, pCurrAddress->PhysicalAddressLength);
                    char szGUID[64];
                    sprintf_s (szGUID, 64, "{%08x-%04x-%04x-%02X%02X-%02X%02X%02X%02X%02X%02X}",
                               pCurrAddress->NetworkGuid.Data1, pCurrAddress->NetworkGuid.Data2, pCurrAddress->NetworkGuid.Data3,
                               pCurrAddress->NetworkGuid.Data4[0], pCurrAddress->NetworkGuid.Data4[1],
                               pCurrAddress->NetworkGuid.Data4[2], pCurrAddress->NetworkGuid.Data4[3],
                               pCurrAddress->NetworkGuid.Data4[4], pCurrAddress->NetworkGuid.Data4[5],
                               pCurrAddress->NetworkGuid.Data4[6], pCurrAddress->NetworkGuid.Data4[7]);
                    printf ("Network GUID = %s\n", szGUID);
                    auto ema = buildEthernetMACAddressFromArray (pui8MACAddr);
                    printf ("MAC Address is <%s>\n", etherMACAddrToString (ema).c_str());
                    break;
                }
                pCurrAddress = pCurrAddress->Next;
            }
        }

        FREE (pAddresses);
        return pui8MACAddr;

    #elif defined (UNIX)
        struct if_nameindex *pIfList, *pIfListItem;
        pIfList = pIfListItem = nullptr;
        pIfList = if_nameindex();
        if (pIfList == nullptr) {
            checkAndLogMsg ("NetworkInterface::getMACAddrForDevice", NOMADSUtil::Logger::L_MildError,
                            "could not obtain list of interfaces\n");
            return nullptr;
        }
        for (pIfListItem = pIfList; pIfListItem->if_index != 0; pIfListItem++) {
            if (0 == stricmp (pIfListItem->if_name, pcInterfaceName)) {
                // Found the interface - now obtain the MAC address
                int iSocket = socket (PF_INET, SOCK_STREAM, 0);
                if (iSocket < 0) {
                    checkAndLogMsg ("NetworkInterface::getMACAddrForDevice", NOMADSUtil::Logger::L_MildError,
                                    "could not create a socket\n");
                    if_freenameindex (pIfList);
                    return nullptr;
                }
                struct ifreq ifReq;
                strcpy (ifReq.ifr_name, pIfListItem->if_name);
                if (0 != ioctl (iSocket, SIOCGIFHWADDR, &ifReq)) {
                    checkAndLogMsg ("NetworkInterface::getMACAddrForDevice", NOMADSUtil::Logger::L_MildError,
                                    "could not obtain MAC address for interface %s\n",
                                    pcInterfaceName);
                    if_freenameindex (pIfList);
                    close (iSocket);
                    return nullptr;
                }
                uint8 *pui8MACAddr = new uint8[6];
                memcpy (pui8MACAddr, &ifReq.ifr_ifru.ifru_hwaddr.sa_data[0], 6);
                if_freenameindex (pIfList);
                close (iSocket);
                return pui8MACAddr;
            }
        }
        if_freenameindex (pIfList);
        checkAndLogMsg ("NetworkInterface::getMACAddrForDevice", NOMADSUtil::Logger::L_MildError,
                        "could not find interface %s\n",
                        pcInterfaceName);

        return nullptr;
    #endif
}

NOMADSUtil::IPv4Addr NetworkInterface::getDefaultGatewayForInterface (const char * const pcInterfaceName)
{
    NOMADSUtil::IPv4Addr res{0};
    #if defined (WIN32)
        DWORD dwRetVal = 0;
        ULONG ulOutBufLen = sizeof(IP_ADAPTER_INFO);
        auto * pAdapterInfo = reinterpret_cast<IP_ADAPTER_INFO *> (malloc (ulOutBufLen));
        if (!pAdapterInfo) {
            checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                            "Error allocating memory needed to call GetAdaptersinfo()\n");
            return res;
        }

        // Make an initial call to GetAdaptersInfo to get the necessary size into the ulOutBufLen variable
        if (GetAdaptersInfo (pAdapterInfo, &ulOutBufLen) == ERROR_BUFFER_OVERFLOW) {
            free (pAdapterInfo);
            pAdapterInfo = reinterpret_cast<IP_ADAPTER_INFO *> (malloc (ulOutBufLen));
            if (!pAdapterInfo) {
                checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                                "Error allocating memory needed to call GetAdaptersinfo()\n");
                return res;
            }
        }

        if ((dwRetVal = GetAdaptersInfo (pAdapterInfo, &ulOutBufLen)) == NO_ERROR) {
            const auto * pAdapter = pAdapterInfo;
            while (pAdapter) {
                if (!stricmp (pAdapter->AdapterName, pcInterfaceName)) {
                    res.ui32Addr = NOMADSUtil::InetAddr{pAdapter->GatewayList.IpAddress.String}.getIPAddress();
                    break;
                }
                pAdapter = pAdapter->Next;
            }
        }
        else {
            checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                            "GetAdaptersInfo() failed with error: %d\n", dwRetVal);
        }

        if (res.ui32Addr != 0) {
            printf ("\t\tGateway: %s\n", NOMADSUtil::InetAddr{res.ui32Addr}.getIPAsString());
        }
        else {
            printf ("\t\tGateway: <not found>\n");
        }

        if (pAdapterInfo) {
            free (pAdapterInfo);
        }

    #elif defined (UNIX)
        int rc = 0, route_attribute_len = 0, sock = -1;
        unsigned int received_bytes = 0, msg_len = 0, msgseq = 0;
        char gateway_address[INET_ADDRSTRLEN], interface[IF_NAMESIZE];
        char msgbuf[BUFFER_SIZE], buffer[BUFFER_SIZE];
        char *ptr = buffer;
        struct timeval tv;
        struct nlmsghdr *nlh, *nlmsg;
        struct rtmsg *route_entry;
        struct rtattr *route_attribute;         // This struct contain route attributes (route type)

        if ((sock = socket(AF_NETLINK, SOCK_RAW, NETLINK_ROUTE)) < 0) {
            checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                            "socket() failed with error: %d\n", errno);
            return res;
        }

        // Reset all allocated memory
        memset (msgbuf, 0, sizeof(msgbuf));
        memset (gateway_address, 0, sizeof(gateway_address));
        memset (interface, 0, sizeof(interface));
        memset (buffer, 0, sizeof(buffer));

        // point the header and the msg structure pointers into the buffer
        nlmsg = (struct nlmsghdr *)msgbuf;

        // Fill in the nlmsg header
        nlmsg->nlmsg_len = NLMSG_LENGTH (sizeof(struct rtmsg));
        nlmsg->nlmsg_type = RTM_GETROUTE;                   // Get the routes from kernel routing table.
        nlmsg->nlmsg_flags = NLM_F_DUMP | NLM_F_REQUEST;    // The message is a request for dump.
        nlmsg->nlmsg_seq = msgseq++;                        // Sequence of the message packet.
        nlmsg->nlmsg_pid = getpid();                        // PID of process sending the request.

        // 1 Sec Timeout to avoid stall
        tv.tv_sec = 1;
        setsockopt (sock, SOL_SOCKET, SO_RCVTIMEO, (struct timeval *) &tv, sizeof(struct timeval));
        if (send (sock, nlmsg, nlmsg->nlmsg_len, 0) < 0) {
            // send msg
            checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                            "send() failed with error: %d\n", errno);
            return res;
        }

        do
        {
            // receive response
            rc = recv (sock, ptr, sizeof(buffer) - msg_len, 0);
            if (rc < 0) {
                checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_SevereError,
                                "recv() from socket failed with error: %d\n", errno);
                return res;
            }

            received_bytes = static_cast<unsigned int> (rc);
            nlh = (struct nlmsghdr *) ptr;
            // Check if the header is valid
            if ((NLMSG_OK (nlmsg, received_bytes) == 0) || (nlmsg->nlmsg_type == NLMSG_ERROR))
            {
                checkAndLogMsg ("NetworkInterface::getDefaultGatewayForInterface", NOMADSUtil::Logger::L_MildError,
                                "error in the packet received from kernel\n");
                return res;
            }

            // If we received all data break
            if (nlh->nlmsg_type == NLMSG_DONE) {
                break;
            }
            else {
                ptr += received_bytes;
                msg_len += received_bytes;
            }

            // Break if its not a multi part message
            if ((nlmsg->nlmsg_flags & NLM_F_MULTI) == 0) {
                break;
            }
        }
        while ((nlmsg->nlmsg_seq != msgseq) || (nlmsg->nlmsg_pid != getpid()));

        // parse response
        for (; NLMSG_OK (nlh, received_bytes); nlh = NLMSG_NEXT (nlh, received_bytes))
        {
            // Get the route data
            route_entry = (struct rtmsg *) NLMSG_DATA (nlh);
            if (route_entry->rtm_table != RT_TABLE_MAIN) {
                // We are just interested in main routing table
                continue;
            }

            route_attribute = (struct rtattr *) RTM_RTA (route_entry);
            route_attribute_len = RTM_PAYLOAD (nlh);
            for (; RTA_OK (route_attribute, route_attribute_len); route_attribute = RTA_NEXT (route_attribute, route_attribute_len)) {
                // Loop through all attributes
                switch (route_attribute->rta_type) {
                case RTA_OIF:
                    if_indextoname (*(int *) RTA_DATA (route_attribute), interface);
                    break;
                case RTA_GATEWAY:
                    inet_ntop (AF_INET, RTA_DATA (route_attribute), gateway_address, sizeof(gateway_address));
                    break;
                default:
                    break;
                }
            }

            if ((*gateway_address) && !stricmp (interface, pcInterfaceName)) {
                fprintf(stdout, "\t\tGateway: %s\n", gateway_address);
                res.ui32Addr = NOMADSUtil::InetAddr{gateway_address}.getIPAddress();
                break;
            }
        }
        close(sock);
    #endif

    return res;
}

const uint32 NetworkInterface::retrieveMTUForInterface (const char * const pcInterfaceName, int fd) {
    uint32 ui32MTU = 0;

    #if defined (WIN32)
        DWORD dwRetVal;
        ULONG ulFlags = 0, ulFamily = 0, ulOutBufLen = 1024U * 15U;     // Windows API Documentation recommends a 15KB buffer
        uint8 *pui8MACAddr = nullptr;
        auto * pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
        memset (pAddresses, 0, ulOutBufLen);
        dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
        if (dwRetVal == ERROR_BUFFER_OVERFLOW) {
            FREE (pAddresses);
            // Try once again, increasing the buffer size - the needed buffer size is returned back in ulOutBufLen
            ulOutBufLen += 2048;       // Just for good measure
            pAddresses = reinterpret_cast<IP_ADAPTER_ADDRESSES *> (MALLOC (ulOutBufLen));
            memset (pAddresses, 0, ulOutBufLen);
            dwRetVal = GetAdaptersAddresses (ulFamily, ulFlags, nullptr, pAddresses, &ulOutBufLen);
        }
        if (dwRetVal == NO_ERROR) {
            const auto * pCurrAddress = pAddresses;
            while (pCurrAddress != nullptr) {
                // GetAdaptersAddresses uses wchar's for the FriendlyName - need to convert it first
                size_t len = strlen (pCurrAddress->AdapterName) + 1;
                ci_string sIFAdapterName{pCurrAddress->AdapterName};
                if (sIFAdapterName == pcInterfaceName) {
                    // Found the device
                    if (pCurrAddress->Mtu > 0) {
                        checkAndLogMsg ("NetworkInterface::retrieveMTUForInterface", NOMADSUtil::Logger::L_Info,
                                        "found MTU for interface %wS: %d\n", pCurrAddress->FriendlyName, pCurrAddress->Mtu);
                        ui32MTU = pCurrAddress->Mtu;
                    }
                    else {
                        checkAndLogMsg ("NetworkInterface::retrieveMTUForInterface", NOMADSUtil::Logger::L_Warning,
                                        "found MTU of 0 bytes for interface %wS\n", pCurrAddress->FriendlyName);
                    }
                    break;
                }
                pCurrAddress = pCurrAddress->Next;
            }
        }

        FREE (pAddresses);

    #elif defined (UNIX)
        struct ifreq ifr;

        memset (&ifr, 0, sizeof(ifr));
        strncpy (ifr.ifr_name, pcInterfaceName, sizeof(ifr.ifr_name));

        if (ioctl (fd, SIOCGIFMTU, &ifr) == -1) {
            checkAndLogMsg ("NetworkInterface::retrieveMTUForInterface", NOMADSUtil::Logger::L_SevereError,
                            "ioctl() on file descriptor %d returned with error code %d\n", fd, errno);
        }

        ui32MTU = ifr.ifr_mtu;
    #endif

    return ui32MTU;
}
