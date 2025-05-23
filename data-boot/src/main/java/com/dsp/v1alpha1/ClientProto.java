// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha1/client.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha1;

public final class ClientProto {
  private ClientProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_ClientServicePingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_ClientServicePingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_ClientServicePingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_ClientServicePingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_QueryParametersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_QueryParametersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderCatalogueResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderCatalogueResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderDatasetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderDatasetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderDatasetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderDatasetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferCompleteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferCompleteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferCompleteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferCompleteResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferCancelledRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferCancelledRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferCancelledResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferCancelledResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferSuspendRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferSuspendRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferSuspendResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferSuspendResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferResumeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferResumeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha1_SignalTransferResumeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha1_SignalTransferResumeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\031dsp/v1alpha1/client.proto\022\014dsp.v1alpha" +
      "1\032\030dsp/v1alpha1/types.proto\"\032\n\030ClientSer" +
      "vicePingRequest\"\033\n\031ClientServicePingResp" +
      "onse\"\357\001\n\033GetProviderCatalogueRequest\022!\n\014" +
      "provider_uri\030\001 \001(\tR\013providerUri\022i\n\020query" +
      "_parameters\030\002 \003(\0132>.dsp.v1alpha1.GetProv" +
      "iderCatalogueRequest.QueryParametersEntr" +
      "yR\017queryParameters\032B\n\024QueryParametersEnt" +
      "ry\022\020\n\003key\030\001 \001(\tR\003key\022\024\n\005value\030\002 \001(\tR\005val" +
      "ue:\0028\001\"Q\n\034GetProviderCatalogueResponse\0221" +
      "\n\010datasets\030\001 \003(\0132\025.dsp.v1alpha1.DatasetR" +
      "\010datasets\"]\n\031GetProviderDatasetRequest\022!" +
      "\n\014provider_url\030\001 \001(\tR\013providerUrl\022\035\n\ndat" +
      "aset_id\030\002 \001(\tR\tdatasetId\"p\n\032GetProviderD" +
      "atasetResponse\022!\n\014provider_url\030\001 \001(\tR\013pr" +
      "oviderUrl\022/\n\007dataset\030\002 \001(\0132\025.dsp.v1alpha" +
      "1.DatasetR\007dataset\"p\n,GetProviderDataset" +
      "DownloadInformationRequest\022!\n\014provider_u" +
      "rl\030\001 \001(\tR\013providerUrl\022\035\n\ndataset_id\030\002 \001(" +
      "\tR\tdatasetId\"\216\001\n-GetProviderDatasetDownl" +
      "oadInformationResponse\022<\n\014publish_info\030\001" +
      " \001(\0132\031.dsp.v1alpha1.PublishInfoR\013publish" +
      "Info\022\037\n\013transfer_id\030\002 \001(\tR\ntransferId\"@\n" +
      "\035SignalTransferCompleteRequest\022\037\n\013transf" +
      "er_id\030\001 \001(\tR\ntransferId\" \n\036SignalTransfe" +
      "rCompleteResponse\"A\n\036SignalTransferCance" +
      "lledRequest\022\037\n\013transfer_id\030\001 \001(\tR\ntransf" +
      "erId\"!\n\037SignalTransferCancelledResponse\"" +
      "?\n\034SignalTransferSuspendRequest\022\037\n\013trans" +
      "fer_id\030\001 \001(\tR\ntransferId\"\037\n\035SignalTransf" +
      "erSuspendResponse\">\n\033SignalTransferResum" +
      "eRequest\022\037\n\013transfer_id\030\001 \001(\tR\ntransferI" +
      "d\"\036\n\034SignalTransferResumeResponse2\301\007\n\rCl" +
      "ientService\022Y\n\004Ping\022&.dsp.v1alpha1.Clien" +
      "tServicePingRequest\032\'.dsp.v1alpha1.Clien" +
      "tServicePingResponse\"\000\022o\n\024GetProviderCat" +
      "alogue\022).dsp.v1alpha1.GetProviderCatalog" +
      "ueRequest\032*.dsp.v1alpha1.GetProviderCata" +
      "logueResponse\"\000\022i\n\022GetProviderDataset\022\'." +
      "dsp.v1alpha1.GetProviderDatasetRequest\032(" +
      ".dsp.v1alpha1.GetProviderDatasetResponse" +
      "\"\000\022\242\001\n%GetProviderDatasetDownloadInforma" +
      "tion\022:.dsp.v1alpha1.GetProviderDatasetDo" +
      "wnloadInformationRequest\032;.dsp.v1alpha1." +
      "GetProviderDatasetDownloadInformationRes" +
      "ponse\"\000\022u\n\026SignalTransferComplete\022+.dsp." +
      "v1alpha1.SignalTransferCompleteRequest\032," +
      ".dsp.v1alpha1.SignalTransferCompleteResp" +
      "onse\"\000\022x\n\027SignalTransferCancelled\022,.dsp." +
      "v1alpha1.SignalTransferCancelledRequest\032" +
      "-.dsp.v1alpha1.SignalTransferCancelledRe" +
      "sponse\"\000\022r\n\025SignalTransferSuspend\022*.dsp." +
      "v1alpha1.SignalTransferSuspendRequest\032+." +
      "dsp.v1alpha1.SignalTransferSuspendRespon" +
      "se\"\000\022o\n\024SignalTransferResume\022).dsp.v1alp" +
      "ha1.SignalTransferResumeRequest\032*.dsp.v1" +
      "alpha1.SignalTransferResumeResponse\"\000B\247\001" +
      "\n\020com.dsp.v1alpha1B\013ClientProtoP\001Z5githu" +
      "b.com/bufbuild/buf-tour/dsp/v1alpha1;dsp" +
      "v1alpha1\242\002\003DXX\252\002\014Dsp.V1alpha1\312\002\014Dsp\\V1al" +
      "pha1\342\002\030Dsp\\V1alpha1\\GPBMetadata\352\002\rDsp::V" +
      "1alpha1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
                TypesProto.getDescriptor(),
        });
    internal_static_dsp_v1alpha1_ClientServicePingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dsp_v1alpha1_ClientServicePingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_ClientServicePingRequest_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha1_ClientServicePingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_dsp_v1alpha1_ClientServicePingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_ClientServicePingResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_descriptor,
        new String[] { "ProviderUri", "QueryParameters", });
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_QueryParametersEntry_descriptor =
      internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_descriptor.getNestedTypes().get(0);
    internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_QueryParametersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderCatalogueRequest_QueryParametersEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_dsp_v1alpha1_GetProviderCatalogueResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_dsp_v1alpha1_GetProviderCatalogueResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderCatalogueResponse_descriptor,
        new String[] { "Datasets", });
    internal_static_dsp_v1alpha1_GetProviderDatasetRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_dsp_v1alpha1_GetProviderDatasetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderDatasetRequest_descriptor,
        new String[] { "ProviderUrl", "DatasetId", });
    internal_static_dsp_v1alpha1_GetProviderDatasetResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_dsp_v1alpha1_GetProviderDatasetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderDatasetResponse_descriptor,
        new String[] { "ProviderUrl", "Dataset", });
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationRequest_descriptor,
        new String[] { "ProviderUrl", "DatasetId", });
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_GetProviderDatasetDownloadInformationResponse_descriptor,
        new String[] { "PublishInfo", "TransferId", });
    internal_static_dsp_v1alpha1_SignalTransferCompleteRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_dsp_v1alpha1_SignalTransferCompleteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferCompleteRequest_descriptor,
        new String[] { "TransferId", });
    internal_static_dsp_v1alpha1_SignalTransferCompleteResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_dsp_v1alpha1_SignalTransferCompleteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferCompleteResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha1_SignalTransferCancelledRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_dsp_v1alpha1_SignalTransferCancelledRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferCancelledRequest_descriptor,
        new String[] { "TransferId", });
    internal_static_dsp_v1alpha1_SignalTransferCancelledResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_dsp_v1alpha1_SignalTransferCancelledResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferCancelledResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha1_SignalTransferSuspendRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_dsp_v1alpha1_SignalTransferSuspendRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferSuspendRequest_descriptor,
        new String[] { "TransferId", });
    internal_static_dsp_v1alpha1_SignalTransferSuspendResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_dsp_v1alpha1_SignalTransferSuspendResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferSuspendResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha1_SignalTransferResumeRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_dsp_v1alpha1_SignalTransferResumeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferResumeRequest_descriptor,
        new String[] { "TransferId", });
    internal_static_dsp_v1alpha1_SignalTransferResumeResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_dsp_v1alpha1_SignalTransferResumeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha1_SignalTransferResumeResponse_descriptor,
        new String[] { });
    TypesProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
