// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: prefix.proto

#ifndef PROTOBUF_INCLUDED_prefix_2eproto
#define PROTOBUF_INCLUDED_prefix_2eproto

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
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/generated_enum_reflection.h>
// @@protoc_insertion_point(includes)
#define PROTOBUF_INTERNAL_EXPORT_protobuf_prefix_2eproto 

namespace protobuf_prefix_2eproto {
// Internal implementation detail -- do not use these members.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[1];
  static const ::google::protobuf::internal::FieldMetadata field_metadata[];
  static const ::google::protobuf::internal::SerializationTable serialization_table[];
  static const ::google::protobuf::uint32 offsets[];
};
void AddDescriptors();
}  // namespace protobuf_prefix_2eproto
namespace netsensor {
}  // namespace netsensor
namespace netsensor {

enum Prefix {
  NONE = 0,
  K = 1,
  M = 2,
  Prefix_INT_MIN_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32min,
  Prefix_INT_MAX_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32max
};
bool Prefix_IsValid(int value);
const Prefix Prefix_MIN = NONE;
const Prefix Prefix_MAX = M;
const int Prefix_ARRAYSIZE = Prefix_MAX + 1;

const ::google::protobuf::EnumDescriptor* Prefix_descriptor();
inline const ::std::string& Prefix_Name(Prefix value) {
  return ::google::protobuf::internal::NameOfEnum(
    Prefix_descriptor(), value);
}
inline bool Prefix_Parse(
    const ::std::string& name, Prefix* value) {
  return ::google::protobuf::internal::ParseNamedEnum<Prefix>(
    Prefix_descriptor(), name, value);
}
// ===================================================================


// ===================================================================


// ===================================================================

#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__

// @@protoc_insertion_point(namespace_scope)

}  // namespace netsensor

namespace google {
namespace protobuf {

template <> struct is_proto_enum< ::netsensor::Prefix> : ::std::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::netsensor::Prefix>() {
  return ::netsensor::Prefix_descriptor();
}

}  // namespace protobuf
}  // namespace google

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_INCLUDED_prefix_2eproto
