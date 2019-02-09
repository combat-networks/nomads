/*
 * ReassemblerArguments.h
 *
 * This file is part of the IHMC Misc Library
 * Copyright (c) 2010-2016 IHMC.
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

#ifndef INCL_REASSEMBLER_ARGUMENTS_H
#define	INCL_REASSEMBLER_ARGUMENTS_H

#include "Chunks.h"
#include "ChunkingManager.h"

#include "BufferReader.h"
#include "StrClass.h"

namespace NOMADSUtil
{
    class Reader;
    class Writer;
}

namespace IHMC_MISC
{
    struct ReassembleArguments
    {
        ReassembleArguments (void);
        ReassembleArguments (Chunks *pFragments, Annotations *pAnnotations,
                             const char *pszChunkMimeType, uint8 ui8NoOfChunks,
                             uint8 ui8CompressionQuality);
        ~ReassembleArguments (void);

        int read (NOMADSUtil::Reader *pReader);
        int write (NOMADSUtil::Writer *pWriter);

        uint8 _ui8NoOfChunks;
        uint8 _ui8CompressionQuality;
        NOMADSUtil::String _chunkType;
        Chunks *_pFragments;
        Annotations *_pAnnotations;
    };
}

#endif  /* INCL_REASSEMBLER_ARGUMENTS_H */

