// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grump.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf type {@code ddam.Group}
 *
 * <pre>
 *information about the groups their members
 * </pre>
 */
public  final class Group extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.Group)
    GroupOrBuilder {
  // Use Group.newBuilder() to construct.
  private Group(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Group() {
    name_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Group(
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
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              members_ = com.google.protobuf.MapField.newMapField(
                  MembersDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000002;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            members = input.readMessage(
                MembersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            members_.getMutableMap().put(members.getKey(), members.getValue());
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
    return us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetMembers();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.ddam.Group.class, us.ihmc.aci.ddam.Group.Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>optional string name = 1;</code>
   *
   * <pre>
   *the name of the group
   * </pre>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>optional string name = 1;</code>
   *
   * <pre>
   *the name of the group
   * </pre>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MEMBERS_FIELD_NUMBER = 2;
  private static final class MembersDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_MembersEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> members_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetMembers() {
    if (members_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          MembersDefaultEntryHolder.defaultEntry);
   }
    return members_;
  }
  /**
   * <code>map&lt;string, string&gt; members = 2;</code>
   *
   * <pre>
   *the members of the group, key is node id, value is IP address (when present)
   * </pre>
   */

  public java.util.Map<java.lang.String, java.lang.String> getMembers() {
    return internalGetMembers().getMap();
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
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, name_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetMembers().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      members = MembersDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(2, members);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, name_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetMembers().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      members = MembersDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, members);
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
    if (!(obj instanceof us.ihmc.aci.ddam.Group)) {
      return super.equals(obj);
    }
    us.ihmc.aci.ddam.Group other = (us.ihmc.aci.ddam.Group) obj;

    boolean result = true;
    result = result && getName()
        .equals(other.getName());
    result = result && internalGetMembers().equals(
        other.internalGetMembers());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    if (!internalGetMembers().getMap().isEmpty()) {
      hash = (37 * hash) + MEMBERS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetMembers().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.ddam.Group parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Group parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.ddam.Group parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.Group parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.ddam.Group prototype) {
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
   * Protobuf type {@code ddam.Group}
   *
   * <pre>
   *information about the groups their members
   * </pre>
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.Group)
      us.ihmc.aci.ddam.GroupOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMembers();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableMembers();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.ddam.Group.class, us.ihmc.aci.ddam.Group.Builder.class);
    }

    // Construct using us.ihmc.aci.ddam.Group.newBuilder()
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
      name_ = "";

      internalGetMutableMembers().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.ddam.GrumpProto.internal_static_ddam_Group_descriptor;
    }

    public us.ihmc.aci.ddam.Group getDefaultInstanceForType() {
      return us.ihmc.aci.ddam.Group.getDefaultInstance();
    }

    public us.ihmc.aci.ddam.Group build() {
      us.ihmc.aci.ddam.Group result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.ddam.Group buildPartial() {
      us.ihmc.aci.ddam.Group result = new us.ihmc.aci.ddam.Group(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.name_ = name_;
      result.members_ = internalGetMembers();
      result.members_.makeImmutable();
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.ddam.Group) {
        return mergeFrom((us.ihmc.aci.ddam.Group)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.ddam.Group other) {
      if (other == us.ihmc.aci.ddam.Group.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      internalGetMutableMembers().mergeFrom(
          other.internalGetMembers());
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
      us.ihmc.aci.ddam.Group parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.ddam.Group) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 1;</code>
     *
     * <pre>
     *the name of the group
     * </pre>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     *
     * <pre>
     *the name of the group
     * </pre>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     *
     * <pre>
     *the name of the group
     * </pre>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     *
     * <pre>
     *the name of the group
     * </pre>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     *
     * <pre>
     *the name of the group
     * </pre>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> members_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMembers() {
      if (members_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            MembersDefaultEntryHolder.defaultEntry);
     }
      return members_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableMembers() {
      onChanged();;
      if (members_ == null) {
        members_ = com.google.protobuf.MapField.newMapField(
            MembersDefaultEntryHolder.defaultEntry);
      }
      if (!members_.isMutable()) {
        members_ = members_.copy();
      }
      return members_;
    }
    /**
     * <code>map&lt;string, string&gt; members = 2;</code>
     *
     * <pre>
     *the members of the group, key is node id, value is IP address (when present)
     * </pre>
     */
    public java.util.Map<java.lang.String, java.lang.String> getMembers() {
      return internalGetMembers().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; members = 2;</code>
     *
     * <pre>
     *the members of the group, key is node id, value is IP address (when present)
     * </pre>
     */
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableMembers() {
      return internalGetMutableMembers().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; members = 2;</code>
     *
     * <pre>
     *the members of the group, key is node id, value is IP address (when present)
     * </pre>
     */
    public Builder putAllMembers(
        java.util.Map<java.lang.String, java.lang.String> values) {
      getMutableMembers().putAll(values);
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:ddam.Group)
  }

  // @@protoc_insertion_point(class_scope:ddam.Group)
  private static final us.ihmc.aci.ddam.Group DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.ddam.Group();
  }

  public static us.ihmc.aci.ddam.Group getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Group>
      PARSER = new com.google.protobuf.AbstractParser<Group>() {
    public Group parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new Group(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<Group> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Group> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.ddam.Group getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

