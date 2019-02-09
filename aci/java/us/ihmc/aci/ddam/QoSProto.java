// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: qos.proto

package us.ihmc.aci.ddam;

public final class QoSProto {
  private QoSProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_QoS_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_QoS_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_MicroFlow_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_MicroFlow_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_TagList_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_TagList_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_TaggedQoS_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_TaggedQoS_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tqos.proto\022\004ddam\032\037google/protobuf/times" +
      "tamp.proto\032\036google/protobuf/duration.pro" +
      "to\"Y\n\003QoS\022#\n\nmicroflows\030\001 \003(\0132\017.ddam.Mic" +
      "roFlow\022-\n\ttimestamp\030\002 \001(\0132\032.google.proto" +
      "buf.Timestamp\"\244\001\n\tMicroFlow\022\n\n\002id\030\001 \001(\r\022" +
      "\r\n\005ipSrc\030\002 \001(\t\022\r\n\005ipDst\030\003 \001(\t\022\017\n\007portSrc" +
      "\030\004 \001(\t\022\017\n\007portDst\030\005 \001(\t\022\020\n\010protocol\030\006 \001(" +
      "\t\022\014\n\004DSCP\030\007 \001(\r\022+\n\010duration\030\010 \001(\0132\031.goog" +
      "le.protobuf.Duration\"+\n\007TagList\022 \n\007qosTa" +
      "gs\030\001 \003(\0132\017.ddam.TaggedQoS\"0\n\tTaggedQoS\022\013",
      "\n\003tag\030\001 \001(\t\022\026\n\003qos\030\002 \001(\0132\t.ddam.QoSB!\n\020u" +
      "s.ihmc.aci.ddamB\010QoSProtoP\001\240\001\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.protobuf.DurationProto.getDescriptor(),
        }, assigner);
    internal_static_ddam_QoS_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ddam_QoS_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_QoS_descriptor,
        new java.lang.String[] { "Microflows", "Timestamp", });
    internal_static_ddam_MicroFlow_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ddam_MicroFlow_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_MicroFlow_descriptor,
        new java.lang.String[] { "Id", "IpSrc", "IpDst", "PortSrc", "PortDst", "Protocol", "DSCP", "Duration", });
    internal_static_ddam_TagList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ddam_TagList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_TagList_descriptor,
        new java.lang.String[] { "QosTags", });
    internal_static_ddam_TaggedQoS_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ddam_TaggedQoS_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_TaggedQoS_descriptor,
        new java.lang.String[] { "Tag", "Qos", });
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.DurationProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}