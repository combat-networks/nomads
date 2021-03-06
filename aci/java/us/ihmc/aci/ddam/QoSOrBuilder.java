// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: qos.proto

package us.ihmc.aci.ddam;

public interface QoSOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.QoS)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.MicroFlow> 
      getMicroflowsList();
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  us.ihmc.aci.ddam.MicroFlow getMicroflows(int index);
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  int getMicroflowsCount();
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.MicroFlowOrBuilder> 
      getMicroflowsOrBuilderList();
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  us.ihmc.aci.ddam.MicroFlowOrBuilder getMicroflowsOrBuilder(
      int index);

  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  boolean hasTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
