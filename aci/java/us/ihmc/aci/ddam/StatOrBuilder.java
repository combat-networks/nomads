// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traffic.proto

package us.ihmc.aci.ddam;

public interface StatOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.Stat)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string protocol = 1;</code>
   *
   * <pre>
   *protocol used
   * </pre>
   */
  java.lang.String getProtocol();
  /**
   * <code>optional string protocol = 1;</code>
   *
   * <pre>
   *protocol used
   * </pre>
   */
  com.google.protobuf.ByteString
      getProtocolBytes();

  /**
   * <code>optional uint32 port = 2;</code>
   *
   * <pre>
   *destination port
   * </pre>
   */
  int getPort();

  /**
   * <code>optional uint32 sentFiveSec = 3;</code>
   *
   * <pre>
   *average bandwidth in the last 5 seconds (sent)
   * </pre>
   */
  int getSentFiveSec();

  /**
   * <code>optional uint32 receivedFiveSec = 4;</code>
   *
   * <pre>
   *average bandwidth in the last 5 seconds (received)
   * </pre>
   */
  int getReceivedFiveSec();

  /**
   * <code>optional uint32 observedFiveSec = 5;</code>
   *
   * <pre>
   *average bandwidth in the last 5 seconds (observed)
   * </pre>
   */
  int getObservedFiveSec();

  /**
   * <code>optional uint32 sentMinute = 6;</code>
   *
   * <pre>
   *average bandwidth in the last minute (sent)
   * </pre>
   */
  int getSentMinute();

  /**
   * <code>optional uint32 receivedMinute = 7;</code>
   *
   * <pre>
   *average bandwidth in the last minute (received)
   * </pre>
   */
  int getReceivedMinute();

  /**
   * <code>optional uint32 observedMinute = 8;</code>
   *
   * <pre>
   *average bandwidth in the last minute (observed)
   * </pre>
   */
  int getObservedMinute();
}