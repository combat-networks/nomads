// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: topology.proto

package us.ihmc.aci.ddam;

public interface TopologyPartsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.TopologyParts)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string networkName = 1;</code>
   *
   * <pre>
   *a named network segment expressed as a string 
   * </pre>
   */
  java.lang.String getNetworkName();
  /**
   * <code>optional string networkName = 1;</code>
   *
   * <pre>
   *a named network segment expressed as a string 
   * </pre>
   */
  com.google.protobuf.ByteString
      getNetworkNameBytes();

  /**
   * <code>optional string subnetMask = 2;</code>
   *
   * <pre>
   *the subnetmask of this network segment
   * </pre>
   */
  java.lang.String getSubnetMask();
  /**
   * <code>optional string subnetMask = 2;</code>
   *
   * <pre>
   *the subnetmask of this network segment
   * </pre>
   */
  com.google.protobuf.ByteString
      getSubnetMaskBytes();

  /**
   * <code>repeated .ddam.Host internals = 3;</code>
   *
   * <pre>
   *a list of internal nodes expressed as Host objects
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.Host> 
      getInternalsList();
  /**
   * <code>repeated .ddam.Host internals = 3;</code>
   *
   * <pre>
   *a list of internal nodes expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.Host getInternals(int index);
  /**
   * <code>repeated .ddam.Host internals = 3;</code>
   *
   * <pre>
   *a list of internal nodes expressed as Host objects
   * </pre>
   */
  int getInternalsCount();
  /**
   * <code>repeated .ddam.Host internals = 3;</code>
   *
   * <pre>
   *a list of internal nodes expressed as Host objects
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.HostOrBuilder> 
      getInternalsOrBuilderList();
  /**
   * <code>repeated .ddam.Host internals = 3;</code>
   *
   * <pre>
   *a list of internal nodes expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.HostOrBuilder getInternalsOrBuilder(
      int index);

  /**
   * <code>repeated .ddam.Host localGws = 4;</code>
   *
   * <pre>
   *a list of local gateways expressed as Host objects
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.Host> 
      getLocalGwsList();
  /**
   * <code>repeated .ddam.Host localGws = 4;</code>
   *
   * <pre>
   *a list of local gateways expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.Host getLocalGws(int index);
  /**
   * <code>repeated .ddam.Host localGws = 4;</code>
   *
   * <pre>
   *a list of local gateways expressed as Host objects
   * </pre>
   */
  int getLocalGwsCount();
  /**
   * <code>repeated .ddam.Host localGws = 4;</code>
   *
   * <pre>
   *a list of local gateways expressed as Host objects
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.HostOrBuilder> 
      getLocalGwsOrBuilderList();
  /**
   * <code>repeated .ddam.Host localGws = 4;</code>
   *
   * <pre>
   *a list of local gateways expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.HostOrBuilder getLocalGwsOrBuilder(
      int index);

  /**
   * <code>repeated .ddam.Host remoteGws = 5;</code>
   *
   * <pre>
   *a list of remote gateways expressed as Host objects
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.Host> 
      getRemoteGwsList();
  /**
   * <code>repeated .ddam.Host remoteGws = 5;</code>
   *
   * <pre>
   *a list of remote gateways expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.Host getRemoteGws(int index);
  /**
   * <code>repeated .ddam.Host remoteGws = 5;</code>
   *
   * <pre>
   *a list of remote gateways expressed as Host objects
   * </pre>
   */
  int getRemoteGwsCount();
  /**
   * <code>repeated .ddam.Host remoteGws = 5;</code>
   *
   * <pre>
   *a list of remote gateways expressed as Host objects
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.HostOrBuilder> 
      getRemoteGwsOrBuilderList();
  /**
   * <code>repeated .ddam.Host remoteGws = 5;</code>
   *
   * <pre>
   *a list of remote gateways expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.HostOrBuilder getRemoteGwsOrBuilder(
      int index);

  /**
   * <code>repeated .ddam.Host externals = 6;</code>
   *
   * <pre>
   *a list of external nodes expressed as Host objects
   * </pre>
   */
  java.util.List<us.ihmc.aci.ddam.Host> 
      getExternalsList();
  /**
   * <code>repeated .ddam.Host externals = 6;</code>
   *
   * <pre>
   *a list of external nodes expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.Host getExternals(int index);
  /**
   * <code>repeated .ddam.Host externals = 6;</code>
   *
   * <pre>
   *a list of external nodes expressed as Host objects
   * </pre>
   */
  int getExternalsCount();
  /**
   * <code>repeated .ddam.Host externals = 6;</code>
   *
   * <pre>
   *a list of external nodes expressed as Host objects
   * </pre>
   */
  java.util.List<? extends us.ihmc.aci.ddam.HostOrBuilder> 
      getExternalsOrBuilderList();
  /**
   * <code>repeated .ddam.Host externals = 6;</code>
   *
   * <pre>
   *a list of external nodes expressed as Host objects
   * </pre>
   */
  us.ihmc.aci.ddam.HostOrBuilder getExternalsOrBuilder(
      int index);

  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 7;</code>
   *
   * <pre>
   *time this object was created
   * </pre>
   */
  boolean hasTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 7;</code>
   *
   * <pre>
   *time this object was created
   * </pre>
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 7;</code>
   *
   * <pre>
   *time this object was created
   * </pre>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}
