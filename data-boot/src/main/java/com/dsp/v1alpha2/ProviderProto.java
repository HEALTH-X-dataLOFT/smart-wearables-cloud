// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/provider.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

public final class ProviderProto {
  private ProviderProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_PingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_PingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_PingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_PingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_GetCatalogueRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_GetCatalogueRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_GetCatalogueRequest_QueryParametersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_GetCatalogueRequest_QueryParametersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_GetCatalogueResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_GetCatalogueResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_GetDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_GetDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_GetDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_GetDatasetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_PublishDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_PublishDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_PublishDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_PublishDatasetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_UnpublishDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_UnpublishDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_UnpublishDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_UnpublishDatasetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_SuspendPublishedDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_SuspendPublishedDatasetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\033dsp/v1alpha2/provider.proto\022\014dsp.v1alp" +
      "ha2\032\030dsp/v1alpha2/types.proto\"\r\n\013PingReq" +
      "uest\"\334\001\n\014PingResponse\022#\n\rprovider_name\030\001" +
      " \001(\tR\014providerName\0221\n\024provider_descripti" +
      "on\030\002 \001(\tR\023providerDescription\022$\n\rauthent" +
      "icated\030\003 \001(\010R\rauthenticated\022%\n\016dataservi" +
      "ce_id\030\004 \001(\tR\rdataserviceId\022\'\n\017dataservic" +
      "e_url\030\005 \001(\tR\016dataserviceUrl\"\274\001\n\023GetCatal" +
      "ogueRequest\022a\n\020query_parameters\030\001 \003(\01326." +
      "dsp.v1alpha2.GetCatalogueRequest.QueryPa" +
      "rametersEntryR\017queryParameters\032B\n\024QueryP" +
      "arametersEntry\022\020\n\003key\030\001 \001(\tR\003key\022\024\n\005valu" +
      "e\030\002 \001(\tR\005value:\0028\001\"I\n\024GetCatalogueRespon" +
      "se\0221\n\010datasets\030\001 \003(\0132\025.dsp.v1alpha2.Data" +
      "setR\010datasets\"2\n\021GetDatasetRequest\022\035\n\nda" +
      "taset_id\030\001 \001(\tR\tdatasetId\"E\n\022GetDatasetR" +
      "esponse\022/\n\007dataset\030\001 \001(\0132\025.dsp.v1alpha2." +
      "DatasetR\007dataset\"U\n\025PublishDatasetReques" +
      "t\022\035\n\ndataset_id\030\001 \001(\tR\tdatasetId\022\035\n\npubl" +
      "ish_id\030\002 \001(\tR\tpublishId\"V\n\026PublishDatase" +
      "tResponse\022<\n\014publish_info\030\001 \001(\0132\031.dsp.v1" +
      "alpha2.PublishInfoR\013publishInfo\"8\n\027Unpub" +
      "lishDatasetRequest\022\035\n\npublish_id\030\001 \001(\tR\t" +
      "publishId\"4\n\030UnpublishDatasetResponse\022\030\n" +
      "\007success\030\001 \001(\010R\007success\"?\n\036SuspendPublis" +
      "hedDatasetRequest\022\035\n\npublish_id\030\001 \001(\tR\tp" +
      "ublishId\"!\n\037SuspendPublishedDatasetRespo" +
      "nse\"A\n UnsuspendPublishedDatasetRequest\022" +
      "\035\n\npublish_id\030\001 \001(\tR\tpublishId\"#\n!Unsusp" +
      "endPublishedDatasetResponse2\274\005\n\017Provider" +
      "Service\022?\n\004Ping\022\031.dsp.v1alpha2.PingReque" +
      "st\032\032.dsp.v1alpha2.PingResponse\"\000\022W\n\014GetC" +
      "atalogue\022!.dsp.v1alpha2.GetCatalogueRequ" +
      "est\032\".dsp.v1alpha2.GetCatalogueResponse\"" +
      "\000\022Q\n\nGetDataset\022\037.dsp.v1alpha2.GetDatase" +
      "tRequest\032 .dsp.v1alpha2.GetDatasetRespon" +
      "se\"\000\022]\n\016PublishDataset\022#.dsp.v1alpha2.Pu" +
      "blishDatasetRequest\032$.dsp.v1alpha2.Publi" +
      "shDatasetResponse\"\000\022c\n\020UnpublishDataset\022" +
      "%.dsp.v1alpha2.UnpublishDatasetRequest\032&" +
      ".dsp.v1alpha2.UnpublishDatasetResponse\"\000" +
      "\022x\n\027SuspendPublishedDataset\022,.dsp.v1alph" +
      "a2.SuspendPublishedDatasetRequest\032-.dsp." +
      "v1alpha2.SuspendPublishedDatasetResponse" +
      "\"\000\022~\n\031UnsuspendPublishedDataset\022..dsp.v1" +
      "alpha2.UnsuspendPublishedDatasetRequest\032" +
      "/.dsp.v1alpha2.UnsuspendPublishedDataset" +
      "Response\"\000B\251\001\n\020com.dsp.v1alpha2B\rProvide" +
      "rProtoP\001Z5github.com/bufbuild/buf-tour/d" +
      "sp/v1alpha2;dspv1alpha2\242\002\003DXX\252\002\014Dsp.V1al" +
      "pha2\312\002\014Dsp\\V1alpha2\342\002\030Dsp\\V1alpha2\\GPBMe" +
      "tadata\352\002\rDsp::V1alpha2b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          TypesProto.getDescriptor(),
        });
    internal_static_dsp_v1alpha2_PingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dsp_v1alpha2_PingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_PingRequest_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_PingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_dsp_v1alpha2_PingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_PingResponse_descriptor,
        new String[] { "ProviderName", "ProviderDescription", "Authenticated", "DataserviceId", "DataserviceUrl", });
    internal_static_dsp_v1alpha2_GetCatalogueRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_dsp_v1alpha2_GetCatalogueRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_GetCatalogueRequest_descriptor,
        new String[] { "QueryParameters", });
    internal_static_dsp_v1alpha2_GetCatalogueRequest_QueryParametersEntry_descriptor =
      internal_static_dsp_v1alpha2_GetCatalogueRequest_descriptor.getNestedTypes().get(0);
    internal_static_dsp_v1alpha2_GetCatalogueRequest_QueryParametersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_GetCatalogueRequest_QueryParametersEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_dsp_v1alpha2_GetCatalogueResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_dsp_v1alpha2_GetCatalogueResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_GetCatalogueResponse_descriptor,
        new String[] { "Datasets", });
    internal_static_dsp_v1alpha2_GetDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_dsp_v1alpha2_GetDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_GetDatasetRequest_descriptor,
        new String[] { "DatasetId", });
    internal_static_dsp_v1alpha2_GetDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_dsp_v1alpha2_GetDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_GetDatasetResponse_descriptor,
        new String[] { "Dataset", });
    internal_static_dsp_v1alpha2_PublishDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_dsp_v1alpha2_PublishDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_PublishDatasetRequest_descriptor,
        new String[] { "DatasetId", "PublishId", });
    internal_static_dsp_v1alpha2_PublishDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_dsp_v1alpha2_PublishDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_PublishDatasetResponse_descriptor,
        new String[] { "PublishInfo", });
    internal_static_dsp_v1alpha2_UnpublishDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_dsp_v1alpha2_UnpublishDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_UnpublishDatasetRequest_descriptor,
        new String[] { "PublishId", });
    internal_static_dsp_v1alpha2_UnpublishDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_dsp_v1alpha2_UnpublishDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_UnpublishDatasetResponse_descriptor,
        new String[] { "Success", });
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_SuspendPublishedDatasetRequest_descriptor,
        new String[] { "PublishId", });
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_dsp_v1alpha2_SuspendPublishedDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_SuspendPublishedDatasetResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetRequest_descriptor,
        new String[] { "PublishId", });
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_UnsuspendPublishedDatasetResponse_descriptor,
        new String[] { });
    TypesProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
