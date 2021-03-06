// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: container.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf enum {@code ddam.DataType}
 */
public enum DataType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>INFO = 0;</code>
   *
   * <pre>
   *a data type INFO contains general hardware and software information about the node
   * </pre>
   */
  INFO(0, 0),
  /**
   * <code>GROUP = 1;</code>
   *
   * <pre>
   *a data type GROUP contains information detected through the GroupManager
   * </pre>
   */
  GROUP(1, 1),
  /**
   * <code>LINK = 2;</code>
   *
   * <pre>
   *a data type LINK contains information about each individual Link of the network
   * </pre>
   */
  LINK(2, 2),
  /**
   * <code>TRAFFIC = 3;</code>
   *
   * <pre>
   *a data type TRAFFIC contains information about a global Traffic instance of the network
   * </pre>
   */
  TRAFFIC(3, 3),
  /**
   * <code>TOPOLOGY = 4;</code>
   *
   * <pre>
   *a data type TOPOLOGY contains information abotu the Topology
   * </pre>
   */
  TOPOLOGY(4, 4),
  /**
   * <code>TOPOLOGY_PARTS = 5;</code>
   *
   * <pre>
   *a data type TOPOLOGY_PARTS contains a summary of topology parts
   * </pre>
   */
  TOPOLOGY_PARTS(5, 5),
  /**
   * <code>NETWORK_HEALTH = 6;</code>
   *
   * <pre>
   *a data type NETWORK_HEALTH contains a summary of the status of a particular subnetwork
   * </pre>
   */
  NETWORK_HEALTH(6, 6),
  /**
   * <code>NODE = 7;</code>
   *
   * <pre>
   *a data type NODE containes a whole node update
   * </pre>
   */
  NODE(7, 7),
  UNRECOGNIZED(-1, -1),
  ;

  /**
   * <code>INFO = 0;</code>
   *
   * <pre>
   *a data type INFO contains general hardware and software information about the node
   * </pre>
   */
  public static final int INFO_VALUE = 0;
  /**
   * <code>GROUP = 1;</code>
   *
   * <pre>
   *a data type GROUP contains information detected through the GroupManager
   * </pre>
   */
  public static final int GROUP_VALUE = 1;
  /**
   * <code>LINK = 2;</code>
   *
   * <pre>
   *a data type LINK contains information about each individual Link of the network
   * </pre>
   */
  public static final int LINK_VALUE = 2;
  /**
   * <code>TRAFFIC = 3;</code>
   *
   * <pre>
   *a data type TRAFFIC contains information about a global Traffic instance of the network
   * </pre>
   */
  public static final int TRAFFIC_VALUE = 3;
  /**
   * <code>TOPOLOGY = 4;</code>
   *
   * <pre>
   *a data type TOPOLOGY contains information abotu the Topology
   * </pre>
   */
  public static final int TOPOLOGY_VALUE = 4;
  /**
   * <code>TOPOLOGY_PARTS = 5;</code>
   *
   * <pre>
   *a data type TOPOLOGY_PARTS contains a summary of topology parts
   * </pre>
   */
  public static final int TOPOLOGY_PARTS_VALUE = 5;
  /**
   * <code>NETWORK_HEALTH = 6;</code>
   *
   * <pre>
   *a data type NETWORK_HEALTH contains a summary of the status of a particular subnetwork
   * </pre>
   */
  public static final int NETWORK_HEALTH_VALUE = 6;
  /**
   * <code>NODE = 7;</code>
   *
   * <pre>
   *a data type NODE containes a whole node update
   * </pre>
   */
  public static final int NODE_VALUE = 7;


  public final int getNumber() {
    if (index == -1) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  public static DataType valueOf(int value) {
    switch (value) {
      case 0: return INFO;
      case 1: return GROUP;
      case 2: return LINK;
      case 3: return TRAFFIC;
      case 4: return TOPOLOGY;
      case 5: return TOPOLOGY_PARTS;
      case 6: return NETWORK_HEALTH;
      case 7: return NODE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DataType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DataType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DataType>() {
          public DataType findValueByNumber(int number) {
            return DataType.valueOf(number);
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
        .getEnumTypes().get(0);
  }

  private static final DataType[] VALUES = values();

  public static DataType valueOf(
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

  private DataType(int index, int value) {
    this.index = index;
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:ddam.DataType)
}

