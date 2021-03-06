// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: info.proto

package us.ihmc.aci.ddam;

/**
 * Protobuf type {@code ddam.OperatingSystem}
 */
public  final class OperatingSystem extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:ddam.OperatingSystem)
    OperatingSystemOrBuilder {
  // Use OperatingSystem.newBuilder() to construct.
  private OperatingSystem(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private OperatingSystem() {
    description_ = "";
    name_ = "";
    arch_ = "";
    machine_ = "";
    version_ = "";
    vendor_ = "";
    vendorVersion_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private OperatingSystem(
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

            description_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            arch_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            machine_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            version_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            vendor_ = s;
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            vendorVersion_ = s;
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
    return us.ihmc.aci.ddam.InfoProto.internal_static_ddam_OperatingSystem_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return us.ihmc.aci.ddam.InfoProto.internal_static_ddam_OperatingSystem_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            us.ihmc.aci.ddam.OperatingSystem.class, us.ihmc.aci.ddam.OperatingSystem.Builder.class);
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 1;
  private volatile java.lang.Object description_;
  /**
   * <code>optional string description = 1;</code>
   *
   * <pre>
   *the description about this operating system
   * </pre>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>optional string description = 1;</code>
   *
   * <pre>
   *the description about this operating system
   * </pre>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>optional string name = 2;</code>
   *
   * <pre>
   *the name of this operating system
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
   * <code>optional string name = 2;</code>
   *
   * <pre>
   *the name of this operating system
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

  public static final int ARCH_FIELD_NUMBER = 3;
  private volatile java.lang.Object arch_;
  /**
   * <code>optional string arch = 3;</code>
   *
   * <pre>
   *the system architecture
   * </pre>
   */
  public java.lang.String getArch() {
    java.lang.Object ref = arch_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      arch_ = s;
      return s;
    }
  }
  /**
   * <code>optional string arch = 3;</code>
   *
   * <pre>
   *the system architecture
   * </pre>
   */
  public com.google.protobuf.ByteString
      getArchBytes() {
    java.lang.Object ref = arch_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      arch_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MACHINE_FIELD_NUMBER = 4;
  private volatile java.lang.Object machine_;
  /**
   * <code>optional string machine = 4;</code>
   *
   * <pre>
   *the machine version of this operating system
   * </pre>
   */
  public java.lang.String getMachine() {
    java.lang.Object ref = machine_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      machine_ = s;
      return s;
    }
  }
  /**
   * <code>optional string machine = 4;</code>
   *
   * <pre>
   *the machine version of this operating system
   * </pre>
   */
  public com.google.protobuf.ByteString
      getMachineBytes() {
    java.lang.Object ref = machine_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      machine_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VERSION_FIELD_NUMBER = 5;
  private volatile java.lang.Object version_;
  /**
   * <code>optional string version = 5;</code>
   *
   * <pre>
   *the version of this operating system
   * </pre>
   */
  public java.lang.String getVersion() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      version_ = s;
      return s;
    }
  }
  /**
   * <code>optional string version = 5;</code>
   *
   * <pre>
   *the version of this operating system
   * </pre>
   */
  public com.google.protobuf.ByteString
      getVersionBytes() {
    java.lang.Object ref = version_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      version_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VENDOR_FIELD_NUMBER = 6;
  private volatile java.lang.Object vendor_;
  /**
   * <code>optional string vendor = 6;</code>
   *
   * <pre>
   *the vendor of this operating system
   * </pre>
   */
  public java.lang.String getVendor() {
    java.lang.Object ref = vendor_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      vendor_ = s;
      return s;
    }
  }
  /**
   * <code>optional string vendor = 6;</code>
   *
   * <pre>
   *the vendor of this operating system
   * </pre>
   */
  public com.google.protobuf.ByteString
      getVendorBytes() {
    java.lang.Object ref = vendor_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      vendor_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VENDORVERSION_FIELD_NUMBER = 7;
  private volatile java.lang.Object vendorVersion_;
  /**
   * <code>optional string vendorVersion = 7;</code>
   *
   * <pre>
   *the vendor-specific version of this operating system
   * </pre>
   */
  public java.lang.String getVendorVersion() {
    java.lang.Object ref = vendorVersion_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      vendorVersion_ = s;
      return s;
    }
  }
  /**
   * <code>optional string vendorVersion = 7;</code>
   *
   * <pre>
   *the vendor-specific version of this operating system
   * </pre>
   */
  public com.google.protobuf.ByteString
      getVendorVersionBytes() {
    java.lang.Object ref = vendorVersion_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      vendorVersion_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, description_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, name_);
    }
    if (!getArchBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, arch_);
    }
    if (!getMachineBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 4, machine_);
    }
    if (!getVersionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 5, version_);
    }
    if (!getVendorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 6, vendor_);
    }
    if (!getVendorVersionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 7, vendorVersion_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, description_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, name_);
    }
    if (!getArchBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, arch_);
    }
    if (!getMachineBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(4, machine_);
    }
    if (!getVersionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(5, version_);
    }
    if (!getVendorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(6, vendor_);
    }
    if (!getVendorVersionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(7, vendorVersion_);
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
    if (!(obj instanceof us.ihmc.aci.ddam.OperatingSystem)) {
      return super.equals(obj);
    }
    us.ihmc.aci.ddam.OperatingSystem other = (us.ihmc.aci.ddam.OperatingSystem) obj;

    boolean result = true;
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && getName()
        .equals(other.getName());
    result = result && getArch()
        .equals(other.getArch());
    result = result && getMachine()
        .equals(other.getMachine());
    result = result && getVersion()
        .equals(other.getVersion());
    result = result && getVendor()
        .equals(other.getVendor());
    result = result && getVendorVersion()
        .equals(other.getVendorVersion());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + ARCH_FIELD_NUMBER;
    hash = (53 * hash) + getArch().hashCode();
    hash = (37 * hash) + MACHINE_FIELD_NUMBER;
    hash = (53 * hash) + getMachine().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion().hashCode();
    hash = (37 * hash) + VENDOR_FIELD_NUMBER;
    hash = (53 * hash) + getVendor().hashCode();
    hash = (37 * hash) + VENDORVERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVendorVersion().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static us.ihmc.aci.ddam.OperatingSystem parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(us.ihmc.aci.ddam.OperatingSystem prototype) {
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
   * Protobuf type {@code ddam.OperatingSystem}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ddam.OperatingSystem)
      us.ihmc.aci.ddam.OperatingSystemOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return us.ihmc.aci.ddam.InfoProto.internal_static_ddam_OperatingSystem_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return us.ihmc.aci.ddam.InfoProto.internal_static_ddam_OperatingSystem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              us.ihmc.aci.ddam.OperatingSystem.class, us.ihmc.aci.ddam.OperatingSystem.Builder.class);
    }

    // Construct using us.ihmc.aci.ddam.OperatingSystem.newBuilder()
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
      description_ = "";

      name_ = "";

      arch_ = "";

      machine_ = "";

      version_ = "";

      vendor_ = "";

      vendorVersion_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return us.ihmc.aci.ddam.InfoProto.internal_static_ddam_OperatingSystem_descriptor;
    }

    public us.ihmc.aci.ddam.OperatingSystem getDefaultInstanceForType() {
      return us.ihmc.aci.ddam.OperatingSystem.getDefaultInstance();
    }

    public us.ihmc.aci.ddam.OperatingSystem build() {
      us.ihmc.aci.ddam.OperatingSystem result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public us.ihmc.aci.ddam.OperatingSystem buildPartial() {
      us.ihmc.aci.ddam.OperatingSystem result = new us.ihmc.aci.ddam.OperatingSystem(this);
      result.description_ = description_;
      result.name_ = name_;
      result.arch_ = arch_;
      result.machine_ = machine_;
      result.version_ = version_;
      result.vendor_ = vendor_;
      result.vendorVersion_ = vendorVersion_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof us.ihmc.aci.ddam.OperatingSystem) {
        return mergeFrom((us.ihmc.aci.ddam.OperatingSystem)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(us.ihmc.aci.ddam.OperatingSystem other) {
      if (other == us.ihmc.aci.ddam.OperatingSystem.getDefaultInstance()) return this;
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getArch().isEmpty()) {
        arch_ = other.arch_;
        onChanged();
      }
      if (!other.getMachine().isEmpty()) {
        machine_ = other.machine_;
        onChanged();
      }
      if (!other.getVersion().isEmpty()) {
        version_ = other.version_;
        onChanged();
      }
      if (!other.getVendor().isEmpty()) {
        vendor_ = other.vendor_;
        onChanged();
      }
      if (!other.getVendorVersion().isEmpty()) {
        vendorVersion_ = other.vendorVersion_;
        onChanged();
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
      us.ihmc.aci.ddam.OperatingSystem parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (us.ihmc.aci.ddam.OperatingSystem) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>optional string description = 1;</code>
     *
     * <pre>
     *the description about this operating system
     * </pre>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string description = 1;</code>
     *
     * <pre>
     *the description about this operating system
     * </pre>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string description = 1;</code>
     *
     * <pre>
     *the description about this operating system
     * </pre>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string description = 1;</code>
     *
     * <pre>
     *the description about this operating system
     * </pre>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>optional string description = 1;</code>
     *
     * <pre>
     *the description about this operating system
     * </pre>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *the name of this operating system
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
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *the name of this operating system
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
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *the name of this operating system
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
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *the name of this operating system
     * </pre>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *the name of this operating system
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

    private java.lang.Object arch_ = "";
    /**
     * <code>optional string arch = 3;</code>
     *
     * <pre>
     *the system architecture
     * </pre>
     */
    public java.lang.String getArch() {
      java.lang.Object ref = arch_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        arch_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string arch = 3;</code>
     *
     * <pre>
     *the system architecture
     * </pre>
     */
    public com.google.protobuf.ByteString
        getArchBytes() {
      java.lang.Object ref = arch_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        arch_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string arch = 3;</code>
     *
     * <pre>
     *the system architecture
     * </pre>
     */
    public Builder setArch(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      arch_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string arch = 3;</code>
     *
     * <pre>
     *the system architecture
     * </pre>
     */
    public Builder clearArch() {
      
      arch_ = getDefaultInstance().getArch();
      onChanged();
      return this;
    }
    /**
     * <code>optional string arch = 3;</code>
     *
     * <pre>
     *the system architecture
     * </pre>
     */
    public Builder setArchBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      arch_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object machine_ = "";
    /**
     * <code>optional string machine = 4;</code>
     *
     * <pre>
     *the machine version of this operating system
     * </pre>
     */
    public java.lang.String getMachine() {
      java.lang.Object ref = machine_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        machine_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string machine = 4;</code>
     *
     * <pre>
     *the machine version of this operating system
     * </pre>
     */
    public com.google.protobuf.ByteString
        getMachineBytes() {
      java.lang.Object ref = machine_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        machine_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string machine = 4;</code>
     *
     * <pre>
     *the machine version of this operating system
     * </pre>
     */
    public Builder setMachine(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      machine_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string machine = 4;</code>
     *
     * <pre>
     *the machine version of this operating system
     * </pre>
     */
    public Builder clearMachine() {
      
      machine_ = getDefaultInstance().getMachine();
      onChanged();
      return this;
    }
    /**
     * <code>optional string machine = 4;</code>
     *
     * <pre>
     *the machine version of this operating system
     * </pre>
     */
    public Builder setMachineBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      machine_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object version_ = "";
    /**
     * <code>optional string version = 5;</code>
     *
     * <pre>
     *the version of this operating system
     * </pre>
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        version_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string version = 5;</code>
     *
     * <pre>
     *the version of this operating system
     * </pre>
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string version = 5;</code>
     *
     * <pre>
     *the version of this operating system
     * </pre>
     */
    public Builder setVersion(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string version = 5;</code>
     *
     * <pre>
     *the version of this operating system
     * </pre>
     */
    public Builder clearVersion() {
      
      version_ = getDefaultInstance().getVersion();
      onChanged();
      return this;
    }
    /**
     * <code>optional string version = 5;</code>
     *
     * <pre>
     *the version of this operating system
     * </pre>
     */
    public Builder setVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      version_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object vendor_ = "";
    /**
     * <code>optional string vendor = 6;</code>
     *
     * <pre>
     *the vendor of this operating system
     * </pre>
     */
    public java.lang.String getVendor() {
      java.lang.Object ref = vendor_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vendor_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string vendor = 6;</code>
     *
     * <pre>
     *the vendor of this operating system
     * </pre>
     */
    public com.google.protobuf.ByteString
        getVendorBytes() {
      java.lang.Object ref = vendor_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        vendor_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string vendor = 6;</code>
     *
     * <pre>
     *the vendor of this operating system
     * </pre>
     */
    public Builder setVendor(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      vendor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string vendor = 6;</code>
     *
     * <pre>
     *the vendor of this operating system
     * </pre>
     */
    public Builder clearVendor() {
      
      vendor_ = getDefaultInstance().getVendor();
      onChanged();
      return this;
    }
    /**
     * <code>optional string vendor = 6;</code>
     *
     * <pre>
     *the vendor of this operating system
     * </pre>
     */
    public Builder setVendorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      vendor_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object vendorVersion_ = "";
    /**
     * <code>optional string vendorVersion = 7;</code>
     *
     * <pre>
     *the vendor-specific version of this operating system
     * </pre>
     */
    public java.lang.String getVendorVersion() {
      java.lang.Object ref = vendorVersion_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        vendorVersion_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string vendorVersion = 7;</code>
     *
     * <pre>
     *the vendor-specific version of this operating system
     * </pre>
     */
    public com.google.protobuf.ByteString
        getVendorVersionBytes() {
      java.lang.Object ref = vendorVersion_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        vendorVersion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string vendorVersion = 7;</code>
     *
     * <pre>
     *the vendor-specific version of this operating system
     * </pre>
     */
    public Builder setVendorVersion(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      vendorVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string vendorVersion = 7;</code>
     *
     * <pre>
     *the vendor-specific version of this operating system
     * </pre>
     */
    public Builder clearVendorVersion() {
      
      vendorVersion_ = getDefaultInstance().getVendorVersion();
      onChanged();
      return this;
    }
    /**
     * <code>optional string vendorVersion = 7;</code>
     *
     * <pre>
     *the vendor-specific version of this operating system
     * </pre>
     */
    public Builder setVendorVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      vendorVersion_ = value;
      onChanged();
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


    // @@protoc_insertion_point(builder_scope:ddam.OperatingSystem)
  }

  // @@protoc_insertion_point(class_scope:ddam.OperatingSystem)
  private static final us.ihmc.aci.ddam.OperatingSystem DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new us.ihmc.aci.ddam.OperatingSystem();
  }

  public static us.ihmc.aci.ddam.OperatingSystem getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OperatingSystem>
      PARSER = new com.google.protobuf.AbstractParser<OperatingSystem>() {
    public OperatingSystem parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new OperatingSystem(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<OperatingSystem> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OperatingSystem> getParserForType() {
    return PARSER;
  }

  public us.ihmc.aci.ddam.OperatingSystem getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

