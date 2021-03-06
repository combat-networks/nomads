// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: measure.proto

#ifndef PROTOBUF_INCLUDED_measure_2eproto
#define PROTOBUF_INCLUDED_measure_2eproto

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3006001
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3006001 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/inlined_string_field.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/map.h>  // IWYU pragma: export
#include <google/protobuf/map_entry.h>
#include <google/protobuf/map_field_inl.h>
#include <google/protobuf/unknown_field_set.h>
#include <google/protobuf/timestamp.pb.h>
#include "subject.pb.h"
// @@protoc_insertion_point(includes)
#define PROTOBUF_INTERNAL_EXPORT_protobuf_measure_2eproto 

namespace protobuf_measure_2eproto {
// Internal implementation detail -- do not use these members.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[4];
  static const ::google::protobuf::internal::FieldMetadata field_metadata[];
  static const ::google::protobuf::internal::SerializationTable serialization_table[];
  static const ::google::protobuf::uint32 offsets[];
};
void AddDescriptors();
}  // namespace protobuf_measure_2eproto
namespace measure {
class Measure;
class MeasureDefaultTypeInternal;
extern MeasureDefaultTypeInternal _Measure_default_instance_;
class Measure_DoublesEntry_DoNotUse;
class Measure_DoublesEntry_DoNotUseDefaultTypeInternal;
extern Measure_DoublesEntry_DoNotUseDefaultTypeInternal _Measure_DoublesEntry_DoNotUse_default_instance_;
class Measure_IntegersEntry_DoNotUse;
class Measure_IntegersEntry_DoNotUseDefaultTypeInternal;
extern Measure_IntegersEntry_DoNotUseDefaultTypeInternal _Measure_IntegersEntry_DoNotUse_default_instance_;
class Measure_StringsEntry_DoNotUse;
class Measure_StringsEntry_DoNotUseDefaultTypeInternal;
extern Measure_StringsEntry_DoNotUseDefaultTypeInternal _Measure_StringsEntry_DoNotUse_default_instance_;
}  // namespace measure
namespace google {
namespace protobuf {
template<> ::measure::Measure* Arena::CreateMaybeMessage<::measure::Measure>(Arena*);
template<> ::measure::Measure_DoublesEntry_DoNotUse* Arena::CreateMaybeMessage<::measure::Measure_DoublesEntry_DoNotUse>(Arena*);
template<> ::measure::Measure_IntegersEntry_DoNotUse* Arena::CreateMaybeMessage<::measure::Measure_IntegersEntry_DoNotUse>(Arena*);
template<> ::measure::Measure_StringsEntry_DoNotUse* Arena::CreateMaybeMessage<::measure::Measure_StringsEntry_DoNotUse>(Arena*);
}  // namespace protobuf
}  // namespace google
namespace measure {

// ===================================================================

class Measure_StringsEntry_DoNotUse : public ::google::protobuf::internal::MapEntry<Measure_StringsEntry_DoNotUse, 
    ::std::string, ::std::string,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    0 > {
public:
  typedef ::google::protobuf::internal::MapEntry<Measure_StringsEntry_DoNotUse, 
    ::std::string, ::std::string,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    0 > SuperType;
  Measure_StringsEntry_DoNotUse();
  Measure_StringsEntry_DoNotUse(::google::protobuf::Arena* arena);
  void MergeFrom(const Measure_StringsEntry_DoNotUse& other);
  static const Measure_StringsEntry_DoNotUse* internal_default_instance() { return reinterpret_cast<const Measure_StringsEntry_DoNotUse*>(&_Measure_StringsEntry_DoNotUse_default_instance_); }
  void MergeFrom(const ::google::protobuf::Message& other) final;
  ::google::protobuf::Metadata GetMetadata() const;
};

// -------------------------------------------------------------------

class Measure_IntegersEntry_DoNotUse : public ::google::protobuf::internal::MapEntry<Measure_IntegersEntry_DoNotUse, 
    ::std::string, ::google::protobuf::int64,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_INT64,
    0 > {
public:
  typedef ::google::protobuf::internal::MapEntry<Measure_IntegersEntry_DoNotUse, 
    ::std::string, ::google::protobuf::int64,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_INT64,
    0 > SuperType;
  Measure_IntegersEntry_DoNotUse();
  Measure_IntegersEntry_DoNotUse(::google::protobuf::Arena* arena);
  void MergeFrom(const Measure_IntegersEntry_DoNotUse& other);
  static const Measure_IntegersEntry_DoNotUse* internal_default_instance() { return reinterpret_cast<const Measure_IntegersEntry_DoNotUse*>(&_Measure_IntegersEntry_DoNotUse_default_instance_); }
  void MergeFrom(const ::google::protobuf::Message& other) final;
  ::google::protobuf::Metadata GetMetadata() const;
};

// -------------------------------------------------------------------

class Measure_DoublesEntry_DoNotUse : public ::google::protobuf::internal::MapEntry<Measure_DoublesEntry_DoNotUse, 
    ::std::string, double,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_DOUBLE,
    0 > {
public:
  typedef ::google::protobuf::internal::MapEntry<Measure_DoublesEntry_DoNotUse, 
    ::std::string, double,
    ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
    ::google::protobuf::internal::WireFormatLite::TYPE_DOUBLE,
    0 > SuperType;
  Measure_DoublesEntry_DoNotUse();
  Measure_DoublesEntry_DoNotUse(::google::protobuf::Arena* arena);
  void MergeFrom(const Measure_DoublesEntry_DoNotUse& other);
  static const Measure_DoublesEntry_DoNotUse* internal_default_instance() { return reinterpret_cast<const Measure_DoublesEntry_DoNotUse*>(&_Measure_DoublesEntry_DoNotUse_default_instance_); }
  void MergeFrom(const ::google::protobuf::Message& other) final;
  ::google::protobuf::Metadata GetMetadata() const;
};

// -------------------------------------------------------------------

class Measure : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:measure.Measure) */ {
 public:
  Measure();
  virtual ~Measure();

