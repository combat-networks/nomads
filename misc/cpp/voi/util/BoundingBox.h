/*
 * BoundingBox.h
 *
 * This file is part of the IHMC Voi Library/Component
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
 * Created on August 12, 2014, 6:37 PM
 */

#ifndef INCL_BOUNDING_BOX_H
#define	INCL_BOUNDING_BOX_H

#include "MetadataInterface.h"

#include "GeoUtils.h"

namespace IHMC_VOI
{
    class BoundingBoxAccumulator
    {
        public:
            BoundingBoxAccumulator (const NOMADSUtil::BoundingBox &bbox);
            ~BoundingBoxAccumulator (void);

            BoundingBoxAccumulator & operator+=(const NOMADSUtil::BoundingBox &rhs);
            NOMADSUtil::BoundingBox getBoundingBox (void);

        private:
            bool _bEmpty;
            float _leftUpperLatitude;
            float _leftUpperLongitude;
            float _rightLowerLatitude;
            float _rightLowerLongitude;
    };
}

#endif	/* INCL_BOUNDING_BOX_H */

