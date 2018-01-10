// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: netproxyinfo.proto

#ifndef PROTOBUF_netproxyinfo_2eproto__INCLUDED
#define PROTOBUF_netproxyinfo_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3001000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3001000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
#include "topology.pb.h"
// @@protoc_insertion_point(includes)

namespace netsensor {

// Internal implementation detail -- do not call these.
void protobuf_AddDesc_netproxyinfo_2eproto();
void protobuf_InitDefaults_netproxyinfo_2eproto();
void protobuf_AssignDesc_netproxyinfo_2eproto();
void protobuf_ShutdownFile_netproxyinfo_2eproto();

class NetProxyInfo;

// ===================================================================

class NetProxyInfo : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:netsensor.NetProxyInfo) */ {
 public:
  NetProxyInfo();
  virtual ~NetProxyInfo();

  NetProxyInfo(const NetProxyInfo& from);

  inline NetProxyInfo& operator=(const NetProxyInfo& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const NetProxyInfo& default_instance();

  static const NetProxyInfo* internal_default_instance();

  void Swap(NetProxyInfo* other);

  // implements Message ----------------------------------------------

  inline NetProxyInfo* New() const { return New(NULL); }

  NetProxyInfo* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const NetProxyInfo& from);
  void MergeFrom(const NetProxyInfo& from);
  void Clear();
  bool IsInitialized() const;

  size_t ByteSizeLong() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const {
    return InternalSerializeWithCachedSizesToArray(false, output);
  }
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  void InternalSwap(NetProxyInfo* other);
  void UnsafeMergeFrom(const NetProxyInfo& from);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return _internal_metadata_.arena();
  }
  inline void* MaybeArenaPtr() const {
    return _internal_metadata_.raw_arena_ptr();
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // optional .netsensor.NetworkInfo internal = 1;
  bool has_internal() const;
  void clear_internal();
  static const int kInternalFieldNumber = 1;
  const ::netsensor::NetworkInfo& internal() const;
  ::netsensor::NetworkInfo* mutable_internal();
  ::netsensor::NetworkInfo* release_internal();
  void set_allocated_internal(::netsensor::NetworkInfo* internal);

  // optional .netsensor.NetworkInfo external = 2;
  bool has_external() const;
  void clear_external();
  static const int kExternalFieldNumber = 2;
  const ::netsensor::NetworkInfo& external() const;
  ::netsensor::NetworkInfo* mutable_external();
  ::netsensor::NetworkInfo* release_external();
  void set_allocated_external(::netsensor::NetworkInfo* external);

  // repeated uint32 remoteNetProxyIPs = 3;
  int remotenetproxyips_size() const;
  void clear_remotenetproxyips();
  static const int kRemoteNetProxyIPsFieldNumber = 3;
  ::google::protobuf::uint32 remotenetproxyips(int index) const;
  void set_remotenetproxyips(int index, ::google::protobuf::uint32 value);
  void add_remotenetproxyips(::google::protobuf::uint32 value);
  const ::google::protobuf::RepeatedField< ::google::protobuf::uint32 >&
      remotenetproxyips() const;
  ::google::protobuf::RepeatedField< ::google::protobuf::uint32 >*
      mutable_remotenetproxyips();

  // @@protoc_insertion_point(class_scope:netsensor.NetProxyInfo)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::RepeatedField< ::google::protobuf::uint32 > remotenetproxyips_;
  mutable int _remotenetproxyips_cached_byte_size_;
  ::netsensor::NetworkInfo* internal_;
  ::netsensor::NetworkInfo* external_;
  mutable int _cached_size_;
  friend void  protobuf_InitDefaults_netproxyinfo_2eproto_impl();
  friend void  protobuf_AddDesc_netproxyinfo_2eproto_impl();
  friend void protobuf_AssignDesc_netproxyinfo_2eproto();
  friend void protobuf_ShutdownFile_netproxyinfo_2eproto();

  void InitAsDefaultInstance();
};
extern ::google::protobuf::internal::ExplicitlyConstructed<NetProxyInfo> NetProxyInfo_default_instance_;

// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// NetProxyInfo

