// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: networkhealth.proto

package us.ihmc.aci.ddam;

public final class NetworkHealthProto {
  private NetworkHealthProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_NetworkHealth_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_NetworkHealth_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023networkhealth.proto\022\004ddam\032\037google/prot" +
      "obuf/timestamp.proto\"\355\002\n\rNetworkHealth\022\016" +
      "\n\006subnet\030\001 \001(\t\022\016\n\006ipList\030\002 \003(\t\022\023\n\013networ" +
      "kName\030\003 \001(\t\022\021\n\tcollector\030\004 \001(\t\022\017\n\007versio" +
      "n\030\005 \001(\t\022\027\n\017interconnectedP\030\006 \001(\r\022\021\n\tback" +
      "haulP\030\007 \001(\r\022\r\n\005delay\030\010 \001(\r\022\022\n\nsaturation" +
      "\030\t \001(\r\022\036\n\026totalBandwidthMeasured\030\n \001(\r\022\037" +
      "\n\027totalBandwidthEstimated\030\013 \001(\r\022\037\n\027withi" +
      "nBandwidthMeasured\030\014 \001(\r\022 \n\030withinBandwi" +
      "dthEstimated\030\r \001(\r\0220\n\014creationTime\030\016 \001(\013",
      "2\032.google.protobuf.TimestampB+\n\020us.ihmc." +
      "aci.ddamB\022NetworkHealthProtoP\001\240\001\001b\006proto" +
      "3"
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
        }, assigner);
    internal_static_ddam_NetworkHealth_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ddam_NetworkHealth_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_NetworkHealth_descriptor,
        new java.lang.String[] { "Subnet", "IpList", "NetworkName", "Collector", "Version", "InterconnectedP", "BackhaulP", "Delay", "Saturation", "TotalBandwidthMeasured", "TotalBandwidthEstimated", "WithinBandwidthMeasured", "WithinBandwidthEstimated", "CreationTime", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
