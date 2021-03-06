#ifndef INCL_ACTIVE_CONNECTION_H
#define INCL_ACTIVE_CONNECTION_H

/*
 * ActiveConnection.h
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
 *
 * Class that keeps track of all active connections
 * with a single instance of a remote NetProxy.
 */

#include "Utilities.h"


namespace ACMNetProxy
{
    class Connection;


    class ActiveConnection
    {
    public:
        ActiveConnection (void);
        ActiveConnection (Connection * const pConnection);
        ~ActiveConnection (void);

        const bool isAnyConnectionActive (void) const;
        Connection * const getActiveConnection (ConnectorType connectorType, EncryptionType encryptionType) const;

        Connection * const setNewActiveConnection (Connection * const pActiveConnection);
        Connection * const removeActiveConnection (const Connection * const pActiveConnection);


    private:
        Connection * const removeActiveConnectionByType (ConnectorType connectorType, EncryptionType encryptionType);


        Connection * _connectionTable[CT_SIZE][ET_SIZE];
    };


    inline ActiveConnection::ActiveConnection(void) :
        _connectionTable{nullptr}
    { }

    inline ActiveConnection::~ActiveConnection (void) { }

    inline const bool ActiveConnection::isAnyConnectionActive (void) const
    {
        for (ConnectorType ct : CT_AVAILABLE) {
            for (EncryptionType et : ET_AVAILABLE) {
                if (_connectionTable[ct][et - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

    inline Connection * const ActiveConnection::getActiveConnection (ConnectorType connectorType, EncryptionType encryptionType) const
    {
        // Temporary hacks because no encryption is available for TCP and UDP
        if (connectorType == CT_TCPSOCKET) {
            return _connectionTable[CT_TCPSOCKET][ET_PLAIN - 1];
        }
        if (connectorType == CT_UDPSOCKET) {
            return _connectionTable[CT_UDPSOCKET][ET_PLAIN - 1];
        }

        return _connectionTable[connectorType][encryptionType - 1];
    }

    // This method is private and should only be invoked with a MOCKETS, SOCKET, or CSR connectorType
    inline Connection * const ActiveConnection::removeActiveConnectionByType (ConnectorType connectorType, EncryptionType encryptionType)
    {
        auto * const pOldConnection = getActiveConnection (connectorType, encryptionType);
        _connectionTable[connectorType][encryptionType - 1] = nullptr;

        return pOldConnection;
    }

}

#endif  // INCL_ACTIVE_CONNECTION_H
