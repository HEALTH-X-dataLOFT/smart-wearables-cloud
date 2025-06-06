// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/control.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

/**
 * <pre>
 * SignalTransferCancelledRequest is sent when the client wants to cancel a transfer.
 * </pre>
 *
 * Protobuf type {@code dsp.v1alpha2.SignalTransferCancelledRequest}
 */
public final class SignalTransferCancelledRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dsp.v1alpha2.SignalTransferCancelledRequest)
    SignalTransferCancelledRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SignalTransferCancelledRequest.newBuilder() to construct.
  private SignalTransferCancelledRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SignalTransferCancelledRequest() {
    transferId_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new SignalTransferCancelledRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ControlProto.internal_static_dsp_v1alpha2_SignalTransferCancelledRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ControlProto.internal_static_dsp_v1alpha2_SignalTransferCancelledRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            SignalTransferCancelledRequest.class, Builder.class);
  }

  public static final int TRANSFER_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object transferId_ = "";
  /**
   * <code>string transfer_id = 1 [json_name = "transferId"];</code>
   * @return The transferId.
   */
  @Override
  public String getTransferId() {
    Object ref = transferId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      transferId_ = s;
      return s;
    }
  }
  /**
   * <code>string transfer_id = 1 [json_name = "transferId"];</code>
   * @return The bytes for transferId.
   */
  @Override
  public com.google.protobuf.ByteString
      getTransferIdBytes() {
    Object ref = transferId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      transferId_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(transferId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, transferId_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(transferId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, transferId_);
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
    if (!(obj instanceof SignalTransferCancelledRequest)) {
      return super.equals(obj);
    }
    SignalTransferCancelledRequest other = (SignalTransferCancelledRequest) obj;

    if (!getTransferId()
        .equals(other.getTransferId())) return false;
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
    hash = (37 * hash) + TRANSFER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getTransferId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static SignalTransferCancelledRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SignalTransferCancelledRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SignalTransferCancelledRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SignalTransferCancelledRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SignalTransferCancelledRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SignalTransferCancelledRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SignalTransferCancelledRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SignalTransferCancelledRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static SignalTransferCancelledRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static SignalTransferCancelledRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static SignalTransferCancelledRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SignalTransferCancelledRequest parseFrom(
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
  public static Builder newBuilder(SignalTransferCancelledRequest prototype) {
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
   * SignalTransferCancelledRequest is sent when the client wants to cancel a transfer.
   * </pre>
   *
   * Protobuf type {@code dsp.v1alpha2.SignalTransferCancelledRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dsp.v1alpha2.SignalTransferCancelledRequest)
      SignalTransferCancelledRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ControlProto.internal_static_dsp_v1alpha2_SignalTransferCancelledRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ControlProto.internal_static_dsp_v1alpha2_SignalTransferCancelledRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SignalTransferCancelledRequest.class, Builder.class);
    }

    // Construct using com.dsp.v1alpha2.SignalTransferCancelledRequest.newBuilder()
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
      transferId_ = "";
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ControlProto.internal_static_dsp_v1alpha2_SignalTransferCancelledRequest_descriptor;
    }

    @Override
    public SignalTransferCancelledRequest getDefaultInstanceForType() {
      return SignalTransferCancelledRequest.getDefaultInstance();
    }

    @Override
    public SignalTransferCancelledRequest build() {
      SignalTransferCancelledRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public SignalTransferCancelledRequest buildPartial() {
      SignalTransferCancelledRequest result = new SignalTransferCancelledRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(SignalTransferCancelledRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.transferId_ = transferId_;
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
      if (other instanceof SignalTransferCancelledRequest) {
        return mergeFrom((SignalTransferCancelledRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(SignalTransferCancelledRequest other) {
      if (other == SignalTransferCancelledRequest.getDefaultInstance()) return this;
      if (!other.getTransferId().isEmpty()) {
        transferId_ = other.transferId_;
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
              transferId_ = input.readStringRequireUtf8();
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

    private Object transferId_ = "";
    /**
     * <code>string transfer_id = 1 [json_name = "transferId"];</code>
     * @return The transferId.
     */
    public String getTransferId() {
      Object ref = transferId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        transferId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string transfer_id = 1 [json_name = "transferId"];</code>
     * @return The bytes for transferId.
     */
    public com.google.protobuf.ByteString
        getTransferIdBytes() {
      Object ref = transferId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        transferId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string transfer_id = 1 [json_name = "transferId"];</code>
     * @param value The transferId to set.
     * @return This builder for chaining.
     */
    public Builder setTransferId(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      transferId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string transfer_id = 1 [json_name = "transferId"];</code>
     * @return This builder for chaining.
     */
    public Builder clearTransferId() {
      transferId_ = getDefaultInstance().getTransferId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string transfer_id = 1 [json_name = "transferId"];</code>
     * @param value The bytes for transferId to set.
     * @return This builder for chaining.
     */
    public Builder setTransferIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      transferId_ = value;
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


    // @@protoc_insertion_point(builder_scope:dsp.v1alpha2.SignalTransferCancelledRequest)
  }

  // @@protoc_insertion_point(class_scope:dsp.v1alpha2.SignalTransferCancelledRequest)
  private static final SignalTransferCancelledRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SignalTransferCancelledRequest();
  }

  public static SignalTransferCancelledRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SignalTransferCancelledRequest>
      PARSER = new com.google.protobuf.AbstractParser<SignalTransferCancelledRequest>() {
    @Override
    public SignalTransferCancelledRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SignalTransferCancelledRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SignalTransferCancelledRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public SignalTransferCancelledRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

