// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/control.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

public interface ContractTerminateRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dsp.v1alpha2.ContractTerminateRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string pid = 1 [json_name = "pid"];</code>
   * @return The pid.
   */
  String getPid();
  /**
   * <code>string pid = 1 [json_name = "pid"];</code>
   * @return The bytes for pid.
   */
  com.google.protobuf.ByteString
      getPidBytes();

  /**
   * <code>string code = 2 [json_name = "code"];</code>
   * @return The code.
   */
  String getCode();
  /**
   * <code>string code = 2 [json_name = "code"];</code>
   * @return The bytes for code.
   */
  com.google.protobuf.ByteString
      getCodeBytes();

  /**
   * <code>repeated string reason = 3 [json_name = "reason"];</code>
   * @return A list containing the reason.
   */
  java.util.List<String>
      getReasonList();
  /**
   * <code>repeated string reason = 3 [json_name = "reason"];</code>
   * @return The count of reason.
   */
  int getReasonCount();
  /**
   * <code>repeated string reason = 3 [json_name = "reason"];</code>
   * @param index The index of the element to return.
   * @return The reason at the given index.
   */
  String getReason(int index);
  /**
   * <code>repeated string reason = 3 [json_name = "reason"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the reason at the given index.
   */
  com.google.protobuf.ByteString
      getReasonBytes(int index);
}
