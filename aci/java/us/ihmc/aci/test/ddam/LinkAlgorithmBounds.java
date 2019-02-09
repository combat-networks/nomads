// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linktype.proto

package us.ihmc.aci.test.ddam;

/**
 * Protobuf type {@code ddam.LinkAlgorithmBounds}
 */
public  final class LinkAlgorithmBounds extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.LinkAlgorithmBounds)
    LinkAlgorithmBoundsOrBuilder {
  // Use LinkAlgorithmBounds.newBuilder() to construct.
  private LinkAlgorithmBounds(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LinkAlgorithmBounds() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private LinkAlgorithmBounds(
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
            us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder subBuilder = null;
            if (linkThroughputBounds_ != null) {
              subBuilder = linkThroughputBounds_.toBuilder();
            }
            linkThroughputBounds_ = input.readMessage(us.ihmc.aci.test.ddam.LinkThroughputBounds.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(linkThroughputBounds_);
              linkThroughputBounds_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder subBuilder = null;
            if (linkLatencyBounds_ != null) {
              subBuilder = linkLatencyBounds_.toBuilder();
            }
            linkLatencyBounds_ = input.readMessage(us.ihmc.aci.test.ddam.LinkLatencyBounds.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(linkLatencyBounds_);
              linkLatencyBounds_ = subBuilder.buildPartial();
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkAlgorithmBounds_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkAlgorithmBounds_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.test.ddam.LinkAlgorithmBounds.class, us.ihmc.aci.test.ddam.LinkAlgorithmBounds.Builder.class);
  }

  public static final int LINKTHROUGHPUTBOUNDS_FIELD_NUMBER = 1;
  private us.ihmc.aci.test.ddam.LinkThroughputBounds linkThroughputBounds_;
  /**
   * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
   *
   * <pre>
   *throughput parameters for the election algorithm
   * </pre>
   */
  public boolean hasLinkThroughputBounds() {
    return linkThroughputBounds_ != null;
  }
  /**
   * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
   *
   * <pre>
   *throughput parameters for the election algorithm
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkThroughputBounds getLinkThroughputBounds() {
    return linkThroughputBounds_ == null ? us.ihmc.aci.test.ddam.LinkThroughputBounds.getDefaultInstance() : linkThroughputBounds_;
  }
  /**
   * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
   *
   * <pre>
   *throughput parameters for the election algorithm
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkThroughputBoundsOrBuilder getLinkThroughputBoundsOrBuilder() {
    return getLinkThroughputBounds();
  }

  public static final int LINKLATENCYBOUNDS_FIELD_NUMBER = 2;
  private us.ihmc.aci.test.ddam.LinkLatencyBounds linkLatencyBounds_;
  /**
   * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
   *
   * <pre>
   *latency parameters for the election algorithm
   * </pre>
   */
  public boolean hasLinkLatencyBounds() {
    return linkLatencyBounds_ != null;
  }
  /**
   * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
   *
   * <pre>
   *latency parameters for the election algorithm
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkLatencyBounds getLinkLatencyBounds() {
    return linkLatencyBounds_ == null ? us.ihmc.aci.test.ddam.LinkLatencyBounds.getDefaultInstance() : linkLatencyBounds_;
  }
  /**
   * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
   *
   * <pre>
   *latency parameters for the election algorithm
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkLatencyBoundsOrBuilder getLinkLatencyBoundsOrBuilder() {
    return getLinkLatencyBounds();
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
    if (linkThroughputBounds_ != null) {
      output.writeMessage(1, getLinkThroughputBounds());
    }
    if (linkLatencyBounds_ != null) {
      output.writeMessage(2, getLinkLatencyBounds());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (linkThroughputBounds_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLinkThroughputBounds());
    }
    if (linkLatencyBounds_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getLinkLatencyBounds());
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
    if (!(obj instanceof us.ihmc.aci.test.ddam.LinkAlgorithmBounds)) {
      return super.equals(obj);
    }
    us.ihmc.aci.test.ddam.LinkAlgorithmBounds other = (us.ihmc.aci.test.ddam.LinkAlgorithmBounds) obj;

    boolean result = true;
    result = result && (hasLinkThroughputBounds() == other.hasLinkThroughputBounds());
    if (hasLinkThroughputBounds()) {
      result = result && getLinkThroughputBounds()
          .equals(other.getLinkThroughputBounds());
    }
    result = result && (hasLinkLatencyBounds() == other.hasLinkLatencyBounds());
    if (hasLinkLatencyBounds()) {
      result = result && getLinkLatencyBounds()
          .equals(other.getLinkLatencyBounds());
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
    if (hasLinkThroughputBounds()) {
      hash = (37 * hash) + LINKTHROUGHPUTBOUNDS_FIELD_NUMBER;
      hash = (53 * hash) + getLinkThroughputBounds().hashCode();
    }
    if (hasLinkLatencyBounds()) {
      hash = (37 * hash) + LINKLATENCYBOUNDS_FIELD_NUMBER;
      hash = (53 * hash) + getLinkLatencyBounds().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.test.ddam.LinkAlgorithmBounds prototype) {
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
   * Protobuf type {@code ddam.LinkAlgorithmBounds}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.LinkAlgorithmBounds)
      us.ihmc.aci.test.ddam.LinkAlgorithmBoundsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkAlgorithmBounds_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkAlgorithmBounds_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.test.ddam.LinkAlgorithmBounds.class, us.ihmc.aci.test.ddam.LinkAlgorithmBounds.Builder.class);
    }

    // Construct using us.ihmc.aci.test.ddam.LinkAlgorithmBounds.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      if (linkThroughputBoundsBuilder_ == null) {
        linkThroughputBounds_ = null;
      } else {
        linkThroughputBounds_ = null;
        linkThroughputBoundsBuilder_ = null;
      }
      if (linkLatencyBoundsBuilder_ == null) {
        linkLatencyBounds_ = null;
      } else {
        linkLatencyBounds_ = null;
        linkLatencyBoundsBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkAlgorithmBounds_descriptor;
    }

    public us.ihmc.aci.test.ddam.LinkAlgorithmBounds getDefaultInstanceForType() {
      return us.ihmc.aci.test.ddam.LinkAlgorithmBounds.getDefaultInstance();
    }

    public us.ihmc.aci.test.ddam.LinkAlgorithmBounds build() {
      us.ihmc.aci.test.ddam.LinkAlgorithmBounds result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.test.ddam.LinkAlgorithmBounds buildPartial() {
      us.ihmc.aci.test.ddam.LinkAlgorithmBounds result = new us.ihmc.aci.test.ddam.LinkAlgorithmBounds(this);
      if (linkThroughputBoundsBuilder_ == null) {
        result.linkThroughputBounds_ = linkThroughputBounds_;
      } else {
        result.linkThroughputBounds_ = linkThroughputBoundsBuilder_.build();
      }
      if (linkLatencyBoundsBuilder_ == null) {
        result.linkLatencyBounds_ = linkLatencyBounds_;
      } else {
        result.linkLatencyBounds_ = linkLatencyBoundsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.test.ddam.LinkAlgorithmBounds) {
        return mergeFrom((us.ihmc.aci.test.ddam.LinkAlgorithmBounds)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.test.ddam.LinkAlgorithmBounds other) {
      if (other == us.ihmc.aci.test.ddam.LinkAlgorithmBounds.getDefaultInstance()) return this;
      if (other.hasLinkThroughputBounds()) {
        mergeLinkThroughputBounds(other.getLinkThroughputBounds());
      }
      if (other.hasLinkLatencyBounds()) {
        mergeLinkLatencyBounds(other.getLinkLatencyBounds());
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
      us.ihmc.aci.test.ddam.LinkAlgorithmBounds parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.test.ddam.LinkAlgorithmBounds) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private us.ihmc.aci.test.ddam.LinkThroughputBounds linkThroughputBounds_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        us.ihmc.aci.test.ddam.LinkThroughputBounds, us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder, us.ihmc.aci.test.ddam.LinkThroughputBoundsOrBuilder> linkThroughputBoundsBuilder_;
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public boolean hasLinkThroughputBounds() {
      return linkThroughputBoundsBuilder_ != null || linkThroughputBounds_ != null;
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkThroughputBounds getLinkThroughputBounds() {
      if (linkThroughputBoundsBuilder_ == null) {
        return linkThroughputBounds_ == null ? us.ihmc.aci.test.ddam.LinkThroughputBounds.getDefaultInstance() : linkThroughputBounds_;
      } else {
        return linkThroughputBoundsBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public Builder setLinkThroughputBounds(us.ihmc.aci.test.ddam.LinkThroughputBounds value) {
      if (linkThroughputBoundsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        linkThroughputBounds_ = value;
        onChanged();
      } else {
        linkThroughputBoundsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public Builder setLinkThroughputBounds(
        us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder builderForValue) {
      if (linkThroughputBoundsBuilder_ == null) {
        linkThroughputBounds_ = builderForValue.build();
        onChanged();
      } else {
        linkThroughputBoundsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public Builder mergeLinkThroughputBounds(us.ihmc.aci.test.ddam.LinkThroughputBounds value) {
      if (linkThroughputBoundsBuilder_ == null) {
        if (linkThroughputBounds_ != null) {
          linkThroughputBounds_ =
            us.ihmc.aci.test.ddam.LinkThroughputBounds.newBuilder(linkThroughputBounds_).mergeFrom(value).buildPartial();
        } else {
          linkThroughputBounds_ = value;
        }
        onChanged();
      } else {
        linkThroughputBoundsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public Builder clearLinkThroughputBounds() {
      if (linkThroughputBoundsBuilder_ == null) {
        linkThroughputBounds_ = null;
        onChanged();
      } else {
        linkThroughputBounds_ = null;
        linkThroughputBoundsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder getLinkThroughputBoundsBuilder() {
      
      onChanged();
      return getLinkThroughputBoundsFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkThroughputBoundsOrBuilder getLinkThroughputBoundsOrBuilder() {
      if (linkThroughputBoundsBuilder_ != null) {
        return linkThroughputBoundsBuilder_.getMessageOrBuilder();
      } else {
        return linkThroughputBounds_ == null ?
            us.ihmc.aci.test.ddam.LinkThroughputBounds.getDefaultInstance() : linkThroughputBounds_;
      }
    }
    /**
     * <code>optional .ddam.LinkThroughputBounds linkThroughputBounds = 1;</code>
     *
     * <pre>
     *throughput parameters for the election algorithm
     * </pre>
     */
    private com.google.protobuf.SingleFieldBuilder<
        us.ihmc.aci.test.ddam.LinkThroughputBounds, us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder, us.ihmc.aci.test.ddam.LinkThroughputBoundsOrBuilder> 
        getLinkThroughputBoundsFieldBuilder() {
      if (linkThroughputBoundsBuilder_ == null) {
        linkThroughputBoundsBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            us.ihmc.aci.test.ddam.LinkThroughputBounds, us.ihmc.aci.test.ddam.LinkThroughputBounds.Builder, us.ihmc.aci.test.ddam.LinkThroughputBoundsOrBuilder>(
                getLinkThroughputBounds(),
                getParentForChildren(),
                isClean());
        linkThroughputBounds_ = null;
      }
      return linkThroughputBoundsBuilder_;
    }

    private us.ihmc.aci.test.ddam.LinkLatencyBounds linkLatencyBounds_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        us.ihmc.aci.test.ddam.LinkLatencyBounds, us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder, us.ihmc.aci.test.ddam.LinkLatencyBoundsOrBuilder> linkLatencyBoundsBuilder_;
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public boolean hasLinkLatencyBounds() {
      return linkLatencyBoundsBuilder_ != null || linkLatencyBounds_ != null;
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkLatencyBounds getLinkLatencyBounds() {
      if (linkLatencyBoundsBuilder_ == null) {
        return linkLatencyBounds_ == null ? us.ihmc.aci.test.ddam.LinkLatencyBounds.getDefaultInstance() : linkLatencyBounds_;
      } else {
        return linkLatencyBoundsBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public Builder setLinkLatencyBounds(us.ihmc.aci.test.ddam.LinkLatencyBounds value) {
      if (linkLatencyBoundsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        linkLatencyBounds_ = value;
        onChanged();
      } else {
        linkLatencyBoundsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public Builder setLinkLatencyBounds(
        us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder builderForValue) {
      if (linkLatencyBoundsBuilder_ == null) {
        linkLatencyBounds_ = builderForValue.build();
        onChanged();
      } else {
        linkLatencyBoundsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public Builder mergeLinkLatencyBounds(us.ihmc.aci.test.ddam.LinkLatencyBounds value) {
      if (linkLatencyBoundsBuilder_ == null) {
        if (linkLatencyBounds_ != null) {
          linkLatencyBounds_ =
            us.ihmc.aci.test.ddam.LinkLatencyBounds.newBuilder(linkLatencyBounds_).mergeFrom(value).buildPartial();
        } else {
          linkLatencyBounds_ = value;
        }
        onChanged();
      } else {
        linkLatencyBoundsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public Builder clearLinkLatencyBounds() {
      if (linkLatencyBoundsBuilder_ == null) {
        linkLatencyBounds_ = null;
        onChanged();
      } else {
        linkLatencyBounds_ = null;
        linkLatencyBoundsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder getLinkLatencyBoundsBuilder() {
      
      onChanged();
      return getLinkLatencyBoundsFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkLatencyBoundsOrBuilder getLinkLatencyBoundsOrBuilder() {
      if (linkLatencyBoundsBuilder_ != null) {
        return linkLatencyBoundsBuilder_.getMessageOrBuilder();
      } else {
        return linkLatencyBounds_ == null ?
            us.ihmc.aci.test.ddam.LinkLatencyBounds.getDefaultInstance() : linkLatencyBounds_;
      }
    }
    /**
     * <code>optional .ddam.LinkLatencyBounds linkLatencyBounds = 2;</code>
     *
     * <pre>
     *latency parameters for the election algorithm
     * </pre>
     */
    private com.google.protobuf.SingleFieldBuilder<
        us.ihmc.aci.test.ddam.LinkLatencyBounds, us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder, us.ihmc.aci.test.ddam.LinkLatencyBoundsOrBuilder> 
        getLinkLatencyBoundsFieldBuilder() {
      if (linkLatencyBoundsBuilder_ == null) {
        linkLatencyBoundsBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            us.ihmc.aci.test.ddam.LinkLatencyBounds, us.ihmc.aci.test.ddam.LinkLatencyBounds.Builder, us.ihmc.aci.test.ddam.LinkLatencyBoundsOrBuilder>(
                getLinkLatencyBounds(),
                getParentForChildren(),
                isClean());
        linkLatencyBounds_ = null;
      }
      return linkLatencyBoundsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ddam.LinkAlgorithmBounds)
  }

  // @@protoc_insertion_point(class_scope:ddam.LinkAlgorithmBounds)
  private static final us.ihmc.aci.test.ddam.LinkAlgorithmBounds DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.test.ddam.LinkAlgorithmBounds();
  }

  public static us.ihmc.aci.test.ddam.LinkAlgorithmBounds getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LinkAlgorithmBounds>
      PARSER = new com.google.protobuf.AbstractParser<LinkAlgorithmBounds>() {
    public LinkAlgorithmBounds parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new LinkAlgorithmBounds(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<LinkAlgorithmBounds> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LinkAlgorithmBounds> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.test.ddam.LinkAlgorithmBounds getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
