// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/control.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

/**
 * <pre>
 * ContractRequestRequest contains the offer, and a pid if this is needs to send a request for an already
 * existing offer, or a participant_address if this is a request for a new offer.
 * </pre>
 *
 * Protobuf type {@code dsp.v1alpha2.ContractRequestRequest}
 */
public final class ContractRequestRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dsp.v1alpha2.ContractRequestRequest)
    ContractRequestRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ContractRequestRequest.newBuilder() to construct.
  private ContractRequestRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ContractRequestRequest() {
    offer_ = "";
    pid_ = "";
    participantAddress_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new ContractRequestRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ControlProto.internal_static_dsp_v1alpha2_ContractRequestRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ControlProto.internal_static_dsp_v1alpha2_ContractRequestRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ContractRequestRequest.class, Builder.class);
  }

  private int bitField0_;
  public static final int OFFER_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object offer_ = "";
  /**
   * <code>string offer = 1 [json_name = "offer"];</code>
   * @return The offer.
   */
  @Override
  public String getOffer() {
    Object ref = offer_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      offer_ = s;
      return s;
    }
  }
  /**
   * <code>string offer = 1 [json_name = "offer"];</code>
   * @return The bytes for offer.
   */
  @Override
  public com.google.protobuf.ByteString
      getOfferBytes() {
    Object ref = offer_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      offer_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PID_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile Object pid_ = "";
  /**
   * <code>optional string pid = 2 [json_name = "pid"];</code>
   * @return Whether the pid field is set.
   */
  @Override
  public boolean hasPid() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string pid = 2 [json_name = "pid"];</code>
   * @return The pid.
   */
  @Override
  public String getPid() {
    Object ref = pid_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      pid_ = s;
      return s;
    }
  }
  /**
   * <code>optional string pid = 2 [json_name = "pid"];</code>
   * @return The bytes for pid.
   */
  @Override
  public com.google.protobuf.ByteString
      getPidBytes() {
    Object ref = pid_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      pid_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PARTICIPANT_ADDRESS_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile Object participantAddress_ = "";
  /**
   * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
   * @return Whether the participantAddress field is set.
   */
  @Override
  public boolean hasParticipantAddress() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
   * @return The participantAddress.
   */
  @Override
  public String getParticipantAddress() {
    Object ref = participantAddress_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      participantAddress_ = s;
      return s;
    }
  }
  /**
   * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
   * @return The bytes for participantAddress.
   */
  @Override
  public com.google.protobuf.ByteString
      getParticipantAddressBytes() {
    Object ref = participantAddress_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      participantAddress_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AUTO_ACCEPT_FIELD_NUMBER = 4;
  private boolean autoAccept_ = false;
  /**
   * <code>bool auto_accept = 4 [json_name = "autoAccept"];</code>
   * @return The autoAccept.
   */
  @Override
  public boolean getAutoAccept() {
    return autoAccept_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(offer_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, offer_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, pid_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, participantAddress_);
    }
    if (autoAccept_ != false) {
      output.writeBool(4, autoAccept_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(offer_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, offer_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, pid_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, participantAddress_);
    }
    if (autoAccept_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, autoAccept_);
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
    if (!(obj instanceof ContractRequestRequest)) {
      return super.equals(obj);
    }
    ContractRequestRequest other = (ContractRequestRequest) obj;

    if (!getOffer()
        .equals(other.getOffer())) return false;
    if (hasPid() != other.hasPid()) return false;
    if (hasPid()) {
      if (!getPid()
          .equals(other.getPid())) return false;
    }
    if (hasParticipantAddress() != other.hasParticipantAddress()) return false;
    if (hasParticipantAddress()) {
      if (!getParticipantAddress()
          .equals(other.getParticipantAddress())) return false;
    }
    if (getAutoAccept()
        != other.getAutoAccept()) return false;
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
    hash = (37 * hash) + OFFER_FIELD_NUMBER;
    hash = (53 * hash) + getOffer().hashCode();
    if (hasPid()) {
      hash = (37 * hash) + PID_FIELD_NUMBER;
      hash = (53 * hash) + getPid().hashCode();
    }
    if (hasParticipantAddress()) {
      hash = (37 * hash) + PARTICIPANT_ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getParticipantAddress().hashCode();
    }
    hash = (37 * hash) + AUTO_ACCEPT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAutoAccept());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ContractRequestRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ContractRequestRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ContractRequestRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ContractRequestRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ContractRequestRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ContractRequestRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ContractRequestRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ContractRequestRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static ContractRequestRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static ContractRequestRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ContractRequestRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ContractRequestRequest parseFrom(
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
  public static Builder newBuilder(ContractRequestRequest prototype) {
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
   * ContractRequestRequest contains the offer, and a pid if this is needs to send a request for an already
   * existing offer, or a participant_address if this is a request for a new offer.
   * </pre>
   *
   * Protobuf type {@code dsp.v1alpha2.ContractRequestRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dsp.v1alpha2.ContractRequestRequest)
      ContractRequestRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ControlProto.internal_static_dsp_v1alpha2_ContractRequestRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ControlProto.internal_static_dsp_v1alpha2_ContractRequestRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ContractRequestRequest.class, Builder.class);
    }

    // Construct using com.dsp.v1alpha2.ContractRequestRequest.newBuilder()
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
      offer_ = "";
      pid_ = "";
      participantAddress_ = "";
      autoAccept_ = false;
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ControlProto.internal_static_dsp_v1alpha2_ContractRequestRequest_descriptor;
    }

    @Override
    public ContractRequestRequest getDefaultInstanceForType() {
      return ContractRequestRequest.getDefaultInstance();
    }

    @Override
    public ContractRequestRequest build() {
      ContractRequestRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public ContractRequestRequest buildPartial() {
      ContractRequestRequest result = new ContractRequestRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(ContractRequestRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.offer_ = offer_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.pid_ = pid_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.participantAddress_ = participantAddress_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.autoAccept_ = autoAccept_;
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
      if (other instanceof ContractRequestRequest) {
        return mergeFrom((ContractRequestRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ContractRequestRequest other) {
      if (other == ContractRequestRequest.getDefaultInstance()) return this;
      if (!other.getOffer().isEmpty()) {
        offer_ = other.offer_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasPid()) {
        pid_ = other.pid_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.hasParticipantAddress()) {
        participantAddress_ = other.participantAddress_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getAutoAccept() != false) {
        setAutoAccept(other.getAutoAccept());
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
              offer_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              pid_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              participantAddress_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              autoAccept_ = input.readBool();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private Object offer_ = "";
    /**
     * <code>string offer = 1 [json_name = "offer"];</code>
     * @return The offer.
     */
    public String getOffer() {
      Object ref = offer_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        offer_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string offer = 1 [json_name = "offer"];</code>
     * @return The bytes for offer.
     */
    public com.google.protobuf.ByteString
        getOfferBytes() {
      Object ref = offer_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        offer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string offer = 1 [json_name = "offer"];</code>
     * @param value The offer to set.
     * @return This builder for chaining.
     */
    public Builder setOffer(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      offer_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string offer = 1 [json_name = "offer"];</code>
     * @return This builder for chaining.
     */
    public Builder clearOffer() {
      offer_ = getDefaultInstance().getOffer();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string offer = 1 [json_name = "offer"];</code>
     * @param value The bytes for offer to set.
     * @return This builder for chaining.
     */
    public Builder setOfferBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      offer_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private Object pid_ = "";
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @return Whether the pid field is set.
     */
    public boolean hasPid() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @return The pid.
     */
    public String getPid() {
      Object ref = pid_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        pid_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @return The bytes for pid.
     */
    public com.google.protobuf.ByteString
        getPidBytes() {
      Object ref = pid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        pid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @param value The pid to set.
     * @return This builder for chaining.
     */
    public Builder setPid(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      pid_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @return This builder for chaining.
     */
    public Builder clearPid() {
      pid_ = getDefaultInstance().getPid();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>optional string pid = 2 [json_name = "pid"];</code>
     * @param value The bytes for pid to set.
     * @return This builder for chaining.
     */
    public Builder setPidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      pid_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private Object participantAddress_ = "";
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @return Whether the participantAddress field is set.
     */
    public boolean hasParticipantAddress() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @return The participantAddress.
     */
    public String getParticipantAddress() {
      Object ref = participantAddress_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        participantAddress_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @return The bytes for participantAddress.
     */
    public com.google.protobuf.ByteString
        getParticipantAddressBytes() {
      Object ref = participantAddress_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        participantAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @param value The participantAddress to set.
     * @return This builder for chaining.
     */
    public Builder setParticipantAddress(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      participantAddress_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @return This builder for chaining.
     */
    public Builder clearParticipantAddress() {
      participantAddress_ = getDefaultInstance().getParticipantAddress();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>optional string participant_address = 3 [json_name = "participantAddress"];</code>
     * @param value The bytes for participantAddress to set.
     * @return This builder for chaining.
     */
    public Builder setParticipantAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      participantAddress_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private boolean autoAccept_ ;
    /**
     * <code>bool auto_accept = 4 [json_name = "autoAccept"];</code>
     * @return The autoAccept.
     */
    @Override
    public boolean getAutoAccept() {
      return autoAccept_;
    }
    /**
     * <code>bool auto_accept = 4 [json_name = "autoAccept"];</code>
     * @param value The autoAccept to set.
     * @return This builder for chaining.
     */
    public Builder setAutoAccept(boolean value) {

      autoAccept_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>bool auto_accept = 4 [json_name = "autoAccept"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAutoAccept() {
      bitField0_ = (bitField0_ & ~0x00000008);
      autoAccept_ = false;
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


    // @@protoc_insertion_point(builder_scope:dsp.v1alpha2.ContractRequestRequest)
  }

  // @@protoc_insertion_point(class_scope:dsp.v1alpha2.ContractRequestRequest)
  private static final ContractRequestRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ContractRequestRequest();
  }

  public static ContractRequestRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ContractRequestRequest>
      PARSER = new com.google.protobuf.AbstractParser<ContractRequestRequest>() {
    @Override
    public ContractRequestRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<ContractRequestRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ContractRequestRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public ContractRequestRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