  Measure(const Measure& from);

  inline Measure& operator=(const Measure& from) {
    CopyFrom(from);
    return *this;
  }
  #if LANG_CXX11
  Measure(Measure&& from) noexcept
    : Measure() {
    *this = ::std::move(from);
  }

  inline Measure& operator=(Measure&& from) noexcept {
    if (GetArenaNoVirtual() == from.GetArenaNoVirtual()) {
      if (this != &from) InternalSwap(&from);
    } else {
      CopyFrom(from);
    }
    return *this;
  }
  #endif
  static const ::google::protobuf::Descriptor* descriptor();
  static const Measure& default_instance();

  static void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  static inline const Measure* internal_default_instance() {
    return reinterpret_cast<const Measure*>(
               &_Measure_default_instance_);
  }
  static constexpr int kIndexInFileMessages =
    3;

  void Swap(Measure* other);
  friend void swap(Measure& a, Measure& b) {
    a.Swap(&b);
  }

  // implements Message ----------------------------------------------

  inline Measure* New() const final {
    return CreateMaybeMessage<Measure>(NULL);
  }

  Measure* New(::google::protobuf::Arena* arena) const final {
    return CreateMaybeMessage<Measure>(arena);
  }
  void CopyFrom(const ::google::protobuf::Message& from) final;
  void MergeFrom(const ::google::protobuf::Message& from) final;
  void CopyFrom(const Measure& from);
  void MergeFrom(const Measure& from);
  void Clear() final;
  bool IsInitialized() const final;

