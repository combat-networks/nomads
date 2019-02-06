/*
 * Copyright 1999-2000,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * $Id$
 */


#if !defined(FLAGJANITOR_HPP)
#define FLAGJANITOR_HPP

#include <xercesc/util/XercesDefs.hpp>

XERCES_CPP_NAMESPACE_BEGIN

template <class T> class FlagJanitor
{
public :
    // -----------------------------------------------------------------------
    //  Constructors and Destructor
    // -----------------------------------------------------------------------
    FlagJanitor(T* const valPtr, const T newVal);
    ~FlagJanitor();


    // -----------------------------------------------------------------------
    //  Value management methods
    // -----------------------------------------------------------------------
    void release();


private :
    // -----------------------------------------------------------------------
    //  Unimplemented constructors and operators
    // -----------------------------------------------------------------------
    FlagJanitor();
    FlagJanitor(const FlagJanitor<T>&);
    FlagJanitor<T>& operator=(const FlagJanitor<T>&);


    // -----------------------------------------------------------------------
    //  Private data members
    //
    //  fOldVal
    //      The old value that was in the flag when we were constructed.
    //
    //  fValPtr
    //      A pointer to the flag that we are to restore the value of
    // -----------------------------------------------------------------------
    T   fOldVal;
    T*  fValPtr;
};

XERCES_CPP_NAMESPACE_END

#if !defined(XERCES_TMPLSINC)
#include <xercesc/util/FlagJanitor.c>
#endif

#endif