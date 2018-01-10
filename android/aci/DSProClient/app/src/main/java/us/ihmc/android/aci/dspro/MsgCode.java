/*
 * MsgCode.jaa
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
 * available. Contact Niranjan Suri at IHMC (nsuri@ihmc.us) for details..
 *
 * Author: Enrico Casini           (ecasini@ihmc.us)
 */

package us.ihmc.android.aci.dspro;

/**
 * MsgCode.java
 *
 * @author Enrico Casini (ecasini@ihmc.us)
 */

public interface MsgCode {

    int INIT_SUCCESS = 0;
    int METADATA_ARRIVED = 1;
    int DATA_ARRIVED = 2;
    int PATH_REGISTERED = 3;
    int POSITION_UPDATED = 4;
    int NEW_NEIGHBOR = 5;
    int DEAD_NEIGHBOR = 6;
}