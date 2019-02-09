// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subjects/disservice/disservice.proto

#ifndef PROTOBUF_INCLUDED_subjects_2fdisservice_2fdisservice_2eproto
#define PROTOBUF_INCLUDED_subjects_2fdisservice_2fdisservice_2eproto

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
#define PROTOBUF_INTERNAL_EXPORT_protobuf_subjects_2fdisservice_2fdisservice_2eproto

namespace protobuf_subjects_2fdisservice_2fdisservice_2eproto {
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
}  // namespace protobuf_subjects_2fdisservice_2fdisservice_2eproto
namespace disservice {
}  // namespace disservice
namespace disservice {

enum Str {
  sensor_ip = 0,
  peer_id = 1,
  remote_peer_id = 2,
  remote_peer_ip = 3,
  Str_INT_MIN_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32min,
  Str_INT_MAX_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32max
};
bool Str_IsValid(int value);
const Str Str_MIN = sensor_ip;
const Str Str_MAX = remote_peer_ip;
const int Str_ARRAYSIZE = Str_MAX + 1;

const ::google::protobuf::EnumDescriptor* Str_descriptor();
inline const ::std::string& Str_Name(Str value) {
  return ::google::protobuf::internal::NameOfEnum(
    Str_descriptor(), value);
}
inline bool Str_Parse(
    const ::std::string& name, Str* value) {
  return ::google::protobuf::internal::ParseNamedEnum<Str>(
    Str_descriptor(), name, value);
}
enum Int {
  data_message_received = 0,
  data_bytes_received = 1,
  data_fragments_received = 2,
  data_fragment_bytes_received = 3,
  missing_fragment_request_messages_sent = 4,
  missing_fragment_request_bytes_sent = 5,
  missing_fragment_request_messages_received = 6,
  missing_fragment_request_bytes_received = 7,
  data_cache_query_messages_sent = 8,
  data_cache_query_bytes_sent = 9,
  data_cache_query_messages_received = 10,
  data_cache_query_bytes_received = 11,
  targeted_duplicate_traffic = 12,
  topology_state_messages_sent = 13,
  topology_state_bytes_sent = 14,
  topology_state_messages_received = 15,
  topology_state_bytes_received = 16,
  keep_alive_messages_sent = 17,
  keep_alive_messages_received = 18,
  query_messages_sent = 19,
  query_messages_received = 20,
  query_hits_messages_sent = 21,
  query_hits_messages_received = 22,
  client_messages_pushed = 23,
  client_bytes_pushed = 24,
  client_messages_made_available = 25,
  client_bytes_made_available = 26,
  fragments_pushed = 27,
  fragment_bytes_pushed = 28,
  on_demand_fragments_sent = 29,
  on_demand_fragment_bytes_sent = 30,
  overheard_duplicate_traffic = 31,
  nms_msg_count_unicast = 32,
  nms_msg_count_manycast = 33,
  Int_INT_MIN_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32min,
  Int_INT_MAX_SENTINEL_DO_NOT_USE_ = ::google::protobuf::kint32max
};
bool Int_IsValid(int value);
const Int Int_MIN = data_message_received;
const Int Int_MAX = nms_msg_count_manycast;
const int Int_ARRAYSIZE = Int_MAX + 1;

const ::google::protobuf::EnumDescriptor* Int_descriptor();
inline const ::std::string& Int_Name(Int value) {
  return ::google::protobuf::internal::NameOfEnum(
    Int_descriptor(), value);
}
inline bool Int_Parse(
    const ::std::string& name, Int* value) {
  return ::google::protobuf::internal::ParseNamedEnum<Int>(
    Int_descriptor(), name, value);
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

}  // namespace disservice

namespace google {
namespace protobuf {

template <> struct is_proto_enum< ::disservice::Str> : ::std::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::disservice::Str>() {
  return ::disservice::Str_descriptor();
}
template <> struct is_proto_enum< ::disservice::Int> : ::std::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::disservice::Int>() {
  return ::disservice::Int_descriptor();
}

}  // namespace protobuf
}  // namespace google

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_INCLUDED_subjects_2fdisservice_2fdisservice_2eproto
