// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha1/provider.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha1;

public interface GetCatalogueRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dsp.v1alpha1.GetCatalogueRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * query_parameters is just a key/value map. These are not specified in the dataspace standard.
   * RUN-DSP also does not define them yet, so for now this is a placeholder.
   * </pre>
   *
   * <code>map&lt;string, string&gt; query_parameters = 1 [json_name = "queryParameters"];</code>
   */
  int getQueryParametersCount();
  /**
   * <pre>
   * query_parameters is just a key/value map. These are not specified in the dataspace standard.
   * RUN-DSP also does not define them yet, so for now this is a placeholder.
   * </pre>
   *
   * <code>map&lt;string, string&gt; query_parameters = 1 [json_name = "queryParameters"];</code>
   */
  boolean containsQueryParameters(
      String key);
  /**
   * Use {@link #getQueryParametersMap()} instead.
   */
  @Deprecated
  java.util.Map<String, String>
  getQueryParameters();
  /**
   * <pre>
   * query_parameters is just a key/value map. These are not specified in the dataspace standard.
   * RUN-DSP also does not define them yet, so for now this is a placeholder.
   * </pre>
   *
   * <code>map&lt;string, string&gt; query_parameters = 1 [json_name = "queryParameters"];</code>
   */
  java.util.Map<String, String>
  getQueryParametersMap();
  /**
   * <pre>
   * query_parameters is just a key/value map. These are not specified in the dataspace standard.
   * RUN-DSP also does not define them yet, so for now this is a placeholder.
   * </pre>
   *
   * <code>map&lt;string, string&gt; query_parameters = 1 [json_name = "queryParameters"];</code>
   */
  /* nullable */
String getQueryParametersOrDefault(
      String key,
      /* nullable */
String defaultValue);
  /**
   * <pre>
   * query_parameters is just a key/value map. These are not specified in the dataspace standard.
   * RUN-DSP also does not define them yet, so for now this is a placeholder.
   * </pre>
   *
   * <code>map&lt;string, string&gt; query_parameters = 1 [json_name = "queryParameters"];</code>
   */
  String getQueryParametersOrThrow(
      String key);
}
