// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traffic.proto

package us.ihmc.aci.ddam;

public interface TrafficOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.Traffic)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;uint32, .ddam.Source&gt; sources = 1;</code>
   *
   * <pre>
   *the sources of traffic, the key is the source ip, value is the object source
   * </pre>
   */
  java.util.Map<java.lang.Integer, us.ihmc.aci.ddam.Source>
  getSources();
}
