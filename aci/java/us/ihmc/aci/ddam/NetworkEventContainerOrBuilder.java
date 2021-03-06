// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: networkevent.proto

package us.ihmc.aci.ddam;

public interface NetworkEventContainerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.NetworkEventContainer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .ddam.NetworkEvent events = 1;</code>
   *
   * <pre>
   *list of events
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.NetworkEvent> 
      getEventsList();
  /**
   * <code>repeated .ddam.NetworkEvent events = 1;</code>
   *
   * <pre>
   *list of events
   * </pre>
   */
  us.ihmc.aci.ddam.NetworkEvent getEvents(int index);
  /**
   * <code>repeated .ddam.NetworkEvent events = 1;</code>
   *
   * <pre>
   *list of events
   * </pre>
   */
  int getEventsCount();
  /**
   * <code>repeated .ddam.NetworkEvent events = 1;</code>
   *
   * <pre>
   *list of events
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.NetworkEventOrBuilder> 
      getEventsOrBuilderList();
  /**
   * <code>repeated .ddam.NetworkEvent events = 1;</code>
   *
   * <pre>
   *list of events
   * </pre>
   */
  us.ihmc.aci.ddam.NetworkEventOrBuilder getEventsOrBuilder(
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
