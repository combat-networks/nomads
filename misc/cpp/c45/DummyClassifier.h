/*
 * DummyClassifier.h
 *
 * This file is part of the IHMC C4.5 Decision Tree Library.
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
 * Author: Giacomo Benincasa            (gbenincasa@ihmc.us)
 * Created on November 23, 2011, 12:00 PM
 */

#ifndef INCL_DUMMY_CLASSIFIER_H
#define INCL_DUMMY_CLASSIFIER_H

#include "Classifier.h"
#include "C45AVList.h"
#include "Prediction.h"
#include "types.h"
//#include "c4.5.h"

namespace NOMADSUtil
{
    class Reader;
    class Writer;
}

namespace IHMC_C45
{
    class DummyClassifier : public Classifier
    {
        public:
            friend class DataGenerator;

            DummyClassifier();
            virtual ~DummyClassifier();
            int configureClassifier(C45AVList * attributes);
            int addNewData(C45AVList * dataset);
            Prediction * consultClassifier(C45AVList * record);
            TestInfo * testClassifierOnData(C45AVList * dataset);
            void deleteTestData(void);
            const char * getErrorMessage(void);
            int getErrorCode(void);
            int64 read(NOMADSUtil::Reader * pReader, uint32 ui32MaxSize);
            int64 skip (NOMADSUtil::Reader *pReader, uint32 ui32MaxSize);
            int64 write(NOMADSUtil::Writer * pWriter, uint32 ui32MaxSize);
            int64 getWriteLength(void);
            uint16 getVersion(void);    // The version doesn't change in time.

        private:
            const char * _pszErrorMessage;
            int _errorCode;
            Configure * _pConfigure;
            CError * _pErrOcc;
            int _MaxItemTest;
            Description * _pItemTest;
    };

    inline const char * DummyClassifier::getErrorMessage(void)
    {
        return _pszErrorMessage;
    }

    inline int DummyClassifier::getErrorCode(void)
    {
        return _errorCode;
    }
}

#endif // INCL_DUMMY_CLASSIFIER_H