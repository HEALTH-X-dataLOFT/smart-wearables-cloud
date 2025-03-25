// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha1/provider.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha1;

/**
 * <pre>
 * SuspendPublishedDatasetRequest contains the publish ID of the published dataset.
 * </pre>
 *
 * Protobuf type {@code dsp.v1alpha1.SuspendPublishedDatasetRequest}
 */
public final class SuspendPublishedDatasetRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dsp.v1alpha1.SuspendPublishedDatasetRequest)
    SuspendPublishedDatasetRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SuspendPublishedDatasetRequest.newBuilder() to construct.
  private SuspendPublishedDatasetRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SuspendPublishedDatasetRequest() {
    publishId_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new SuspendPublishedDatasetRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_SuspendPublishedDatasetRequest_descriptor;
  }

  @Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_SuspendPublishedDatasetRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dsp.v1alpha1.SuspendPublishedDatasetRequest.class, com.dsp.v1alpha1.SuspendPublishedDatasetRequest.Builder.class);
  }

  public static final int PUBLISH_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object publishId_ = "";
  /**
   * <code>string publish_id = 1 [json_name = "publishId"];</code>
   * @return The publishId.
   */
  @Override
  public String getPublishId() {
    Object ref = publishId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      publishId_ = s;
      return s;
    }
  }
  /**
   * <code>string publish_id = 1 [json_name = "publishId"];</code>
   * @return The bytes for publishId.
   */
  @Override
  public com.google.protobuf.ByteString
      getPublishIdBytes() {
    Object ref = publishId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      publishId_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(publishId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, publishId_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(publishId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, publishId_);
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
    if (!(obj instanceof com.dsp.v1alpha1.SuspendPublishedDatasetRequest)) {
      return super.equals(obj);
    }
    com.dsp.v1alpha1.SuspendPublishedDatasetRequest other = (com.dsp.v1alpha1.SuspendPublishedDatasetRequest) obj;

    if (!getPublishId()
        .equals(other.getPublishId())) return false;
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
    hash = (37 * hash) + PUBLISH_ID_FIELD_NUMBER;
    hash = (53 * hash) + getPublishId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest parseFrom(
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
  public static Builder newBuilder(com.dsp.v1alpha1.SuspendPublishedDatasetRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * SuspendPublishedDatasetRequest contains the publish ID of the published dataset.
   * </pre>
   *
   * Protobuf type {@code dsp.v1alpha1.SuspendPublishedDatasetRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dsp.v1alpha1.SuspendPublishedDatasetRequest)
      com.dsp.v1alpha1.SuspendPublishedDatasetRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_SuspendPublishedDatasetRequest_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_SuspendPublishedDatasetRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dsp.v1alpha1.SuspendPublishedDatasetRequest.class, com.dsp.v1alpha1.SuspendPublishedDatasetRequest.Builder.class);
    }

    // Construct using com.dsp.v1alpha1.SuspendPublishedDatasetRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      publishId_ = "";
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_SuspendPublishedDatasetRequest_descriptor;
    }

    @Override
    public com.dsp.v1alpha1.SuspendPublishedDatasetRequest getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public com.dsp.v1alpha1.SuspendPublishedDatasetRequest build() {
      com.dsp.v1alpha1.SuspendPublishedDatasetRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public com.dsp.v1alpha1.SuspendPublishedDatasetRequest buildPartial() {
      com.dsp.v1alpha1.SuspendPublishedDatasetRequest result = new com.dsp.v1alpha1.SuspendPublishedDatasetRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.dsp.v1alpha1.SuspendPublishedDatasetRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.publishId_ = publishId_;
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
      if (other instanceof com.dsp.v1alpha1.SuspendPublishedDatasetRequest) {
        return mergeFrom((com.dsp.v1alpha1.SuspendPublishedDatasetRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dsp.v1alpha1.SuspendPublishedDatasetRequest other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getPublishId().isEmpty()) {
        publishId_ = other.publishId_;
        bitField0_ |= 0x00000001;
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
              publishId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
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

    private Object publishId_ = "";
    /**
     * <code>string publish_id = 1 [json_name = "publishId"];</code>
     * @return The publishId.
     */
    public String getPublishId() {
      Object ref = publishId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        publishId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string publish_id = 1 [json_name = "publishId"];</code>
     * @return The bytes for publishId.
     */
    public com.google.protobuf.ByteString
        getPublishIdBytes() {
      Object ref = publishId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        publishId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string publish_id = 1 [json_name = "publishId"];</code>
     * @param value The publishId to set.
     * @return This builder for chaining.
     */
    public Builder setPublishId(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      publishId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string publish_id = 1 [json_name = "publishId"];</code>
     * @return This builder for chaining.
     */
    public Builder clearPublishId() {
      publishId_ = getDefaultInstance().getPublishId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string publish_id = 1 [json_name = "publishId"];</code>
     * @param value The bytes for publishId to set.
     * @return This builder for chaining.
     */
    public Builder setPublishIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      publishId_ = value;
      bitField0_ |= 0x00000001;
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


    // @@protoc_insertion_point(builder_scope:dsp.v1alpha1.SuspendPublishedDatasetRequest)
  }

  // @@protoc_insertion_point(class_scope:dsp.v1alpha1.SuspendPublishedDatasetRequest)
  private static final com.dsp.v1alpha1.SuspendPublishedDatasetRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dsp.v1alpha1.SuspendPublishedDatasetRequest();
  }

  public static com.dsp.v1alpha1.SuspendPublishedDatasetRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SuspendPublishedDatasetRequest>
      PARSER = new com.google.protobuf.AbstractParser<SuspendPublishedDatasetRequest>() {
    @Override
    public SuspendPublishedDatasetRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SuspendPublishedDatasetRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SuspendPublishedDatasetRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public com.dsp.v1alpha1.SuspendPublishedDatasetRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

