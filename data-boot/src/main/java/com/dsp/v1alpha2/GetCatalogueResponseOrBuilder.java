// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/provider.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

public interface GetCatalogueResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dsp.v1alpha2.GetCatalogueResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .dsp.v1alpha2.Dataset datasets = 1 [json_name = "datasets"];</code>
   */
  java.util.List<Dataset>
      getDatasetsList();
  /**
   * <code>repeated .dsp.v1alpha2.Dataset datasets = 1 [json_name = "datasets"];</code>
   */
  Dataset getDatasets(int index);
  /**
   * <code>repeated .dsp.v1alpha2.Dataset datasets = 1 [json_name = "datasets"];</code>
   */
  int getDatasetsCount();
  /**
   * <code>repeated .dsp.v1alpha2.Dataset datasets = 1 [json_name = "datasets"];</code>
   */
  java.util.List<? extends DatasetOrBuilder>
      getDatasetsOrBuilderList();
  /**
   * <code>repeated .dsp.v1alpha2.Dataset datasets = 1 [json_name = "datasets"];</code>
   */
  DatasetOrBuilder getDatasetsOrBuilder(
      int index);
}