  size_t ByteSizeLong() const final;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) final;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const final;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const final;
  int GetCachedSize() const final { return _cached_size_.Get(); }

  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const final;
  void InternalSwap(Measure* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const final;

  // nested types ----------------------------------------------------


  // accessors -------------------------------------------------------

  // map<string, string> strings = 2;
  int strings_size() const;
  void clear_strings();
  static const int kStringsFieldNumber = 2;
  const ::google::protobuf::Map< ::std::string, ::std::string >&
      strings() const;
  ::google::protobuf::Map< ::std::string, ::std::string >*
      mutable_strings();

  // map<string, int64> integers = 3;
  int integers_size() const;
  void clear_integers();
  static const int kIntegersFieldNumber = 3;
  const ::google::protobuf::Map< ::std::string, ::google::protobuf::int64 >&
      integers() const;
  ::google::protobuf::Map< ::std::string, ::google::protobuf::int64 >*
      mutable_integers();

  // map<string, double> doubles = 4;
  int doubles_size() const;
  void clear_doubles();
  static const int kDoublesFieldNumber = 4;
  const ::google::protobuf::Map< ::std::string, double >&
      doubles() const;
  ::google::protobuf::Map< ::std::string, double >*
      mutable_doubles();

  // string requestID = 6;
  void clear_requestid();
  static const int kRequestIDFieldNumber = 6;
  const ::std::string& requestid() const;
  void set_requestid(const ::std::string& value);
  #if LANG_CXX11
  void set_requestid(::std::string&& value);
  #endif
  void set_requestid(const char* value);
  void set_requestid(const char* value, size_t size);
  ::std::string* mutable_requestid();
  ::std::string* release_requestid();
  void set_allocated_requestid(::std::string* requestid);

  // .google.protobuf.Timestamp timestamp = 5;
  bool has_timestamp() const;
  void clear_timestamp();
  static const int kTimestampFieldNumber = 5;
  private:
  const ::google::protobuf::Timestamp& _internal_timestamp() const;
  public:
  const ::google::protobuf::Timestamp& timestamp() const;
  ::google::protobuf::Timestamp* release_timestamp();
  ::google::protobuf::Timestamp* mutable_timestamp();
  void set_allocated_timestamp(::google::protobuf::Timestamp* timestamp);

  // .measure.Subject subject = 1;
  void clear_subject();
  static const int kSubjectFieldNumber = 1;
  ::measure::Subject subject() const;
  void set_subject(::measure::Subject value);

  // @@protoc_insertion_point(class_scope:measure.Measure)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::internal::MapField<
      Measure_StringsEntry_DoNotUse,
      ::std::string, ::std::string,
      ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
      ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
      0 > strings_;
  ::google::protobuf::internal::MapField<
      Measure_IntegersEntry_DoNotUse,
      ::std::string, ::google::protobuf::int64,
      ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
      ::google::protobuf::internal::WireFormatLite::TYPE_INT64,
      0 > integers_;
  ::google::protobuf::internal::MapField<
      Measure_DoublesEntry_DoNotUse,
      ::std::string, double,
      ::google::protobuf::internal::WireFormatLite::TYPE_STRING,
      ::google::protobuf::internal::WireFormatLite::TYPE_DOUBLE,
      0 > doubles_;
  ::google::protobuf::internal::ArenaStringPtr requestid_;
  ::google::protobuf::Timestamp* timestamp_;
  int subject_;
  mutable ::google::protobuf::internal::CachedSize _cached_size_;
  friend struct ::protobuf_measure_2eproto::TableStruct;
};
// ===================================================================


// ===================================================================

#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
// -------------------------------------------------------------------

// -------------------------------------------------------------------

// -------------------------------------------------------------------

// Measure

// .measure.Subject subject = 1;
inline void Measure::clear_subject() {
  subject_ = 0;
}
inline ::measure::Subject Measure::subject() const {
  // @@protoc_insertion_point(field_get:measure.Measure.subject)
  return static_cast< ::measure::Subject >(subject_);
}
inline void Measure::set_subject(::measure::Subject value) {
  
  subject_ = value;
  // @@protoc_insertion_point(field_set:measure.Measure.subject)
}

// map<string, string> strings = 2;
inline int Measure::strings_size() const {
  return strings_.size();
}
inline void Measure::clear_strings() {
  strings_.Clear();
}
inline const ::google::protobuf::Map< ::std::string, ::std::string >&
Measure::strings() const {
  // @@protoc_insertion_point(field_map:measure.Measure.strings)
  return strings_.GetMap();
}
inline ::google::protobuf::Map< ::std::string, ::std::string >*
Measure::mutable_strings() {
  // @@protoc_insertion_point(field_mutable_map:measure.Measure.strings)
  return strings_.MutableMap();
}

// map<string, int64> integers = 3;
inline int Measure::integers_size() const {
  return integers_.size();
}
inline void Measure::clear_integers() {
  integers_.Clear();
}
inline const ::google::protobuf::Map< ::std::string, ::google::protobuf::int64 >&
Measure::integers() const {
  // @@protoc_insertion_point(field_map:measure.Measure.integers)
  return integers_.GetMap();
}
inline ::google::protobuf::Map< ::std::string, ::google::protobuf::int64 >*
Measure::mutable_integers() {
  // @@protoc_insertion_point(field_mutable_map:measure.Measure.integers)
  return integers_.MutableMap();
}

