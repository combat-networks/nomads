// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: readabletraffic.proto

package us.ihmc.aci.ddam;

public final class ReadableTrafficProto {
  private ReadableTrafficProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_ReadableTraffic_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_ReadableTraffic_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_ReadableTraffic_SourcesEntry_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_ReadableTraffic_SourcesEntry_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_ReadableSource_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_ReadableSource_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ddam_ReadableSource_DestinationsEntry_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ddam_ReadableSource_DestinationsEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025readabletraffic.proto\022\004ddam\032\rtraffic.p" +
      "roto\"\214\001\n\017ReadableTraffic\0223\n\007sources\030\001 \003(" +
      "\0132\".ddam.ReadableTraffic.SourcesEntry\032D\n" +
      "\014SourcesEntry\022\013\n\003key\030\001 \001(\t\022#\n\005value\030\002 \001(" +
      "\0132\024.ddam.ReadableSource:\0028\001\"\217\001\n\016Readable" +
      "Source\022<\n\014destinations\030\002 \003(\0132&.ddam.Read" +
      "ableSource.DestinationsEntry\032?\n\021Destinat" +
      "ionsEntry\022\013\n\003key\030\001 \001(\t\022\031\n\005value\030\002 \001(\0132\n." +
      "ddam.Link:\0028\001B-\n\020us.ihmc.aci.ddamB\024Reada" +
      "bleTrafficProtoP\001\240\001\001b\006proto3"
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
          us.ihmc.aci.ddam.TrafficProto.getDescriptor(),
        }, assigner);
    internal_static_ddam_ReadableTraffic_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ddam_ReadableTraffic_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_ReadableTraffic_descriptor,
        new java.lang.String[] { "Sources", });
    internal_static_ddam_ReadableTraffic_SourcesEntry_descriptor =
      internal_static_ddam_ReadableTraffic_descriptor.getNestedTypes().get(0);
    internal_static_ddam_ReadableTraffic_SourcesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_ReadableTraffic_SourcesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_ddam_ReadableSource_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ddam_ReadableSource_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_ReadableSource_descriptor,
        new java.lang.String[] { "Destinations", });
    internal_static_ddam_ReadableSource_DestinationsEntry_descriptor =
      internal_static_ddam_ReadableSource_descriptor.getNestedTypes().get(0);
    internal_static_ddam_ReadableSource_DestinationsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_ddam_ReadableSource_DestinationsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    us.ihmc.aci.ddam.TrafficProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
