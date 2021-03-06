/*
 * Publisher.java
 *
 * This file is part of the IHMC Util Library
 * Copyright (c) 1993-2014 IHMC.
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

package us.ihmc.nms;

import java.net.InetAddress;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.common.net.InetAddresses;
import us.ihmc.comm.CommException;
import us.ihmc.comm.CommHelper;
import us.ihmc.comm.ProtocolException;

/**
 * @author Giacomo Benincasa    (gbenincasa@ihmc.us)
 */
class Publisher {
    private final CommHelper _commHelper;
    private final AtomicBoolean _isInitialized;

    Publisher(CommHelper commHelper, AtomicBoolean isInitialized) {
        _commHelper = commHelper;
        _isInitialized = isInitialized;
    }

    void publish(String method, Byte msgType, Collection<String> outgoingInterfaces,
                 String dstAddr, Short ui16MsgId, Byte ui8HopCount, Byte ui8TTL,
                 Short ui16DelayTolerance, byte[] metadata, byte[] data, String hints)
            throws CommException, ProtocolException {
        publish(method, msgType, outgoingInterfaces, dstAddr, ui16MsgId, ui8HopCount,
                ui8TTL, ui16DelayTolerance, metadata, data, false, hints);
    }

    void publish(String method, Byte msgType, Collection<String> outgoingInterfaces,
                 String dstAddr, Short ui16MsgId, Byte ui8HopCount, Byte ui8TTL,
                 Short ui16DelayTolerance, byte[] metadata, byte[] data,
                 boolean bExpedited, String hints)
            throws CommException, ProtocolException {

        try {
            _commHelper.sendLine(method);
            _commHelper.write8(msgType);

            // TODO: implement this method sendCollectionSring into the CommHelper
            for (String iface : outgoingInterfaces) {
                _commHelper.sendStringBlock(iface);
            }
            //send the empty string
            _commHelper.sendStringBlock("");

            //dstAddr
            int ui32dstAddress = InetAddresses.coerceToInteger(InetAddresses.forString(dstAddr));
            _commHelper.writeUI32(ui32dstAddress);
            _commHelper.write16(ui16MsgId);
            _commHelper.write8(ui8HopCount.byteValue());
            _commHelper.write8(ui8TTL.byteValue());
            _commHelper.write16(ui16DelayTolerance);
            _commHelper.write16((short) metadata.length);
            _commHelper.sendBlob(metadata, 0, metadata.length);
            _commHelper.write16((short) data.length);
            _commHelper.sendBlob(data, 0, data.length);
            if (Protocol.BROADCAST_METHOD.compareTo(method) == 0) {
                _commHelper.writeBool(bExpedited);
            }
            _commHelper.sendStringBlock(hints);
            _commHelper.read32();
        } catch (CommException e) {
            _isInitialized.set(false);
            throw (CommException) e;
        }
    }
}

