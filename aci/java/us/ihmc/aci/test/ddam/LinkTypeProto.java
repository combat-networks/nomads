// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linktype.proto

package us.ihmc.aci.test.ddam;

public final class LinkTypeProto {
  private LinkTypeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkTypes_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkTypes_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_InfoType_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_InfoType_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkValues_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkValues_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkAlgorithmBounds_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkAlgorithmBounds_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkThroughputBounds_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkThroughputBounds_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_LinkLatencyBounds_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_LinkLatencyBounds_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016linktype.proto\022\004ddam\"-\n\tLinkTypes\022 \n\010l" +
      "inkType\030\001 \003(\0132\016.ddam.LinkType\"\201\001\n\010LinkTy" +
      "pe\022\n\n\002id\030\001 \001(\t\022\034\n\004info\030\002 \001(\0132\016.ddam.Info" +
      "Type\022 \n\006values\030\003 \001(\0132\020.ddam.LinkValues\022)" +
      "\n\006bounds\030\004 \001(\0132\031.ddam.LinkAlgorithmBound" +
      "s\"0\n\010InfoType\022\017\n\007version\030\001 \001(\t\022\023\n\013descri" +
      "ption\030\002 \001(\t\"W\n\nLinkValues\022\022\n\nthroughput\030" +
      "\001 \001(\001\022\017\n\007latency\030\002 \001(\r\022\021\n\tfrequency\030\003 \001(" +
      "\001\022\021\n\tmuxScheme\030\004 \001(\t\"\203\001\n\023LinkAlgorithmBo" +
      "unds\0228\n\024linkThroughputBounds\030\001 \001(\0132\032.dda",
      "m.LinkThroughputBounds\0222\n\021linkLatencyBou" +
      "nds\030\002 \001(\0132\027.ddam.LinkLatencyBounds\"G\n\024Li" +
      "nkThroughputBounds\022\027\n\017lowerThroughput\030\001 " +
      "\001(\001\022\026\n\016throughputStep\030\002 \001(\001\"s\n\021LinkLaten" +
      "cyBounds\022\024\n\014lowerLatency\030\001 \001(\r\022\024\n\014upperL" +
      "atency\030\002 \001(\r\022\030\n\020lowerLatencyStep\030\003 \001(\r\022\030" +
      "\n\020upperLatencyStep\030\004 \001(\rB+\n\025us.ihmc.aci." +
      "test.ddamB\rLinkTypeProtoP\001\240\001\001b\006proto3"
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
        }, assigner);
    internal_static_ddam_LinkTypes_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ddam_LinkTypes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkTypes_descriptor,
        new java.lang.String[] { "LinkType", });
    internal_static_ddam_LinkType_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ddam_LinkType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkType_descriptor,
        new java.lang.String[] { "Id", "Info", "Values", "Bounds", });
    internal_static_ddam_InfoType_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ddam_InfoType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_InfoType_descriptor,
        new java.lang.String[] { "Version", "Description", });
    internal_static_ddam_LinkValues_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ddam_LinkValues_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkValues_descriptor,
        new java.lang.String[] { "Throughput", "Latency", "Frequency", "MuxScheme", });
    internal_static_ddam_LinkAlgorithmBounds_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ddam_LinkAlgorithmBounds_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkAlgorithmBounds_descriptor,
        new java.lang.String[] { "LinkThroughputBounds", "LinkLatencyBounds", });
    internal_static_ddam_LinkThroughputBounds_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ddam_LinkThroughputBounds_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkThroughputBounds_descriptor,
        new java.lang.String[] { "LowerThroughput", "ThroughputStep", });
    internal_static_ddam_LinkLatencyBounds_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ddam_LinkLatencyBounds_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_LinkLatencyBounds_descriptor,
        new java.lang.String[] { "LowerLatency", "UpperLatency", "LowerLatencyStep", "UpperLatencyStep", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
