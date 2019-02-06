// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datatype.proto

#ifndef PROTOBUF_datatype_2eproto__INCLUDED
#define PROTOBUF_datatype_2eproto__INCLUDED

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
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/generated_enum_reflection.h>
// @@protoc_insertion_point(includes)
namespace netsensor {
}  // namespace netsensor

namespace netsensor {

namespace protobuf_datatype_2eproto {
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
}  // namespace protobuf_datatype_2eproto

enum DataType {
  TRAFFIC = 0,
  TOPOLOGY = 1,
  NETPROXY = 2,
  ICMP = 3,
  DataType_INT_MIN_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32min,
  DataType_INT_MAX_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32max
};
bool DataType_IsValid(int value);
const DataType DataType_MIN = TRAFFIC;
const DataType DataType_MAX = ICMP;
const int DataType_ARRAYSIZE = DataType_MAX + 1;

const ::google::protobuf::EnumDescriptor* DataType_descriptor();
inline const ::std::string& DataType_Name(DataType value) {
  return ::google::protobuf::internal::NameOfEnum(
    DataType_descriptor(), value);
}
inline bool DataType_Parse(
    const ::std::string& name, DataType* value) {
  return ::google::protobuf::internal::ParseNamedEnum<DataType>(
    DataType_descriptor(), name, value);
}
enum StatType {
  TRAFFIC_AVERAGE = 0,
  PACKETS = 1,
  StatType_INT_MIN_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32min,
  StatType_INT_MAX_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32max
};
bool StatType_IsValid(int value);
const StatType StatType_MIN = TRAFFIC_AVERAGE;
const StatType StatType_MAX = PACKETS;
const int StatType_ARRAYSIZE = StatType_MAX + 1;

const ::google::protobuf::EnumDescriptor* StatType_descriptor();
inline const ::std::string& StatType_Name(StatType value) {
  return ::google::protobuf::internal::NameOfEnum(
    StatType_descriptor(), value);
}
inline bool StatType_Parse(
    const ::std::string& name, StatType* value) {
  return ::google::protobuf::internal::ParseNamedEnum<StatType>(
    StatType_descriptor(), name, value);
}
// ===================================================================


// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)


}  // namespace netsensor

#ifndef SWIG
namespace google {
namespace protobuf {

template <> struct is_proto_enum< ::netsensor::DataType> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::netsensor::DataType>() {
  return ::netsensor::DataType_descriptor();
}
template <> struct is_proto_enum< ::netsensor::StatType> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::netsensor::StatType>() {
  return ::netsensor::StatType_descriptor();
}

}  // namespace protobuf
}  // namespace google
#endif  // SWIG

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_datatype_2eproto__INCLUDED