// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traffic.proto

package us.ihmc.aci.ddam;

public interface ReadableLinkOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.ReadableLink)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string ipSrc = 1;</code>
   *
   * <pre>
   *the source ip address of the link
   * </pre>
   */
  java.lang.String getIpSrc();
  /**
   * <code>optional string ipSrc = 1;</code>
   *
   * <pre>
   *the source ip address of the link
   * </pre>
   */
  com.google.protobuf.ByteString
      getIpSrcBytes();

  /**
   * <code>optional string ipDst = 2;</code>
   *
   * <pre>
   *the destination ip address of the link 
   * </pre>
   */
  java.lang.String getIpDst();
  /**
   * <code>optional string ipDst = 2;</code>
   *
   * <pre>
   *the destination ip address of the link 
   * </pre>
   */
  com.google.protobuf.ByteString
      getIpDstBytes();

  /**
   * <code>repeated .ddam.Stat stats = 3;</code>
   *
   * <pre>
   *a list of stat objects containing statistics about the link
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.Stat> 
      getStatsList();
  /**
   * <code>repeated .ddam.Stat stats = 3;</code>
   *
   * <pre>
   *a list of stat objects containing statistics about the link
   * </pre>
   */
  us.ihmc.aci.ddam.Stat getStats(int index);
  /**
   * <code>repeated .ddam.Stat stats = 3;</code>
   *
   * <pre>
   *a list of stat objects containing statistics about the link
   * </pre>
   */
  int getStatsCount();
  /**
   * <code>repeated .ddam.Stat stats = 3;</code>
   *
   * <pre>
   *a list of stat objects containing statistics about the link
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.StatOrBuilder> 
      getStatsOrBuilderList();
  /**
   * <code>repeated .ddam.Stat stats = 3;</code>
   *
   * <pre>
   *a list of stat objects containing statistics about the link
   * </pre>
   */
  us.ihmc.aci.ddam.StatOrBuilder getStatsOrBuilder(
      int index);

  /**
   * <code>optional .ddam.Description description = 4;</code>
   *
   * <pre>
   *a description about the current network conditions of the link
   * </pre>
   */
  boolean hasDescription();
  /**
   * <code>optional .ddam.Description description = 4;</code>
   *
   * <pre>
   *a description about the current network conditions of the link
   * </pre>
   */
  us.ihmc.aci.ddam.Description getDescription();
  /**
   * <code>optional .ddam.Description description = 4;</code>
   *
   * <pre>
   *a description about the current network conditions of the link
   * </pre>
   */
  us.ihmc.aci.ddam.DescriptionOrBuilder getDescriptionOrBuilder();

  /**
   * <code>optional .ddam.MocketSensor mocketSensor = 5;</code>
   *
   * <pre>
   *data provided by the Mocket sensor
   * </pre>
   */
  boolean hasMocketSensor();
  /**
   * <code>optional .ddam.MocketSensor mocketSensor = 5;</code>
   *
   * <pre>
   *data provided by the Mocket sensor
   * </pre>
   */
  us.ihmc.aci.ddam.MocketSensor getMocketSensor();
  /**
   * <code>optional .ddam.MocketSensor mocketSensor = 5;</code>
   *
   * <pre>
   *data provided by the Mocket sensor
   * </pre>
   */
  us.ihmc.aci.ddam.MocketSensorOrBuilder getMocketSensorOrBuilder();

  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 6;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  boolean hasTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 6;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 6;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
