// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grump.proto

package us.ihmc.aci.ddam;

public interface GrumpOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.Grump)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .ddam.Group&gt; groups = 1;</code>
   *
   * <pre>
   *the discovered groups, key is the name of the group
   * </pre>
   */
  java.util.Map<java.lang.String, us.ihmc.aci.ddam.Group>
  getGroups();

  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  boolean hasTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created
   * </pre>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
