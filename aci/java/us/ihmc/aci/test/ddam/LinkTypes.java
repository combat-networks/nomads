// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: linktype.proto

package us.ihmc.aci.test.ddam;

/**
 * Protobuf type {@code ddam.LinkTypes}
 */
public  final class LinkTypes extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.LinkTypes)
    LinkTypesOrBuilder {
  // Use LinkTypes.newBuilder() to construct.
  private LinkTypes(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LinkTypes() {
    linkType_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private LinkTypes(
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
              linkType_ = new java.util.ArrayList<us.ihmc.aci.test.ddam.LinkType>();
              mutable_bitField0_ |= 0x00000001;
            }
            linkType_.add(input.readMessage(us.ihmc.aci.test.ddam.LinkType.parser(), extensionRegistry));
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
        linkType_ = java.util.Collections.unmodifiableList(linkType_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkTypes_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkTypes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.test.ddam.LinkTypes.class, us.ihmc.aci.test.ddam.LinkTypes.Builder.class);
  }

  public static final int LINKTYPE_FIELD_NUMBER = 1;
  private java.util.List<us.ihmc.aci.test.ddam.LinkType> linkType_;
  /**
   * <code>repeated .ddam.LinkType linkType = 1;</code>
   *
   * <pre>
   *list of link types given to create the environment
   * </pre>
   */
  public java.util.List<us.ihmc.aci.test.ddam.LinkType> getLinkTypeList() {
    return linkType_;
  }
  /**
   * <code>repeated .ddam.LinkType linkType = 1;</code>
   *
   * <pre>
   *list of link types given to create the environment
   * </pre>
   */
  public java.util.List<? extends us.ihmc.aci.test.ddam.LinkTypeOrBuilder> 
      getLinkTypeOrBuilderList() {
    return linkType_;
  }
  /**
   * <code>repeated .ddam.LinkType linkType = 1;</code>
   *
   * <pre>
   *list of link types given to create the environment
   * </pre>
   */
  public int getLinkTypeCount() {
    return linkType_.size();
  }
  /**
   * <code>repeated .ddam.LinkType linkType = 1;</code>
   *
   * <pre>
   *list of link types given to create the environment
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkType getLinkType(int index) {
    return linkType_.get(index);
  }
  /**
   * <code>repeated .ddam.LinkType linkType = 1;</code>
   *
   * <pre>
   *list of link types given to create the environment
   * </pre>
   */
  public us.ihmc.aci.test.ddam.LinkTypeOrBuilder getLinkTypeOrBuilder(
      int index) {
    return linkType_.get(index);
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
    for (int i = 0; i < linkType_.size(); i++) {
      output.writeMessage(1, linkType_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < linkType_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, linkType_.get(i));
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
    if (!(obj instanceof us.ihmc.aci.test.ddam.LinkTypes)) {
      return super.equals(obj);
    }
    us.ihmc.aci.test.ddam.LinkTypes other = (us.ihmc.aci.test.ddam.LinkTypes) obj;

    boolean result = true;
    result = result && getLinkTypeList()
        .equals(other.getLinkTypeList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (getLinkTypeCount() > 0) {
      hash = (37 * hash) + LINKTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getLinkTypeList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.test.ddam.LinkTypes parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.test.ddam.LinkTypes prototype) {
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
   * Protobuf type {@code ddam.LinkTypes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.LinkTypes)
      us.ihmc.aci.test.ddam.LinkTypesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkTypes_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkTypes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.test.ddam.LinkTypes.class, us.ihmc.aci.test.ddam.LinkTypes.Builder.class);
    }

    // Construct using us.ihmc.aci.test.ddam.LinkTypes.newBuilder()
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
        getLinkTypeFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (linkTypeBuilder_ == null) {
        linkType_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        linkTypeBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.test.ddam.LinkTypeProto.internal_static_ddam_LinkTypes_descriptor;
    }

    public us.ihmc.aci.test.ddam.LinkTypes getDefaultInstanceForType() {
      return us.ihmc.aci.test.ddam.LinkTypes.getDefaultInstance();
    }

    public us.ihmc.aci.test.ddam.LinkTypes build() {
      us.ihmc.aci.test.ddam.LinkTypes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.test.ddam.LinkTypes buildPartial() {
      us.ihmc.aci.test.ddam.LinkTypes result = new us.ihmc.aci.test.ddam.LinkTypes(this);
      int from_bitField0_ = bitField0_;
      if (linkTypeBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          linkType_ = java.util.Collections.unmodifiableList(linkType_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.linkType_ = linkType_;
      } else {
        result.linkType_ = linkTypeBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.test.ddam.LinkTypes) {
        return mergeFrom((us.ihmc.aci.test.ddam.LinkTypes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.test.ddam.LinkTypes other) {
      if (other == us.ihmc.aci.test.ddam.LinkTypes.getDefaultInstance()) return this;
      if (linkTypeBuilder_ == null) {
        if (!other.linkType_.isEmpty()) {
          if (linkType_.isEmpty()) {
            linkType_ = other.linkType_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLinkTypeIsMutable();
            linkType_.addAll(other.linkType_);
          }
          onChanged();
        }
      } else {
        if (!other.linkType_.isEmpty()) {
          if (linkTypeBuilder_.isEmpty()) {
            linkTypeBuilder_.dispose();
            linkTypeBuilder_ = null;
            linkType_ = other.linkType_;
            bitField0_ = (bitField0_ & ~0x00000001);
            linkTypeBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getLinkTypeFieldBuilder() : null;
          } else {
            linkTypeBuilder_.addAllMessages(other.linkType_);
          }
        }
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
      us.ihmc.aci.test.ddam.LinkTypes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.test.ddam.LinkTypes) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<us.ihmc.aci.test.ddam.LinkType> linkType_ =
      java.util.Collections.emptyList();
    private void ensureLinkTypeIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        linkType_ = new java.util.ArrayList<us.ihmc.aci.test.ddam.LinkType>(linkType_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        us.ihmc.aci.test.ddam.LinkType, us.ihmc.aci.test.ddam.LinkType.Builder, us.ihmc.aci.test.ddam.LinkTypeOrBuilder> linkTypeBuilder_;

    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public java.util.List<us.ihmc.aci.test.ddam.LinkType> getLinkTypeList() {
      if (linkTypeBuilder_ == null) {
        return java.util.Collections.unmodifiableList(linkType_);
      } else {
        return linkTypeBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public int getLinkTypeCount() {
      if (linkTypeBuilder_ == null) {
        return linkType_.size();
      } else {
        return linkTypeBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkType getLinkType(int index) {
      if (linkTypeBuilder_ == null) {
        return linkType_.get(index);
      } else {
        return linkTypeBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder setLinkType(
        int index, us.ihmc.aci.test.ddam.LinkType value) {
      if (linkTypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinkTypeIsMutable();
        linkType_.set(index, value);
        onChanged();
      } else {
        linkTypeBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder setLinkType(
        int index, us.ihmc.aci.test.ddam.LinkType.Builder builderForValue) {
      if (linkTypeBuilder_ == null) {
        ensureLinkTypeIsMutable();
        linkType_.set(index, builderForValue.build());
        onChanged();
      } else {
        linkTypeBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder addLinkType(us.ihmc.aci.test.ddam.LinkType value) {
      if (linkTypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinkTypeIsMutable();
        linkType_.add(value);
        onChanged();
      } else {
        linkTypeBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder addLinkType(
        int index, us.ihmc.aci.test.ddam.LinkType value) {
      if (linkTypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinkTypeIsMutable();
        linkType_.add(index, value);
        onChanged();
      } else {
        linkTypeBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder addLinkType(
        us.ihmc.aci.test.ddam.LinkType.Builder builderForValue) {
      if (linkTypeBuilder_ == null) {
        ensureLinkTypeIsMutable();
        linkType_.add(builderForValue.build());
        onChanged();
      } else {
        linkTypeBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder addLinkType(
        int index, us.ihmc.aci.test.ddam.LinkType.Builder builderForValue) {
      if (linkTypeBuilder_ == null) {
        ensureLinkTypeIsMutable();
        linkType_.add(index, builderForValue.build());
        onChanged();
      } else {
        linkTypeBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder addAllLinkType(
        java.lang.Iterable<? extends us.ihmc.aci.test.ddam.LinkType> values) {
      if (linkTypeBuilder_ == null) {
        ensureLinkTypeIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, linkType_);
        onChanged();
      } else {
        linkTypeBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder clearLinkType() {
      if (linkTypeBuilder_ == null) {
        linkType_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        linkTypeBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public Builder removeLinkType(int index) {
      if (linkTypeBuilder_ == null) {
        ensureLinkTypeIsMutable();
        linkType_.remove(index);
        onChanged();
      } else {
        linkTypeBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkType.Builder getLinkTypeBuilder(
        int index) {
      return getLinkTypeFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkTypeOrBuilder getLinkTypeOrBuilder(
        int index) {
      if (linkTypeBuilder_ == null) {
        return linkType_.get(index);  } else {
        return linkTypeBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public java.util.List<? extends us.ihmc.aci.test.ddam.LinkTypeOrBuilder> 
         getLinkTypeOrBuilderList() {
      if (linkTypeBuilder_ != null) {
        return linkTypeBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(linkType_);
      }
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkType.Builder addLinkTypeBuilder() {
      return getLinkTypeFieldBuilder().addBuilder(
          us.ihmc.aci.test.ddam.LinkType.getDefaultInstance());
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public us.ihmc.aci.test.ddam.LinkType.Builder addLinkTypeBuilder(
        int index) {
      return getLinkTypeFieldBuilder().addBuilder(
          index, us.ihmc.aci.test.ddam.LinkType.getDefaultInstance());
    }
    /**
     * <code>repeated .ddam.LinkType linkType = 1;</code>
     *
     * <pre>
     *list of link types given to create the environment
     * </pre>
     */
    public java.util.List<us.ihmc.aci.test.ddam.LinkType.Builder> 
         getLinkTypeBuilderList() {
      return getLinkTypeFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        us.ihmc.aci.test.ddam.LinkType, us.ihmc.aci.test.ddam.LinkType.Builder, us.ihmc.aci.test.ddam.LinkTypeOrBuilder> 
        getLinkTypeFieldBuilder() {
      if (linkTypeBuilder_ == null) {
        linkTypeBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            us.ihmc.aci.test.ddam.LinkType, us.ihmc.aci.test.ddam.LinkType.Builder, us.ihmc.aci.test.ddam.LinkTypeOrBuilder>(
                linkType_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        linkType_ = null;
      }
      return linkTypeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ddam.LinkTypes)
  }

  // @@protoc_insertion_point(class_scope:ddam.LinkTypes)
  private static final us.ihmc.aci.test.ddam.LinkTypes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.test.ddam.LinkTypes();
  }

  public static us.ihmc.aci.test.ddam.LinkTypes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LinkTypes>
      PARSER = new com.google.protobuf.AbstractParser<LinkTypes>() {
    public LinkTypes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new LinkTypes(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<LinkTypes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LinkTypes> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.test.ddam.LinkTypes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
