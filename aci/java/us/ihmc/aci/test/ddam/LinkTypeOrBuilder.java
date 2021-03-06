// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linktype.proto

package us.ihmc.aci.test.ddam;

public interface LinkTypeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ddam.LinkType)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string id = 1;</code>
   *
   * <pre>
   *id of the type of network
   * </pre>
   */
  java.lang.String getId();
  /**
   * <code>optional string id = 1;</code>
   *
   * <pre>
   *id of the type of network
   * </pre>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>optional .ddam.InfoType info = 2;</code>
   *
   * <pre>
   *informations about the specific type
   * </pre>
   */
  boolean hasInfo();
  /**
   * <code>optional .ddam.InfoType info = 2;</code>
   *
   * <pre>
   *informations about the specific type
   * </pre>
   */
  us.ihmc.aci.test.ddam.InfoType getInfo();
  /**
   * <code>optional .ddam.InfoType info = 2;</code>
   *
   * <pre>
   *informations about the specific type
   * </pre>
   */
  us.ihmc.aci.test.ddam.InfoTypeOrBuilder getInfoOrBuilder();

  /**
   * <code>optional .ddam.LinkValues values = 3;</code>
   *
   * <pre>
   * values of the link type
   * </pre>
   */
  boolean hasValues();
  /**
   * <code>optional .ddam.LinkValues values = 3;</code>
   *
   * <pre>
   * values of the link type
   * </pre>
   */
  us.ihmc.aci.test.ddam.LinkValues getValues();
  /**
   * <code>optional .ddam.LinkValues values = 3;</code>
   *
   * <pre>
   * values of the link type
   * </pre>
   */
  us.ihmc.aci.test.ddam.LinkValuesOrBuilder getValuesOrBuilder();

  /**
   * <code>optional .ddam.LinkAlgorithmBounds bounds = 4;</code>
   *
   * <pre>
   *bounds used for the election algorithm
   * </pre>
   */
  boolean hasBounds();
  /**
   * <code>optional .ddam.LinkAlgorithmBounds bounds = 4;</code>
   *
   * <pre>
   *bounds used for the election algorithm
   * </pre>
   */
  us.ihmc.aci.test.ddam.LinkAlgorithmBounds getBounds();
  /**
   * <code>optional .ddam.LinkAlgorithmBounds bounds = 4;</code>
   *
   * <pre>
   *bounds used for the election algorithm
   * </pre>
   */
  us.ihmc.aci.test.ddam.LinkAlgorithmBoundsOrBuilder getBoundsOrBuilder();
}
