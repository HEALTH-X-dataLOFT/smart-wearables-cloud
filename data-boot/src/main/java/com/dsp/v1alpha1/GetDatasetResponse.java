// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha1/provider.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha1;

/**
 * <pre>
 * GetDatasetResponse contains the requested dataset.
 * </pre>
 *
 * Protobuf type {@code dsp.v1alpha1.GetDatasetResponse}
 */
public final class GetDatasetResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dsp.v1alpha1.GetDatasetResponse)
    GetDatasetResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetDatasetResponse.newBuilder() to construct.
  private GetDatasetResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetDatasetResponse() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetDatasetResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_GetDatasetResponse_descriptor;
  }

  @Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_GetDatasetResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dsp.v1alpha1.GetDatasetResponse.class, com.dsp.v1alpha1.GetDatasetResponse.Builder.class);
  }

  private int bitField0_;
  public static final int DATASET_FIELD_NUMBER = 1;
  private com.dsp.v1alpha1.Dataset dataset_;
  /**
   * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
   * @return Whether the dataset field is set.
   */
  @Override
  public boolean hasDataset() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
   * @return The dataset.
   */
  @Override
  public com.dsp.v1alpha1.Dataset getDataset() {
    return dataset_ == null ? com.dsp.v1alpha1.Dataset.getDefaultInstance() : dataset_;
  }
  /**
   * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
   */
  @Override
  public com.dsp.v1alpha1.DatasetOrBuilder getDatasetOrBuilder() {
    return dataset_ == null ? com.dsp.v1alpha1.Dataset.getDefaultInstance() : dataset_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getDataset());
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDataset());
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
    if (!(obj instanceof com.dsp.v1alpha1.GetDatasetResponse)) {
      return super.equals(obj);
    }
    com.dsp.v1alpha1.GetDatasetResponse other = (com.dsp.v1alpha1.GetDatasetResponse) obj;

    if (hasDataset() != other.hasDataset()) return false;
    if (hasDataset()) {
      if (!getDataset()
          .equals(other.getDataset())) return false;
    }
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
    if (hasDataset()) {
      hash = (37 * hash) + DATASET_FIELD_NUMBER;
      hash = (53 * hash) + getDataset().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.dsp.v1alpha1.GetDatasetResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.dsp.v1alpha1.GetDatasetResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dsp.v1alpha1.GetDatasetResponse parseFrom(
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
  public static Builder newBuilder(com.dsp.v1alpha1.GetDatasetResponse prototype) {
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
   * GetDatasetResponse contains the requested dataset.
   * </pre>
   *
   * Protobuf type {@code dsp.v1alpha1.GetDatasetResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dsp.v1alpha1.GetDatasetResponse)
      com.dsp.v1alpha1.GetDatasetResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_GetDatasetResponse_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_GetDatasetResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dsp.v1alpha1.GetDatasetResponse.class, com.dsp.v1alpha1.GetDatasetResponse.Builder.class);
    }

    // Construct using com.dsp.v1alpha1.GetDatasetResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getDatasetFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      dataset_ = null;
      if (datasetBuilder_ != null) {
        datasetBuilder_.dispose();
        datasetBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dsp.v1alpha1.ProviderProto.internal_static_dsp_v1alpha1_GetDatasetResponse_descriptor;
    }

    @Override
    public com.dsp.v1alpha1.GetDatasetResponse getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public com.dsp.v1alpha1.GetDatasetResponse build() {
      com.dsp.v1alpha1.GetDatasetResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public com.dsp.v1alpha1.GetDatasetResponse buildPartial() {
      com.dsp.v1alpha1.GetDatasetResponse result = new com.dsp.v1alpha1.GetDatasetResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.dsp.v1alpha1.GetDatasetResponse result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.dataset_ = datasetBuilder_ == null
            ? dataset_
            : datasetBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof com.dsp.v1alpha1.GetDatasetResponse) {
        return mergeFrom((com.dsp.v1alpha1.GetDatasetResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dsp.v1alpha1.GetDatasetResponse other) {
      if (other == getDefaultInstance()) return this;
      if (other.hasDataset()) {
        mergeDataset(other.getDataset());
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
              input.readMessage(
                  getDatasetFieldBuilder().getBuilder(),
                  extensionRegistry);
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

    private com.dsp.v1alpha1.Dataset dataset_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dsp.v1alpha1.Dataset, com.dsp.v1alpha1.Dataset.Builder, com.dsp.v1alpha1.DatasetOrBuilder> datasetBuilder_;
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     * @return Whether the dataset field is set.
     */
    public boolean hasDataset() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     * @return The dataset.
     */
    public com.dsp.v1alpha1.Dataset getDataset() {
      if (datasetBuilder_ == null) {
        return dataset_ == null ? com.dsp.v1alpha1.Dataset.getDefaultInstance() : dataset_;
      } else {
        return datasetBuilder_.getMessage();
      }
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public Builder setDataset(com.dsp.v1alpha1.Dataset value) {
      if (datasetBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dataset_ = value;
      } else {
        datasetBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public Builder setDataset(
        com.dsp.v1alpha1.Dataset.Builder builderForValue) {
      if (datasetBuilder_ == null) {
        dataset_ = builderForValue.build();
      } else {
        datasetBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public Builder mergeDataset(com.dsp.v1alpha1.Dataset value) {
      if (datasetBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          dataset_ != null &&
          dataset_ != com.dsp.v1alpha1.Dataset.getDefaultInstance()) {
          getDatasetBuilder().mergeFrom(value);
        } else {
          dataset_ = value;
        }
      } else {
        datasetBuilder_.mergeFrom(value);
      }
      if (dataset_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public Builder clearDataset() {
      bitField0_ = (bitField0_ & ~0x00000001);
      dataset_ = null;
      if (datasetBuilder_ != null) {
        datasetBuilder_.dispose();
        datasetBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public com.dsp.v1alpha1.Dataset.Builder getDatasetBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getDatasetFieldBuilder().getBuilder();
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    public com.dsp.v1alpha1.DatasetOrBuilder getDatasetOrBuilder() {
      if (datasetBuilder_ != null) {
        return datasetBuilder_.getMessageOrBuilder();
      } else {
        return dataset_ == null ?
            com.dsp.v1alpha1.Dataset.getDefaultInstance() : dataset_;
      }
    }
    /**
     * <code>.dsp.v1alpha1.Dataset dataset = 1 [json_name = "dataset"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dsp.v1alpha1.Dataset, com.dsp.v1alpha1.Dataset.Builder, com.dsp.v1alpha1.DatasetOrBuilder> 
        getDatasetFieldBuilder() {
      if (datasetBuilder_ == null) {
        datasetBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dsp.v1alpha1.Dataset, com.dsp.v1alpha1.Dataset.Builder, com.dsp.v1alpha1.DatasetOrBuilder>(
                getDataset(),
                getParentForChildren(),
                isClean());
        dataset_ = null;
      }
      return datasetBuilder_;
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


    // @@protoc_insertion_point(builder_scope:dsp.v1alpha1.GetDatasetResponse)
  }

  // @@protoc_insertion_point(class_scope:dsp.v1alpha1.GetDatasetResponse)
  private static final com.dsp.v1alpha1.GetDatasetResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dsp.v1alpha1.GetDatasetResponse();
  }

  public static com.dsp.v1alpha1.GetDatasetResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetDatasetResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetDatasetResponse>() {
    @Override
    public GetDatasetResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetDatasetResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetDatasetResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public com.dsp.v1alpha1.GetDatasetResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