// optional .netsensor.NetworkInfo internal = 1;
inline bool NetProxyInfo::has_internal() const {
  return this != internal_default_instance() && internal_ != NULL;
}
inline void NetProxyInfo::clear_internal() {
  if (GetArenaNoVirtual() == NULL && internal_ != NULL) delete internal_;
  internal_ = NULL;
}
inline const ::netsensor::NetworkInfo& NetProxyInfo::internal() const {
  // @@protoc_insertion_point(field_get:netsensor.NetProxyInfo.internal)
  return internal_ != NULL ? *internal_
                         : *::netsensor::NetworkInfo::internal_default_instance();
}
inline ::netsensor::NetworkInfo* NetProxyInfo::mutable_internal() {
  
  if (internal_ == NULL) {
    internal_ = new ::netsensor::NetworkInfo;
  }
  // @@protoc_insertion_point(field_mutable:netsensor.NetProxyInfo.internal)
  return internal_;
}
inline ::netsensor::NetworkInfo* NetProxyInfo::release_internal() {
  // @@protoc_insertion_point(field_release:netsensor.NetProxyInfo.internal)
  
  ::netsensor::NetworkInfo* temp = internal_;
  internal_ = NULL;
  return temp;
}
inline void NetProxyInfo::set_allocated_internal(::netsensor::NetworkInfo* internal) {
  delete internal_;
  internal_ = internal;
  if (internal) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:netsensor.NetProxyInfo.internal)
}

// optional .netsensor.NetworkInfo external = 2;
inline bool NetProxyInfo::has_external() const {
  return this != internal_default_instance() && external_ != NULL;
}
inline void NetProxyInfo::clear_external() {
  if (GetArenaNoVirtual() == NULL && external_ != NULL) delete external_;
  external_ = NULL;
}
inline const ::netsensor::NetworkInfo& NetProxyInfo::external() const {
  // @@protoc_insertion_point(field_get:netsensor.NetProxyInfo.external)
  return external_ != NULL ? *external_
                         : *::netsensor::NetworkInfo::internal_default_instance();
}
inline ::netsensor::NetworkInfo* NetProxyInfo::mutable_external() {
  
  if (external_ == NULL) {
    external_ = new ::netsensor::NetworkInfo;
  }
  // @@protoc_insertion_point(field_mutable:netsensor.NetProxyInfo.external)
  return external_;
}
inline ::netsensor::NetworkInfo* NetProxyInfo::release_external() {
  // @@protoc_insertion_point(field_release:netsensor.NetProxyInfo.external)
  
  ::netsensor::NetworkInfo* temp = external_;
  external_ = NULL;
  return temp;
}
inline void NetProxyInfo::set_allocated_external(::netsensor::NetworkInfo* external) {
  delete external_;
  external_ = external;
  if (external) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:netsensor.NetProxyInfo.external)
}

// repeated uint32 remoteNetProxyIPs = 3;
inline int NetProxyInfo::remotenetproxyips_size() const {
  return remotenetproxyips_.size();
}
inline void NetProxyInfo::clear_remotenetproxyips() {
  remotenetproxyips_.Clear();
}
inline ::google::protobuf::uint32 NetProxyInfo::remotenetproxyips(int index) const {
  // @@protoc_insertion_point(field_get:netsensor.NetProxyInfo.remoteNetProxyIPs)
  return remotenetproxyips_.Get(index);
}
inline void NetProxyInfo::set_remotenetproxyips(int index, ::google::protobuf::uint32 value) {
  remotenetproxyips_.Set(index, value);
  // @@protoc_insertion_point(field_set:netsensor.NetProxyInfo.remoteNetProxyIPs)
}
inline void NetProxyInfo::add_remotenetproxyips(::google::protobuf::uint32 value) {
  remotenetproxyips_.Add(value);
  // @@protoc_insertion_point(field_add:netsensor.NetProxyInfo.remoteNetProxyIPs)
}
inline const ::google::protobuf::RepeatedField< ::google::protobuf::uint32 >&
NetProxyInfo::remotenetproxyips() const {
  // @@protoc_insertion_point(field_list:netsensor.NetProxyInfo.remoteNetProxyIPs)
  return remotenetproxyips_;
}
inline ::google::protobuf::RepeatedField< ::google::protobuf::uint32 >*
NetProxyInfo::mutable_remotenetproxyips() {
  // @@protoc_insertion_point(field_mutable_list:netsensor.NetProxyInfo.remoteNetProxyIPs)
  return &remotenetproxyips_;
}

inline const NetProxyInfo* NetProxyInfo::internal_default_instance() {
  return &NetProxyInfo_default_instance_.get();
}
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace netsensor

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_netproxyinfo_2eproto__INCLUDED