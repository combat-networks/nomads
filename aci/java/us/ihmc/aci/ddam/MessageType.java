// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: container.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf enum {@code ddam.MessageType}
 */
public enum MessageType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UPDATE_DATA = 0;</code>
   *
   * <pre>
   *indicates that the message is a data update
   * </pre>
   */
  UPDATE_DATA(0, 0),
  /**
   * <code>UPDATE_WORLD_STATE = 1;</code>
   *
   * <pre>
   *indicates that the message is a world state update
   * </pre>
   */
  UPDATE_WORLD_STATE(1, 1),
  UNRECOGNIZED(-1, -1),
  ;

  /**
   * <code>UPDATE_DATA = 0;</code>
   *
   * <pre>
   *indicates that the message is a data update
   * </pre>
   */
  public static final int UPDATE_DATA_VALUE = 0;
  /**
   * <code>UPDATE_WORLD_STATE = 1;</code>
   *
   * <pre>
   *indicates that the message is a world state update
   * </pre>
   */
  public static final int UPDATE_WORLD_STATE_VALUE = 1;


  public final int getNumber() {
    if (index == -1) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  public static MessageType valueOf(int value) {
    switch (value) {
      case 0: return UPDATE_DATA;
      case 1: return UPDATE_WORLD_STATE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MessageType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
          public MessageType findValueByNumber(int number) {
            return MessageType.valueOf(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(index);
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return us.ihmc.aci.ddam.ContainerProto.getDescriptor()
        .getEnumTypes().get(1);
  }

  private static final MessageType[] VALUES = values();

  public static MessageType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int index;
  private final int value;

  private MessageType(int index, int value) {
    this.index = index;
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ddam.MessageType)
}
