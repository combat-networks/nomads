// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: traffic.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf type {@code ddam.Traffic}
 *
 * <pre>
 *contains source IP addresses
 * </pre>
 */
public  final class Traffic extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.Traffic)
    TrafficOrBuilder {
  // Use Traffic.newBuilder() to construct.
  private Traffic(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Traffic() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Traffic(
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
              sources_ = com.google.protobuf.MapField.newMapField(
                  SourcesDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, us.ihmc.aci.ddam.Source>
            sources = input.readMessage(
                SourcesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            sources_.getMutableMap().put(sources.getKey(), sources.getValue());
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
    return us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetSources();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.ddam.Traffic.class, us.ihmc.aci.ddam.Traffic.Builder.class);
  }

  public static final int SOURCES_FIELD_NUMBER = 1;
  private static final class SourcesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, us.ihmc.aci.ddam.Source> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, us.ihmc.aci.ddam.Source>newDefaultInstance(
                us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_SourcesEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.UINT32,
                0,
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                us.ihmc.aci.ddam.Source.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, us.ihmc.aci.ddam.Source> sources_;
  private com.google.protobuf.MapField<java.lang.Integer, us.ihmc.aci.ddam.Source>
  internalGetSources() {
    if (sources_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          SourcesDefaultEntryHolder.defaultEntry);
   }
    return sources_;
  }
  /**
   * <code>map&lt;uint32, .ddam.Source&gt; sources = 1;</code>
   *
   * <pre>
   *the sources of traffic, the key is the source ip, value is the object source
   * </pre>
   */

  public java.util.Map<java.lang.Integer, us.ihmc.aci.ddam.Source> getSources() {
    return internalGetSources().getMap();
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
    for (java.util.Map.Entry<java.lang.Integer, us.ihmc.aci.ddam.Source> entry
         : internalGetSources().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, us.ihmc.aci.ddam.Source>
      sources = SourcesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(1, sources);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.Integer, us.ihmc.aci.ddam.Source> entry
         : internalGetSources().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, us.ihmc.aci.ddam.Source>
      sources = SourcesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, sources);
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
    if (!(obj instanceof us.ihmc.aci.ddam.Traffic)) {
      return super.equals(obj);
    }
    us.ihmc.aci.ddam.Traffic other = (us.ihmc.aci.ddam.Traffic) obj;

    boolean result = true;
    result = result && internalGetSources().equals(
        other.internalGetSources());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (!internalGetSources().getMap().isEmpty()) {
      hash = (37 * hash) + SOURCES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetSources().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.ddam.Traffic parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Traffic parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.ddam.Traffic parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.Traffic parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.ddam.Traffic prototype) {
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
   * Protobuf type {@code ddam.Traffic}
   *
   * <pre>
   *contains source IP addresses
   * </pre>
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.Traffic)
      us.ihmc.aci.ddam.TrafficOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetSources();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableSources();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.ddam.Traffic.class, us.ihmc.aci.ddam.Traffic.Builder.class);
    }

    // Construct using us.ihmc.aci.ddam.Traffic.newBuilder()
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
      internalGetMutableSources().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.ddam.TrafficProto.internal_static_ddam_Traffic_descriptor;
    }

    public us.ihmc.aci.ddam.Traffic getDefaultInstanceForType() {
      return us.ihmc.aci.ddam.Traffic.getDefaultInstance();
    }

    public us.ihmc.aci.ddam.Traffic build() {
      us.ihmc.aci.ddam.Traffic result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.ddam.Traffic buildPartial() {
      us.ihmc.aci.ddam.Traffic result = new us.ihmc.aci.ddam.Traffic(this);
      int from_bitField0_ = bitField0_;
      result.sources_ = internalGetSources();
      result.sources_.makeImmutable();
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.ddam.Traffic) {
        return mergeFrom((us.ihmc.aci.ddam.Traffic)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.ddam.Traffic other) {
      if (other == us.ihmc.aci.ddam.Traffic.getDefaultInstance()) return this;
      internalGetMutableSources().mergeFrom(
          other.internalGetSources());
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
      us.ihmc.aci.ddam.Traffic parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.ddam.Traffic) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.Integer, us.ihmc.aci.ddam.Source> sources_;
    private com.google.protobuf.MapField<java.lang.Integer, us.ihmc.aci.ddam.Source>
    internalGetSources() {
      if (sources_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            SourcesDefaultEntryHolder.defaultEntry);
     }
      return sources_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, us.ihmc.aci.ddam.Source>
    internalGetMutableSources() {
      onChanged();;
      if (sources_ == null) {
        sources_ = com.google.protobuf.MapField.newMapField(
            SourcesDefaultEntryHolder.defaultEntry);
      }
      if (!sources_.isMutable()) {
        sources_ = sources_.copy();
      }
      return sources_;
    }
    /**
     * <code>map&lt;uint32, .ddam.Source&gt; sources = 1;</code>
     *
     * <pre>
     *the sources of traffic, the key is the source ip, value is the object source
     * </pre>
     */
    public java.util.Map<java.lang.Integer, us.ihmc.aci.ddam.Source> getSources() {
      return internalGetSources().getMap();
    }
    /**
     * <code>map&lt;uint32, .ddam.Source&gt; sources = 1;</code>
     *
     * <pre>
     *the sources of traffic, the key is the source ip, value is the object source
     * </pre>
     */
    public java.util.Map<java.lang.Integer, us.ihmc.aci.ddam.Source>
    getMutableSources() {
      return internalGetMutableSources().getMutableMap();
    }
    /**
     * <code>map&lt;uint32, .ddam.Source&gt; sources = 1;</code>
     *
     * <pre>
     *the sources of traffic, the key is the source ip, value is the object source
     * </pre>
     */
    public Builder putAllSources(
        java.util.Map<java.lang.Integer, us.ihmc.aci.ddam.Source> values) {
      getMutableSources().putAll(values);
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


    // @@protoc_insertion_point(builder_scope:ddam.Traffic)
  }

  // @@protoc_insertion_point(class_scope:ddam.Traffic)
  private static final us.ihmc.aci.ddam.Traffic DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.ddam.Traffic();
  }

  public static us.ihmc.aci.ddam.Traffic getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Traffic>
      PARSER = new com.google.protobuf.AbstractParser<Traffic>() {
    public Traffic parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new Traffic(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<Traffic> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Traffic> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.ddam.Traffic getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

