/*
 * LzmaConnectorWriter.cpp
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

#include <cstdlib>

#include "Logger.h"

#include "LzmaConnectorWriter.h"


#define checkAndLogMsg(_f_name_, _log_level_, ...) \
    if (NOMADSUtil::pLogger && (NOMADSUtil::pLogger->getDebugLevel() >= _log_level_)) \
        NOMADSUtil::pLogger->logMsg (_f_name_, _log_level_, __VA_ARGS__)

namespace ACMNetProxy
{
    LzmaConnectorWriter::LzmaConnectorWriter (const CompressionSettings & compressionSettings, unsigned long ulOutBufSize) :
        ConnectorWriter{compressionSettings}
    {
        if (ulOutBufSize == 0) {
            // Throw C++ exception here
        }
        _ulOutBufSize = ulOutBufSize;
        if ((_pOutputBuffer = new unsigned char [_ulOutBufSize]) == nullptr) {
            // throw C++ exception here
        }

        resetCompStream();

        if (LZMA_OK != lzma_easy_encoder (&_lzmaCompStream, getCompressionLevel(), COMPRESSION_CHECK)) {
            // Throw C++ exception here
        }
    }

    LzmaConnectorWriter::~LzmaConnectorWriter (void)
    {
        lzma_end (&_lzmaCompStream);
        if (_pOutputBuffer) {
            delete[] _pOutputBuffer;
        }
        _pOutputBuffer = nullptr;
    }

    int LzmaConnectorWriter::flush (unsigned char **pDest, unsigned int &uiDestLen)
    {
        if (_bFlushed) {
            *pDest = nullptr;
            uiDestLen = 0;
            return 0;
        }

        bool bDone = false;
        _lzmaCompStream.next_in = nullptr;
        _lzmaCompStream.avail_in = 0;
        uiDestLen = 0;
        while (!bDone) {
            int rc;
            unsigned int uiOldAvail_out = _lzmaCompStream.avail_out;
            if (0 != (rc = lzma_code ( &_lzmaCompStream, LZMA_FINISH))) {
                if (rc == LZMA_STREAM_END) {
                    bDone = true;
                }
                else if (rc != LZMA_OK) {
                    checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                    "deflate with flag Z_FINISH returned with error code %d\n", rc);
                    uiDestLen = 0;
                    *pDest = nullptr;
                    return -1;
                }
            }
            if (_lzmaCompStream.avail_out < _ulOutBufSize) {
                uiDestLen += (uiOldAvail_out - _lzmaCompStream.avail_out);
                if (_lzmaCompStream.avail_out == 0) {
                    _ulOutBufSize *= 2;
                    _pOutputBuffer = (unsigned char*) realloc (_pOutputBuffer, _ulOutBufSize);
                    if (!_pOutputBuffer) {
                        checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                        "error trying to realloc %u (previously %u) bytes\n",
                                        _ulOutBufSize, _ulOutBufSize/2);
                        uiDestLen = 0;
                        *pDest = nullptr;
                        return -2;
                    }
                }
                _lzmaCompStream.avail_out = _ulOutBufSize - uiDestLen;
                _lzmaCompStream.next_out = _pOutputBuffer + uiDestLen;
            }
            else if (!bDone) {
                // deflate was not done but did not put anything into the output buffer
                checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                "lzma_code() with flag LZMA_FINISH didn't produce new output but "
                                "returned code is not LZMA_STREAM_END (code: %d)\n", rc);
                uiDestLen = 0;
                *pDest = nullptr;
                return -3;
            }
        }

        if (uiDestLen > 0) {
            *pDest = _pOutputBuffer;
        }
        else {
            *pDest = nullptr;
        }
        _lzmaCompStream.avail_out = _ulOutBufSize;
        _lzmaCompStream.next_out = _pOutputBuffer;
        _bFlushed = true;

        return 0;
    }

    int LzmaConnectorWriter::writeData (const unsigned char *pSrc, unsigned int uiSrcLen, unsigned char **pDest, unsigned int &uiDestLen, bool bLocalFlush)
    {
        int rc;
        unsigned int uiOldAvailableSpace = 0;
        bool bNeedFlush = false;
        _lzmaCompStream.next_in = pSrc;
        _lzmaCompStream.avail_in = uiSrcLen;
        uiDestLen = 0;
        *pDest = nullptr;
        _bFlushed = false;

        while ((_lzmaCompStream.avail_in > 0) || bNeedFlush) {
            bNeedFlush = false;
            uiOldAvailableSpace = _lzmaCompStream.avail_out;
            if (bLocalFlush) {
                rc = lzma_code (&_lzmaCompStream, LZMA_SYNC_FLUSH);
                if (rc > 1) {
                    checkAndLogMsg ("LzmaConnectorWriter::writeData", NOMADSUtil::Logger::L_MildError,
                                    "lzma_code() called with flag LZMA_SYNC_FLUSH returned with error code %d\n", rc);
                    uiDestLen = 0;
                    *pDest = nullptr;
                    return -1;
                }
            }
            else {
                rc = lzma_code (&_lzmaCompStream, LZMA_RUN);
                if (rc > 1) {
                    checkAndLogMsg ("LzmaConnectorWriter::writeData", NOMADSUtil::Logger::L_MildError,
                                    "lzma_code() called with flag LZMA_RUN returned with error code %d\n", rc);
                    uiDestLen = 0;
                    *pDest = nullptr;
                    return -1;
                }
            }
            uiDestLen += uiOldAvailableSpace - _lzmaCompStream.avail_out;

            if (_lzmaCompStream.avail_out == 0) {
                bNeedFlush = true;
                _ulOutBufSize *= 2;
                _pOutputBuffer = (unsigned char *) realloc (_pOutputBuffer, _ulOutBufSize);
            }
            _lzmaCompStream.avail_out = _ulOutBufSize - uiDestLen;
            _lzmaCompStream.next_out = _pOutputBuffer + uiDestLen;
        }

        if (uiDestLen > 0) {
            *pDest = _pOutputBuffer;
        }
        else {
            *pDest = nullptr;
        }
        _lzmaCompStream.avail_out = _ulOutBufSize;
        _lzmaCompStream.next_out = _pOutputBuffer;

        return 0;
    }

    int LzmaConnectorWriter::writeDataAndResetWriter (const unsigned char *pSrc, unsigned int uiSrcLen, unsigned char **pDest, unsigned int &uiDestLen)
    {
        int rc;
        unsigned int uiOldAvail_out = 0;
        bool bDone = false;
        *pDest = nullptr;
        uiDestLen = 0;

        if (!pSrc || (uiSrcLen == 0)) {
            lzma_end (&_lzmaCompStream);
            resetCompStream();
            if (LZMA_OK != lzma_easy_encoder (&_lzmaCompStream, getCompressionLevel(), COMPRESSION_CHECK)) {
                return -1;
            }
            return 0;
        }
        _lzmaCompStream.next_in = pSrc;
        _lzmaCompStream.avail_in = uiSrcLen;

        while (!bDone) {
            uiOldAvail_out = _lzmaCompStream.avail_out;
            if (0 != (rc = lzma_code ( &_lzmaCompStream, LZMA_FINISH))) {
                if (rc == LZMA_STREAM_END) {
                    bDone = true;
                }
                else if (rc != LZMA_OK) {
                    checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                    "deflate with flag Z_FINISH returned with error code %d\n", rc);
                    uiDestLen = 0;
                    *pDest = nullptr;
                    return -2;
                }
            }
            if (_lzmaCompStream.avail_out < _ulOutBufSize) {
                uiDestLen += (uiOldAvail_out - _lzmaCompStream.avail_out);
                if (_lzmaCompStream.avail_out == 0) {
                    _ulOutBufSize *= 2;
                    _pOutputBuffer = (unsigned char*) realloc (_pOutputBuffer, _ulOutBufSize);
                    if (!_pOutputBuffer) {
                        checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                        "error trying to realloc %u (previously %u) bytes\n",
                                        _ulOutBufSize, _ulOutBufSize/2);
                        uiDestLen = 0;
                        *pDest = nullptr;
                        return -3;
                    }
                }
                _lzmaCompStream.avail_out = _ulOutBufSize - uiDestLen;
                _lzmaCompStream.next_out = _pOutputBuffer + uiDestLen;
            }
            else if (!bDone) {
                // deflate was not done but did not put anything into the output buffer
                checkAndLogMsg ("LzmaConnectorWriter::flush", NOMADSUtil::Logger::L_MildError,
                                "lzma_code() with flag LZMA_FINISH didn't produce new output "
                                "but returned code is not LZMA_STREAM_END (code: %d)\n", rc);
                uiDestLen = 0;
                *pDest = nullptr;
                return -4;
            }
        }

        if (uiDestLen > 0) {
            *pDest = _pOutputBuffer;
        }
        else {
            *pDest = nullptr;
        }
        _lzmaCompStream.avail_out = _ulOutBufSize;
        _lzmaCompStream.next_out = _pOutputBuffer;
        _bFlushed = true;

        lzma_end (&_lzmaCompStream);
        resetCompStream();
        if (LZMA_OK != lzma_easy_encoder (&_lzmaCompStream, getCompressionLevel(), COMPRESSION_CHECK)) {
            return -5;
        }

        return 0;
    }

    void LzmaConnectorWriter::resetCompStream (void)
    {
        _lzmaCompStream.allocator = nullptr;
        _lzmaCompStream.next_in = nullptr;
        _lzmaCompStream.avail_in = 0;
        _lzmaCompStream.total_in = 0;
        _lzmaCompStream.next_out = _pOutputBuffer;
        _lzmaCompStream.avail_out = _ulOutBufSize;
        _lzmaCompStream.total_out = 0;
        _lzmaCompStream.allocator = nullptr;
        _lzmaCompStream.internal = nullptr;
        _lzmaCompStream.reserved_ptr1 = nullptr;
        _lzmaCompStream.reserved_ptr2 = nullptr;
        _lzmaCompStream.reserved_ptr3 = nullptr;
        _lzmaCompStream.reserved_ptr4 = nullptr;
        _lzmaCompStream.reserved_int1 = 0;
        _lzmaCompStream.reserved_int2 = 0;
        _lzmaCompStream.reserved_int3 = 0;
        _lzmaCompStream.reserved_int4 = 0;
        _lzmaCompStream.reserved_enum1 = LZMA_RESERVED_ENUM;
        _lzmaCompStream.reserved_enum2 = LZMA_RESERVED_ENUM;
    }

}
