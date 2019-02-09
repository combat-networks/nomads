/*
 * Match.h
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
 * Created on February 20, 2015, 4:08 PM
 */

#ifndef INCL_MATCH_H
#define	INCL_MATCH_H

namespace IHMC_VOI
{
    struct Match
    {
        enum FuzzyValue
        {
            NO       = 0x00,
            NOT_SURE = 0x01,
            YES      = 0x02
        };

        Match (void);
        explicit Match (float fMatchConfidence);
        explicit Match (FuzzyValue match, float fMatchConfidence = 0.0f);
        ~Match (void);

        int operator > (Match &rhsMatch) const;

        FuzzyValue _match;
        float _fMatchConfidence;
    };
}

#endif	/* INCL_MATCH_H */
