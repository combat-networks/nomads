// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: topology.proto

#ifndef PROTOBUF_topology_2eproto__INCLUDED
#define PROTOBUF_topology_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3003000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3003000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/unknown_field_set.h>
// @@protoc_insertion_point(includes)
namespace netsensor {
class Host;
class HostDefaultTypeInternal;
extern HostDefaultTypeInternal _Host_default_instance_;
class NetworkInfo;
class NetworkInfoDefaultTypeInternal;
extern NetworkInfoDefaultTypeInternal _NetworkInfo_default_instance_;
class Topology;
class TopologyDefaultTypeInternal;
extern TopologyDefaultTypeInternal _Topology_default_instance_;
}  // namespace netsensor

namespace netsensor {

namespace protobuf_topology_2eproto {
// Internal implementation detail -- do not call these.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[];
  static const ::google::protobuf::uint32 offsets[];
  static void InitDefaultsImpl();
  static void Shutdown();
};
void AddDescriptors();
void InitDefaults();
}  // namespace protobuf_topology_2eproto

// ===================================================================

class Topology : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:netsensor.Topology) */ {
 public:
  Topology();
  virtual ~Topology();

  Topology(const Topology& from);

  inline Topology& operator=(const Topology& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const Topology& default_instance();

  static inline const Topology* internal_default_instance() {
    return reinterpret_cast<const Topology*>(
               &_Topology_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    0;

  void Swap(Topology* other);

  // implements Message ----------------------------------------------

  inline Topology* New() const PROTOBUF_FINAL { return New(NULL); }

  Topology* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const Topology& from);
  void MergeFrom(const Topology& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(Topology* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // repeated .netsensor.Host internals = 2;
  int internals_size() const;
  void clear_internals();
  static const int kInternalsFieldNumber = 2;
  const ::netsensor::Host& internals(int index) const;
  ::netsensor::Host* mutable_internals(int index);
  ::netsensor::Host* add_internals();
  ::google::protobuf::RepeatedPtrField< ::netsensor::Host >*
      mutable_internals();
  const ::google::protobuf::RepeatedPtrField< ::netsensor::Host >&
      internals() const;

  // repeated .netsensor.Host localGws = 3;
  int localgws_size() const;
  void clear_localgws();
  static const int kLocalGwsFieldNumber = 3;
  const ::netsensor::Host& localgws(int index) const;
  ::netsensor::Host* mutable_localgws(int index);
  ::netsensor::Host* add_localgws();
  ::google::protobuf::RepeatedPtrField< ::netsensor::Host >*
      mutable_localgws();
  const ::google::protobuf::RepeatedPtrField< ::netsensor::Host >&
      localgws() const;

  // .netsensor.NetworkInfo networkInfo = 1;
  bool has_networkinfo() const;
  void clear_networkinfo();
  static const int kNetworkInfoFieldNumber = 1;
  const ::netsensor::NetworkInfo& networkinfo() const;
  ::netsensor::NetworkInfo* mutable_networkinfo();
  ::netsensor::NetworkInfo* release_networkinfo();
  void set_allocated_networkinfo(::netsensor::NetworkInfo* networkinfo);

  // @@protoc_insertion_point(class_scope:netsensor.Topology)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::RepeatedPtrField< ::netsensor::Host > internals_;
  ::google::protobuf::RepeatedPtrField< ::netsensor::Host > localgws_;
  ::netsensor::NetworkInfo* networkinfo_;
  mutable int _cached_size_;
  friend struct protobuf_topology_2eproto::TableStruct;
};
// -------------------------------------------------------------------

class Host : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:netsensor.Host) */ {
 public:
  Host();
  virtual ~Host();

  Host(const Host& from);

  inline Host& operator=(const Host& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const Host& default_instance();

  static inline const Host* internal_default_instance() {
    return reinterpret_cast<const Host*>(
               &_Host_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    1;

  void Swap(Host* other);

  // implements Message ----------------------------------------------

  inline Host* New() const PROTOBUF_FINAL { return New(NULL); }

  Host* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const Host& from);
  void MergeFrom(const Host& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(Host* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // string mac = 2;
  void clear_mac();
  static const int kMacFieldNumber = 2;
  const ::std::string& mac() const;
  void set_mac(const ::std::string& value);
  #if LANG_CXX11
  void set_mac(::std::string&& value);
  #endif
  void set_mac(const char* value);
  void set_mac(const char* value, size_t size);
  ::std::string* mutable_mac();
  ::std::string* release_mac();
  void set_allocated_mac(::std::string* mac);

  // uint32 ip = 1;
  void clear_ip();
  static const int kIpFieldNumber = 1;
  ::google::protobuf::uint32 ip() const;
  void set_ip(::google::protobuf::uint32 value);

  // @@protoc_insertion_point(class_scope:netsensor.Host)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::internal::ArenaStringPtr mac_;
  ::google::protobuf::uint32 ip_;
  mutable int _cached_size_;
  friend struct protobuf_topology_2eproto::TableStruct;
};
// -------------------------------------------------------------------

class NetworkInfo : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:netsensor.NetworkInfo) */ {
 public:
  NetworkInfo();
  virtual ~NetworkInfo();

  NetworkInfo(const NetworkInfo& from);

  inline NetworkInfo& operator=(const NetworkInfo& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const NetworkInfo& default_instance();

  static inline const NetworkInfo* internal_default_instance() {
    return reinterpret_cast<const NetworkInfo*>(
               &_NetworkInfo_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    2;

  void Swap(NetworkInfo* other);

  // implements Message ----------------------------------------------

  inline NetworkInfo* New() const PROTOBUF_FINAL { return New(NULL); }

  NetworkInfo* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const NetworkInfo& from);
  void MergeFrom(const NetworkInfo& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(NetworkInfo* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // string networkName = 1;
  void clear_networkname();
  static const int kNetworkNameFieldNumber = 1;
  const ::std::string& networkname() const;
  void set_networkname(const ::std::string& value);
  #if LANG_CXX11
  void set_networkname(::std::string&& value);
  #endif
  void set_networkname(const char* value);
  void set_networkname(const char* value, size_t size);
  ::std::string* mutable_networkname();
  ::std::string* release_networkname();
  void set_allocated_networkname(::std::string* networkname);

  // string networkNetmask = 2;
  void clear_networknetmask();
  static const int kNetworkNetmaskFieldNumber = 2;
  const ::std::string& networknetmask() const;
  void set_networknetmask(const ::std::string& value);
  #if LANG_CXX11
  void set_networknetmask(::std::string&& value);
  #endif
  void set_networknetmask(const char* value);
  void set_networknetmask(const char* value, size_t size);
  ::std::string* mutable_networknetmask();
  ::std::string* release_networknetmask();
  void set_allocated_networknetmask(::std::string* networknetmask);

  // uint32 interfaceIp = 3;
  void clear_interfaceip();
  static const int kInterfaceIpFieldNumber = 3;
  ::google::protobuf::uint32 interfaceip() const;
  void set_interfaceip(::google::protobuf::uint32 value);

  // @@protoc_insertion_point(class_scope:netsensor.NetworkInfo)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::internal::ArenaStringPtr networkname_;
  ::google::protobuf::internal::ArenaStringPtr networknetmask_;
  ::google::protobuf::uint32 interfaceip_;
  mutable int _cached_size_;
  friend struct protobuf_topology_2eproto::TableStruct;
};
// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// Topology

// .netsensor.NetworkInfo networkInfo = 1;
inline bool Topology::has_networkinfo() const {
  return this != internal_default_instance() && networkinfo_ != NULL;
}
inline void Topology::clear_networkinfo() {
  if (GetArenaNoVirtual() == NULL && networkinfo_ != NULL) delete networkinfo_;
  networkinfo_ = NULL;
}
inline const ::netsensor::NetworkInfo& Topology::networkinfo() const {
  // @@protoc_insertion_point(field_get:netsensor.Topology.networkInfo)
  return networkinfo_ != NULL ? *networkinfo_
                         : *::netsensor::NetworkInfo::internal_default_instance();
}
inline ::netsensor::NetworkInfo* Topology::mutable_networkinfo() {
  
  if (networkinfo_ == NULL) {
    networkinfo_ = new ::netsensor::NetworkInfo;
  }
  // @@protoc_insertion_point(field_mutable:netsensor.Topology.networkInfo)
  return networkinfo_;
}
inline ::netsensor::NetworkInfo* Topology::release_networkinfo() {
  // @@protoc_insertion_point(field_release:netsensor.Topology.networkInfo)
  
  ::netsensor::NetworkInfo* temp = networkinfo_;
  networkinfo_ = NULL;
  return temp;
}
inline void Topology::set_allocated_networkinfo(::netsensor::NetworkInfo* networkinfo) {
  delete networkinfo_;
  networkinfo_ = networkinfo;
  if (networkinfo) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:netsensor.Topology.networkInfo)
}

// repeated .netsensor.Host internals = 2;
inline int Topology::internals_size() const {
  return internals_.size();
}
inline void Topology::clear_internals() {
  internals_.Clear();
}
inline const ::netsensor::Host& Topology::internals(int index) const {
  // @@protoc_insertion_point(field_get:netsensor.Topology.internals)
  return internals_.Get(index);
}
inline ::netsensor::Host* Topology::mutable_internals(int index) {
  // @@protoc_insertion_point(field_mutable:netsensor.Topology.internals)
  return internals_.Mutable(index);
}
inline ::netsensor::Host* Topology::add_internals() {
  // @@protoc_insertion_point(field_add:netsensor.Topology.internals)
  return internals_.Add();
}
inline ::google::protobuf::RepeatedPtrField< ::netsensor::Host >*
Topology::mutable_internals() {
  // @@protoc_insertion_point(field_mutable_list:netsensor.Topology.internals)
  return &internals_;
}
inline const ::google::protobuf::RepeatedPtrField< ::netsensor::Host >&
Topology::internals() const {
  // @@protoc_insertion_point(field_list:netsensor.Topology.internals)
  return internals_;
}

// repeated .netsensor.Host localGws = 3;
inline int Topology::localgws_size() const {
  return localgws_.size();
}
inline void Topology::clear_localgws() {
  localgws_.Clear();
}
inline const ::netsensor::Host& Topology::localgws(int index) const {
  // @@protoc_insertion_point(field_get:netsensor.Topology.localGws)
  return localgws_.Get(index);
}
inline ::netsensor::Host* Topology::mutable_localgws(int index) {
  // @@protoc_insertion_point(field_mutable:netsensor.Topology.localGws)
  return localgws_.Mutable(index);
}
inline ::netsensor::Host* Topology::add_localgws() {
  // @@protoc_insertion_point(field_add:netsensor.Topology.localGws)
  return localgws_.Add();
}
inline ::google::protobuf::RepeatedPtrField< ::netsensor::Host >*
Topology::mutable_localgws() {
  // @@protoc_insertion_point(field_mutable_list:netsensor.Topology.localGws)
  return &localgws_;
}
inline const ::google::protobuf::RepeatedPtrField< ::netsensor::Host >&
Topology::localgws() const {
  // @@protoc_insertion_point(field_list:netsensor.Topology.localGws)
  return localgws_;
}

// -------------------------------------------------------------------

// Host

// uint32 ip = 1;
inline void Host::clear_ip() {
  ip_ = 0u;
}
inline ::google::protobuf::uint32 Host::ip() const {
  // @@protoc_insertion_point(field_get:netsensor.Host.ip)
  return ip_;
}
inline void Host::set_ip(::google::protobuf::uint32 value) {
  
  ip_ = value;
  // @@protoc_insertion_point(field_set:netsensor.Host.ip)
}

// string mac = 2;
inline void Host::clear_mac() {
  mac_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline const ::std::string& Host::mac() const {
  // @@protoc_insertion_point(field_get:netsensor.Host.mac)
  return mac_.GetNoArena();
}
inline void Host::set_mac(const ::std::string& value) {
  
  mac_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:netsensor.Host.mac)
}
#if LANG_CXX11
inline void Host::set_mac(::std::string&& value) {
  
  mac_.SetNoArena(
    &::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::move(value));
  // @@protoc_insertion_point(field_set_rvalue:netsensor.Host.mac)
}
#endif
inline void Host::set_mac(const char* value) {
  GOOGLE_DCHECK(value != NULL);
  
  mac_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:netsensor.Host.mac)
}
inline void Host::set_mac(const char* value, size_t size) {
  
  mac_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:netsensor.Host.mac)
}
inline ::std::string* Host::mutable_mac() {
  
  // @@protoc_insertion_point(field_mutable:netsensor.Host.mac)
  return mac_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* Host::release_mac() {
  // @@protoc_insertion_point(field_release:netsensor.Host.mac)
  
  return mac_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void Host::set_allocated_mac(::std::string* mac) {
  if (mac != NULL) {
    
  } else {
    
  }
  mac_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), mac);
  // @@protoc_insertion_point(field_set_allocated:netsensor.Host.mac)
}

// -------------------------------------------------------------------

// NetworkInfo

// string networkName = 1;
inline void NetworkInfo::clear_networkname() {
  networkname_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline const ::std::string& NetworkInfo::networkname() const {
  // @@protoc_insertion_point(field_get:netsensor.NetworkInfo.networkName)
  return networkname_.GetNoArena();
}
inline void NetworkInfo::set_networkname(const ::std::string& value) {
  
  networkname_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:netsensor.NetworkInfo.networkName)
}
#if LANG_CXX11
inline void NetworkInfo::set_networkname(::std::string&& value) {
  
  networkname_.SetNoArena(
    &::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::move(value));
  // @@protoc_insertion_point(field_set_rvalue:netsensor.NetworkInfo.networkName)
}
#endif
inline void NetworkInfo::set_networkname(const char* value) {
  GOOGLE_DCHECK(value != NULL);
  
  networkname_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:netsensor.NetworkInfo.networkName)
}
inline void NetworkInfo::set_networkname(const char* value, size_t size) {
  
  networkname_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:netsensor.NetworkInfo.networkName)
}
inline ::std::string* NetworkInfo::mutable_networkname() {
  
  // @@protoc_insertion_point(field_mutable:netsensor.NetworkInfo.networkName)
  return networkname_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* NetworkInfo::release_networkname() {
  // @@protoc_insertion_point(field_release:netsensor.NetworkInfo.networkName)
  
  return networkname_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void NetworkInfo::set_allocated_networkname(::std::string* networkname) {
  if (networkname != NULL) {
    
  } else {
    
  }
  networkname_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), networkname);
  // @@protoc_insertion_point(field_set_allocated:netsensor.NetworkInfo.networkName)
}

// string networkNetmask = 2;
inline void NetworkInfo::clear_networknetmask() {
  networknetmask_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline const ::std::string& NetworkInfo::networknetmask() const {
  // @@protoc_insertion_point(field_get:netsensor.NetworkInfo.networkNetmask)
  return networknetmask_.GetNoArena();
}
inline void NetworkInfo::set_networknetmask(const ::std::string& value) {
  
  networknetmask_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:netsensor.NetworkInfo.networkNetmask)
}
#if LANG_CXX11
inline void NetworkInfo::set_networknetmask(::std::string&& value) {
  
  networknetmask_.SetNoArena(
    &::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::move(value));
  // @@protoc_insertion_point(field_set_rvalue:netsensor.NetworkInfo.networkNetmask)
}
#endif
inline void NetworkInfo::set_networknetmask(const char* value) {
  GOOGLE_DCHECK(value != NULL);
  
  networknetmask_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:netsensor.NetworkInfo.networkNetmask)
}
inline void NetworkInfo::set_networknetmask(const char* value, size_t size) {
  
  networknetmask_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:netsensor.NetworkInfo.networkNetmask)
}
inline ::std::string* NetworkInfo::mutable_networknetmask() {
  
  // @@protoc_insertion_point(field_mutable:netsensor.NetworkInfo.networkNetmask)
  return networknetmask_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* NetworkInfo::release_networknetmask() {
  // @@protoc_insertion_point(field_release:netsensor.NetworkInfo.networkNetmask)
  
  return networknetmask_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void NetworkInfo::set_allocated_networknetmask(::std::string* networknetmask) {
  if (networknetmask != NULL) {
    
  } else {
    
  }
  networknetmask_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), networknetmask);
  // @@protoc_insertion_point(field_set_allocated:netsensor.NetworkInfo.networkNetmask)
}

// uint32 interfaceIp = 3;
inline void NetworkInfo::clear_interfaceip() {
  interfaceip_ = 0u;
}
inline ::google::protobuf::uint32 NetworkInfo::interfaceip() const {
  // @@protoc_insertion_point(field_get:netsensor.NetworkInfo.interfaceIp)
  return interfaceip_;
}
inline void NetworkInfo::set_interfaceip(::google::protobuf::uint32 value) {
  
  interfaceip_ = value;
  // @@protoc_insertion_point(field_set:netsensor.NetworkInfo.interfaceIp)
}

#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS
// -------------------------------------------------------------------

// -------------------------------------------------------------------


// @@protoc_insertion_point(namespace_scope)


}  // namespace netsensor

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_topology_2eproto__INCLUDED