// map<string, double> doubles = 4;
inline int Measure::doubles_size() const {
  return doubles_.size();
}
inline void Measure::clear_doubles() {
  doubles_.Clear();
}
inline const ::google::protobuf::Map< ::std::string, double >&
Measure::doubles() const {
  // @@protoc_insertion_point(field_map:measure.Measure.doubles)
  return doubles_.GetMap();
}
inline ::google::protobuf::Map< ::std::string, double >*
Measure::mutable_doubles() {
  // @@protoc_insertion_point(field_mutable_map:measure.Measure.doubles)
  return doubles_.MutableMap();
}

// .google.protobuf.Timestamp timestamp = 5;
inline bool Measure::has_timestamp() const {
  return this != internal_default_instance() && timestamp_ != NULL;
}
inline const ::google::protobuf::Timestamp& Measure::_internal_timestamp() const {
  return *timestamp_;
}
inline const ::google::protobuf::Timestamp& Measure::timestamp() const {
  const ::google::protobuf::Timestamp* p = timestamp_;
  // @@protoc_insertion_point(field_get:measure.Measure.timestamp)
  return p != NULL ? *p : *reinterpret_cast<const ::google::protobuf::Timestamp*>(
      &::google::protobuf::_Timestamp_default_instance_);
}
inline ::google::protobuf::Timestamp* Measure::release_timestamp() {
  // @@protoc_insertion_point(field_release:measure.Measure.timestamp)
  
  ::google::protobuf::Timestamp* temp = timestamp_;
  timestamp_ = NULL;
  return temp;
}
inline ::google::protobuf::Timestamp* Measure::mutable_timestamp() {
  
  if (timestamp_ == NULL) {
    auto* p = CreateMaybeMessage<::google::protobuf::Timestamp>(GetArenaNoVirtual());
    timestamp_ = p;
  }
  // @@protoc_insertion_point(field_mutable:measure.Measure.timestamp)
  return timestamp_;
}
inline void Measure::set_allocated_timestamp(::google::protobuf::Timestamp* timestamp) {
  ::google::protobuf::Arena* message_arena = GetArenaNoVirtual();
  if (message_arena == NULL) {
    delete reinterpret_cast< ::google::protobuf::MessageLite*>(timestamp_);
  }
  if (timestamp) {
    ::google::protobuf::Arena* submessage_arena =
      reinterpret_cast<::google::protobuf::MessageLite*>(timestamp)->GetArena();
    if (message_arena != submessage_arena) {
      timestamp = ::google::protobuf::internal::GetOwnedMessage(
          message_arena, timestamp, submessage_arena);
    }
    
  } else {
    
  }
  timestamp_ = timestamp;
  // @@protoc_insertion_point(field_set_allocated:measure.Measure.timestamp)
}

// string requestID = 6;
inline void Measure::clear_requestid() {
  requestid_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline const ::std::string& Measure::requestid() const {
  // @@protoc_insertion_point(field_get:measure.Measure.requestID)
  return requestid_.GetNoArena();
}
inline void Measure::set_requestid(const ::std::string& value) {
  
  requestid_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:measure.Measure.requestID)
}
#if LANG_CXX11
inline void Measure::set_requestid(::std::string&& value) {
  
  requestid_.SetNoArena(
    &::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::move(value));
  // @@protoc_insertion_point(field_set_rvalue:measure.Measure.requestID)
}
#endif
inline void Measure::set_requestid(const char* value) {
  GOOGLE_DCHECK(value != NULL);
  
  requestid_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:measure.Measure.requestID)
}
inline void Measure::set_requestid(const char* value, size_t size) {
  
  requestid_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:measure.Measure.requestID)
}
inline ::std::string* Measure::mutable_requestid() {
  
  // @@protoc_insertion_point(field_mutable:measure.Measure.requestID)
  return requestid_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* Measure::release_requestid() {
  // @@protoc_insertion_point(field_release:measure.Measure.requestID)
  
  return requestid_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void Measure::set_allocated_requestid(::std::string* requestid) {
  if (requestid != NULL) {
    
  } else {
    
  }
  requestid_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), requestid);
  // @@protoc_insertion_point(field_set_allocated:measure.Measure.requestID)
}

#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__
// -------------------------------------------------------------------

// -------------------------------------------------------------------

// -------------------------------------------------------------------


// @@protoc_insertion_point(namespace_scope)

}  // namespace measure

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_INCLUDED_measure_2eproto
