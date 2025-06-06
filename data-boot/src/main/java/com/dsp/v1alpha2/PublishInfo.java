// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/types.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

/**
 * <pre>
 * PublishInfo represents a published file, where to get it and its authentication details.
 * </pre>
 *
 * Protobuf type {@code dsp.v1alpha2.PublishInfo}
 */
public final class PublishInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dsp.v1alpha2.PublishInfo)
    PublishInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PublishInfo.newBuilder() to construct.
  private PublishInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PublishInfo() {
    url_ = "";
    authenticationType_ = 0;
    username_ = "";
    password_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new PublishInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return TypesProto.internal_static_dsp_v1alpha2_PublishInfo_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return TypesProto.internal_static_dsp_v1alpha2_PublishInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            PublishInfo.class, Builder.class);
  }

  public static final int URL_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object url_ = "";
  /**
   * <code>string url = 1 [json_name = "url"];</code>
   * @return The url.
   */
  @Override
  public String getUrl() {
    Object ref = url_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      url_ = s;
      return s;
    }
  }
  /**
   * <code>string url = 1 [json_name = "url"];</code>
   * @return The bytes for url.
   */
  @Override
  public com.google.protobuf.ByteString
      getUrlBytes() {
    Object ref = url_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      url_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AUTHENTICATION_TYPE_FIELD_NUMBER = 2;
  private int authenticationType_ = 0;
  /**
   * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
   * @return The enum numeric value on the wire for authenticationType.
   */
  @Override public int getAuthenticationTypeValue() {
    return authenticationType_;
  }
  /**
   * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
   * @return The authenticationType.
   */
  @Override public AuthenticationType getAuthenticationType() {
    AuthenticationType result = AuthenticationType.forNumber(authenticationType_);
    return result == null ? AuthenticationType.UNRECOGNIZED : result;
  }

  public static final int USERNAME_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile Object username_ = "";
  /**
   * <code>string username = 3 [json_name = "username"];</code>
   * @return The username.
   */
  @Override
  public String getUsername() {
    Object ref = username_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>string username = 3 [json_name = "username"];</code>
   * @return The bytes for username.
   */
  @Override
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    Object ref = username_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PASSWORD_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile Object password_ = "";
  /**
   * <code>string password = 4 [json_name = "password"];</code>
   * @return The password.
   */
  @Override
  public String getPassword() {
    Object ref = password_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      password_ = s;
      return s;
    }
  }
  /**
   * <code>string password = 4 [json_name = "password"];</code>
   * @return The bytes for password.
   */
  @Override
  public com.google.protobuf.ByteString
      getPasswordBytes() {
    Object ref = password_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      password_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(url_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, url_);
    }
    if (authenticationType_ != AuthenticationType.AUTHENTICATION_TYPE_UNSPECIFIED.getNumber()) {
      output.writeEnum(2, authenticationType_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(username_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, username_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(password_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, password_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(url_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, url_);
    }
    if (authenticationType_ != AuthenticationType.AUTHENTICATION_TYPE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, authenticationType_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(username_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, username_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(password_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, password_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof PublishInfo)) {
      return super.equals(obj);
    }
    PublishInfo other = (PublishInfo) obj;

    if (!getUrl()
        .equals(other.getUrl())) return false;
    if (authenticationType_ != other.authenticationType_) return false;
    if (!getUsername()
        .equals(other.getUsername())) return false;
    if (!getPassword()
        .equals(other.getPassword())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + URL_FIELD_NUMBER;
    hash = (53 * hash) + getUrl().hashCode();
    hash = (37 * hash) + AUTHENTICATION_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + authenticationType_;
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUsername().hashCode();
    hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getPassword().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static PublishInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PublishInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PublishInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PublishInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PublishInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static PublishInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static PublishInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static PublishInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static PublishInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static PublishInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static PublishInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static PublishInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(PublishInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * PublishInfo represents a published file, where to get it and its authentication details.
   * </pre>
   *
   * Protobuf type {@code dsp.v1alpha2.PublishInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dsp.v1alpha2.PublishInfo)
      PublishInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return TypesProto.internal_static_dsp_v1alpha2_PublishInfo_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return TypesProto.internal_static_dsp_v1alpha2_PublishInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              PublishInfo.class, Builder.class);
    }

    // Construct using com.dsp.v1alpha2.PublishInfo.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      url_ = "";
      authenticationType_ = 0;
      username_ = "";
      password_ = "";
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return TypesProto.internal_static_dsp_v1alpha2_PublishInfo_descriptor;
    }

    @Override
    public PublishInfo getDefaultInstanceForType() {
      return PublishInfo.getDefaultInstance();
    }

    @Override
    public PublishInfo build() {
      PublishInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public PublishInfo buildPartial() {
      PublishInfo result = new PublishInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(PublishInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.url_ = url_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.authenticationType_ = authenticationType_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.username_ = username_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.password_ = password_;
      }
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof PublishInfo) {
        return mergeFrom((PublishInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(PublishInfo other) {
      if (other == PublishInfo.getDefaultInstance()) return this;
      if (!other.getUrl().isEmpty()) {
        url_ = other.url_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.authenticationType_ != 0) {
        setAuthenticationTypeValue(other.getAuthenticationTypeValue());
      }
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getPassword().isEmpty()) {
        password_ = other.password_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              url_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              authenticationType_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              username_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              password_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private Object url_ = "";
    /**
     * <code>string url = 1 [json_name = "url"];</code>
     * @return The url.
     */
    public String getUrl() {
      Object ref = url_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        url_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string url = 1 [json_name = "url"];</code>
     * @return The bytes for url.
     */
    public com.google.protobuf.ByteString
        getUrlBytes() {
      Object ref = url_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        url_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string url = 1 [json_name = "url"];</code>
     * @param value The url to set.
     * @return This builder for chaining.
     */
    public Builder setUrl(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      url_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string url = 1 [json_name = "url"];</code>
     * @return This builder for chaining.
     */
    public Builder clearUrl() {
      url_ = getDefaultInstance().getUrl();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string url = 1 [json_name = "url"];</code>
     * @param value The bytes for url to set.
     * @return This builder for chaining.
     */
    public Builder setUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      url_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int authenticationType_ = 0;
    /**
     * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
     * @return The enum numeric value on the wire for authenticationType.
     */
    @Override public int getAuthenticationTypeValue() {
      return authenticationType_;
    }
    /**
     * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
     * @param value The enum numeric value on the wire for authenticationType to set.
     * @return This builder for chaining.
     */
    public Builder setAuthenticationTypeValue(int value) {
      authenticationType_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
     * @return The authenticationType.
     */
    @Override
    public AuthenticationType getAuthenticationType() {
      AuthenticationType result = AuthenticationType.forNumber(authenticationType_);
      return result == null ? AuthenticationType.UNRECOGNIZED : result;
    }
    /**
     * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
     * @param value The authenticationType to set.
     * @return This builder for chaining.
     */
    public Builder setAuthenticationType(AuthenticationType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      authenticationType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.dsp.v1alpha2.AuthenticationType authentication_type = 2 [json_name = "authenticationType"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAuthenticationType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      authenticationType_ = 0;
      onChanged();
      return this;
    }

    private Object username_ = "";
    /**
     * <code>string username = 3 [json_name = "username"];</code>
     * @return The username.
     */
    public String getUsername() {
      Object ref = username_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string username = 3 [json_name = "username"];</code>
     * @return The bytes for username.
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string username = 3 [json_name = "username"];</code>
     * @param value The username to set.
     * @return This builder for chaining.
     */
    public Builder setUsername(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      username_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string username = 3 [json_name = "username"];</code>
     * @return This builder for chaining.
     */
    public Builder clearUsername() {
      username_ = getDefaultInstance().getUsername();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string username = 3 [json_name = "username"];</code>
     * @param value The bytes for username to set.
     * @return This builder for chaining.
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      username_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private Object password_ = "";
    /**
     * <code>string password = 4 [json_name = "password"];</code>
     * @return The password.
     */
    public String getPassword() {
      Object ref = password_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        password_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string password = 4 [json_name = "password"];</code>
     * @return The bytes for password.
     */
    public com.google.protobuf.ByteString
        getPasswordBytes() {
      Object ref = password_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        password_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string password = 4 [json_name = "password"];</code>
     * @param value The password to set.
     * @return This builder for chaining.
     */
    public Builder setPassword(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      password_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string password = 4 [json_name = "password"];</code>
     * @return This builder for chaining.
     */
    public Builder clearPassword() {
      password_ = getDefaultInstance().getPassword();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string password = 4 [json_name = "password"];</code>
     * @param value The bytes for password to set.
     * @return This builder for chaining.
     */
    public Builder setPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      password_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:dsp.v1alpha2.PublishInfo)
  }

  // @@protoc_insertion_point(class_scope:dsp.v1alpha2.PublishInfo)
  private static final PublishInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new PublishInfo();
  }

  public static PublishInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PublishInfo>
      PARSER = new com.google.protobuf.AbstractParser<PublishInfo>() {
    @Override
    public PublishInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PublishInfo> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<PublishInfo> getParserForType() {
    return PARSER;
  }

  @Override
  public PublishInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

