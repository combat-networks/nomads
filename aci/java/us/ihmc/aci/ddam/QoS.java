// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: qos.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf type {@code ddam.QoS}
 */
public  final class QoS extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.QoS)
    QoSOrBuilder {
  // Use QoS.newBuilder() to construct.
  private QoS(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private QoS() {
    microflows_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private QoS(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              microflows_ = new java.util.ArrayList<us.ihmc.aci.ddam.MicroFlow>();
              mutable_bitField0_ |= 0x00000001;
            }
            microflows_.add(input.readMessage(us.ihmc.aci.ddam.MicroFlow.parser(), extensionRegistry));
            break;
          }
          case 18: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (timestamp_ != null) {
              subBuilder = timestamp_.toBuilder();
            }
            timestamp_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(timestamp_);
              timestamp_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        microflows_ = java.util.Collections.unmodifiableList(microflows_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return us.ihmc.aci.ddam.QoSProto.internal_static_ddam_QoS_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.ddam.QoSProto.internal_static_ddam_QoS_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.ddam.QoS.class, us.ihmc.aci.ddam.QoS.Builder.class);
  }

  private int bitField0_;
  public static final int MICROFLOWS_FIELD_NUMBER = 1;
  private java.util.List<us.ihmc.aci.ddam.MicroFlow> microflows_;
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  public java.util.List<us.ihmc.aci.ddam.MicroFlow> getMicroflowsList() {
    return microflows_;
  }
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  public java.util.List<? extends us.ihmc.aci.ddam.MicroFlowOrBuilder> 
      getMicroflowsOrBuilderList() {
    return microflows_;
  }
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  public int getMicroflowsCount() {
    return microflows_.size();
  }
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  public us.ihmc.aci.ddam.MicroFlow getMicroflows(int index) {
    return microflows_.get(index);
  }
  /**
   * <code>repeated .ddam.MicroFlow microflows = 1;</code>
   *
   * <pre>
   *list of microflows
   * </pre>
   */
  public us.ihmc.aci.ddam.MicroFlowOrBuilder getMicroflowsOrBuilder(
      int index) {
    return microflows_.get(index);
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  private com.google.protobuf.Timestamp timestamp_;
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  public boolean hasTimestamp() {
    return timestamp_ != null;
  }
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  public com.google.protobuf.Timestamp getTimestamp() {
    return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
  }
  /**
   * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
   *
   * <pre>
   *the time when the object was created (to know when a classification is generated)
   * </pre>
   */
  public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
    return getTimestamp();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < microflows_.size(); i++) {
      output.writeMessage(1, microflows_.get(i));
    }
    if (timestamp_ != null) {
      output.writeMessage(2, getTimestamp());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < microflows_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, microflows_.get(i));
    }
    if (timestamp_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTimestamp());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof us.ihmc.aci.ddam.QoS)) {
      return super.equals(obj);
    }
    us.ihmc.aci.ddam.QoS other = (us.ihmc.aci.ddam.QoS) obj;

    boolean result = true;
    result = result && getMicroflowsList()
        .equals(other.getMicroflowsList());
    result = result && (hasTimestamp() == other.hasTimestamp());
    if (hasTimestamp()) {
      result = result && getTimestamp()
          .equals(other.getTimestamp());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getMicroflowsCount() > 0) {
      hash = (37 * hash) + MICROFLOWS_FIELD_NUMBER;
      hash = (53 * hash) + getMicroflowsList().hashCode();
    }
    if (hasTimestamp()) {
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + getTimestamp().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.ddam.QoS parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.QoS parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.ddam.QoS parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.QoS parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.ddam.QoS prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ddam.QoS}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.QoS)
      us.ihmc.aci.ddam.QoSOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.ddam.QoSProto.internal_static_ddam_QoS_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.ddam.QoSProto.internal_static_ddam_QoS_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.ddam.QoS.class, us.ihmc.aci.ddam.QoS.Builder.class);
    }

    // Construct using us.ihmc.aci.ddam.QoS.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getMicroflowsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (microflowsBuilder_ == null) {
        microflows_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        microflowsBuilder_.clear();
      }
      if (timestampBuilder_ == null) {
        timestamp_ = null;
      } else {
        timestamp_ = null;
        timestampBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.ddam.QoSProto.internal_static_ddam_QoS_descriptor;
    }

    public us.ihmc.aci.ddam.QoS getDefaultInstanceForType() {
      return us.ihmc.aci.ddam.QoS.getDefaultInstance();
    }

    public us.ihmc.aci.ddam.QoS build() {
      us.ihmc.aci.ddam.QoS result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.ddam.QoS buildPartial() {
      us.ihmc.aci.ddam.QoS result = new us.ihmc.aci.ddam.QoS(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (microflowsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          microflows_ = java.util.Collections.unmodifiableList(microflows_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.microflows_ = microflows_;
      } else {
        result.microflows_ = microflowsBuilder_.build();
      }
      if (timestampBuilder_ == null) {
        result.timestamp_ = timestamp_;
      } else {
        result.timestamp_ = timestampBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.ddam.QoS) {
        return mergeFrom((us.ihmc.aci.ddam.QoS)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.ddam.QoS other) {
      if (other == us.ihmc.aci.ddam.QoS.getDefaultInstance()) return this;
      if (microflowsBuilder_ == null) {
        if (!other.microflows_.isEmpty()) {
          if (microflows_.isEmpty()) {
            microflows_ = other.microflows_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMicroflowsIsMutable();
            microflows_.addAll(other.microflows_);
          }
          onChanged();
        }
      } else {
        if (!other.microflows_.isEmpty()) {
          if (microflowsBuilder_.isEmpty()) {
            microflowsBuilder_.dispose();
            microflowsBuilder_ = null;
            microflows_ = other.microflows_;
            bitField0_ = (bitField0_ & ~0x00000001);
            microflowsBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getMicroflowsFieldBuilder() : null;
          } else {
            microflowsBuilder_.addAllMessages(other.microflows_);
          }
        }
      }
      if (other.hasTimestamp()) {
        mergeTimestamp(other.getTimestamp());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      us.ihmc.aci.ddam.QoS parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.ddam.QoS) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<us.ihmc.aci.ddam.MicroFlow> microflows_ =
      java.util.Collections.emptyList();
    private void ensureMicroflowsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        microflows_ = new java.util.ArrayList<us.ihmc.aci.ddam.MicroFlow>(microflows_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        us.ihmc.aci.ddam.MicroFlow, us.ihmc.aci.ddam.MicroFlow.Builder, us.ihmc.aci.ddam.MicroFlowOrBuilder> microflowsBuilder_;

    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public java.util.List<us.ihmc.aci.ddam.MicroFlow> getMicroflowsList() {
      if (microflowsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(microflows_);
      } else {
        return microflowsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public int getMicroflowsCount() {
      if (microflowsBuilder_ == null) {
        return microflows_.size();
      } else {
        return microflowsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public us.ihmc.aci.ddam.MicroFlow getMicroflows(int index) {
      if (microflowsBuilder_ == null) {
        return microflows_.get(index);
      } else {
        return microflowsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder setMicroflows(
        int index, us.ihmc.aci.ddam.MicroFlow value) {
      if (microflowsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMicroflowsIsMutable();
        microflows_.set(index, value);
        onChanged();
      } else {
        microflowsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder setMicroflows(
        int index, us.ihmc.aci.ddam.MicroFlow.Builder builderForValue) {
      if (microflowsBuilder_ == null) {
        ensureMicroflowsIsMutable();
        microflows_.set(index, builderForValue.build());
        onChanged();
      } else {
        microflowsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder addMicroflows(us.ihmc.aci.ddam.MicroFlow value) {
      if (microflowsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMicroflowsIsMutable();
        microflows_.add(value);
        onChanged();
      } else {
        microflowsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder addMicroflows(
        int index, us.ihmc.aci.ddam.MicroFlow value) {
      if (microflowsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMicroflowsIsMutable();
        microflows_.add(index, value);
        onChanged();
      } else {
        microflowsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder addMicroflows(
        us.ihmc.aci.ddam.MicroFlow.Builder builderForValue) {
      if (microflowsBuilder_ == null) {
        ensureMicroflowsIsMutable();
        microflows_.add(builderForValue.build());
        onChanged();
      } else {
        microflowsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder addMicroflows(
        int index, us.ihmc.aci.ddam.MicroFlow.Builder builderForValue) {
      if (microflowsBuilder_ == null) {
        ensureMicroflowsIsMutable();
        microflows_.add(index, builderForValue.build());
        onChanged();
      } else {
        microflowsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder addAllMicroflows(
        java.lang.Iterable<? extends us.ihmc.aci.ddam.MicroFlow> values) {
      if (microflowsBuilder_ == null) {
        ensureMicroflowsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, microflows_);
        onChanged();
      } else {
        microflowsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder clearMicroflows() {
      if (microflowsBuilder_ == null) {
        microflows_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        microflowsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public Builder removeMicroflows(int index) {
      if (microflowsBuilder_ == null) {
        ensureMicroflowsIsMutable();
        microflows_.remove(index);
        onChanged();
      } else {
        microflowsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public us.ihmc.aci.ddam.MicroFlow.Builder getMicroflowsBuilder(
        int index) {
      return getMicroflowsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public us.ihmc.aci.ddam.MicroFlowOrBuilder getMicroflowsOrBuilder(
        int index) {
      if (microflowsBuilder_ == null) {
        return microflows_.get(index);  } else {
        return microflowsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public java.util.List<? extends us.ihmc.aci.ddam.MicroFlowOrBuilder> 
         getMicroflowsOrBuilderList() {
      if (microflowsBuilder_ != null) {
        return microflowsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(microflows_);
      }
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public us.ihmc.aci.ddam.MicroFlow.Builder addMicroflowsBuilder() {
      return getMicroflowsFieldBuilder().addBuilder(
          us.ihmc.aci.ddam.MicroFlow.getDefaultInstance());
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public us.ihmc.aci.ddam.MicroFlow.Builder addMicroflowsBuilder(
        int index) {
      return getMicroflowsFieldBuilder().addBuilder(
          index, us.ihmc.aci.ddam.MicroFlow.getDefaultInstance());
    }
    /**
     * <code>repeated .ddam.MicroFlow microflows = 1;</code>
     *
     * <pre>
     *list of microflows
     * </pre>
     */
    public java.util.List<us.ihmc.aci.ddam.MicroFlow.Builder> 
         getMicroflowsBuilderList() {
      return getMicroflowsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        us.ihmc.aci.ddam.MicroFlow, us.ihmc.aci.ddam.MicroFlow.Builder, us.ihmc.aci.ddam.MicroFlowOrBuilder> 
        getMicroflowsFieldBuilder() {
      if (microflowsBuilder_ == null) {
        microflowsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            us.ihmc.aci.ddam.MicroFlow, us.ihmc.aci.ddam.MicroFlow.Builder, us.ihmc.aci.ddam.MicroFlowOrBuilder>(
                microflows_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        microflows_ = null;
      }
      return microflowsBuilder_;
    }

    private com.google.protobuf.Timestamp timestamp_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> timestampBuilder_;
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public boolean hasTimestamp() {
      return timestampBuilder_ != null || timestamp_ != null;
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public com.google.protobuf.Timestamp getTimestamp() {
      if (timestampBuilder_ == null) {
        return timestamp_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      } else {
        return timestampBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public Builder setTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        timestamp_ = value;
        onChanged();
      } else {
        timestampBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public Builder setTimestamp(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (timestampBuilder_ == null) {
        timestamp_ = builderForValue.build();
        onChanged();
      } else {
        timestampBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public Builder mergeTimestamp(com.google.protobuf.Timestamp value) {
      if (timestampBuilder_ == null) {
        if (timestamp_ != null) {
          timestamp_ =
            com.google.protobuf.Timestamp.newBuilder(timestamp_).mergeFrom(value).buildPartial();
        } else {
          timestamp_ = value;
        }
        onChanged();
      } else {
        timestampBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public Builder clearTimestamp() {
      if (timestampBuilder_ == null) {
        timestamp_ = null;
        onChanged();
      } else {
        timestamp_ = null;
        timestampBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public com.google.protobuf.Timestamp.Builder getTimestampBuilder() {
      
      onChanged();
      return getTimestampFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    public com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder() {
      if (timestampBuilder_ != null) {
        return timestampBuilder_.getMessageOrBuilder();
      } else {
        return timestamp_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : timestamp_;
      }
    }
    /**
     * <code>optional .google.protobuf.Timestamp timestamp = 2;</code>
     *
     * <pre>
     *the time when the object was created (to know when a classification is generated)
     * </pre>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getTimestampFieldBuilder() {
      if (timestampBuilder_ == null) {
        timestampBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getTimestamp(),
                getParentForChildren(),
                isClean());
        timestamp_ = null;
      }
      return timestampBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ddam.QoS)
  }

  // @@protoc_insertion_point(class_scope:ddam.QoS)
  private static final us.ihmc.aci.ddam.QoS DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.ddam.QoS();
  }

  public static us.ihmc.aci.ddam.QoS getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<QoS>
      PARSER = new com.google.protobuf.AbstractParser<QoS>() {
    public QoS parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new QoS(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<QoS> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<QoS> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.ddam.QoS getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

