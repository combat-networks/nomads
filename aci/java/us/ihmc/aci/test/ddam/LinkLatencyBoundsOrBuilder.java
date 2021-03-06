// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linktype.proto

package us.ihmc.aci.test.ddam;

public interface LinkLatencyBoundsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.LinkLatencyBounds)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint32 lowerLatency = 1;</code>
   *
   * <pre>
   *lower bound for the latency
   * </pre>
   */
  int getLowerLatency();

  /**
   * <code>optional uint32 upperLatency = 2;</code>
   *
   * <pre>
   *upper bound for the latency
   * </pre>
   */
  int getUpperLatency();

  /**
   * <code>optional uint32 lowerLatencyStep = 3;</code>
   *
   * <pre>
   *lower step for the latency
   * </pre>
   */
  int getLowerLatencyStep();

  /**
   * <code>optional uint32 upperLatencyStep = 4;</code>
   *
   * <pre>
   *upper step for the latency
   * </pre>
   */
  int getUpperLatencyStep();
}
