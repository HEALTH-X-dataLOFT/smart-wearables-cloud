// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/contract.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

public final class ContractProto {
  private ContractProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceConfigureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceConfigureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceConfigureResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceConfigureResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceRequestReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceRequestReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceOfferReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceOfferReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\033dsp/v1alpha2/contract.proto\022\014dsp.v1alp" +
      "ha2\"}\n\037ContractServiceConfigureRequest\022+" +
      "\n\021connector_address\030\001 \001(\tR\020connectorAddr" +
      "ess\022-\n\022verification_token\030\002 \001(\tR\021verific" +
      "ationToken\"\"\n ContractServiceConfigureRe" +
      "sponse\"O\n%ContractServiceRequestReceived" +
      "Request\022\020\n\003pid\030\001 \001(\tR\003pid\022\024\n\005offer\030\002 \001(\t" +
      "R\005offer\"(\n&ContractServiceRequestReceive" +
      "dResponse\"M\n#ContractServiceOfferReceive" +
      "dRequest\022\020\n\003pid\030\001 \001(\tR\003pid\022\024\n\005offer\030\002 \001(" +
      "\tR\005offer\"&\n$ContractServiceOfferReceived" +
      "Response\":\n&ContractServiceAcceptedRecei" +
      "vedRequest\022\020\n\003pid\030\001 \001(\tR\003pid\")\n\'Contract" +
      "ServiceAcceptedReceivedResponse\";\n\'Contr" +
      "actServiceAgreementReceivedRequest\022\020\n\003pi" +
      "d\030\001 \001(\tR\003pid\"*\n(ContractServiceAgreement" +
      "ReceivedResponse\">\n*ContractServiceVerif" +
      "icationReceivedRequest\022\020\n\003pid\030\001 \001(\tR\003pid" +
      "\"-\n+ContractServiceVerificationReceivedR" +
      "esponse\">\n*ContractServiceFinalizationRe" +
      "ceivedRequest\022\020\n\003pid\030\001 \001(\tR\003pid\"-\n+Contr" +
      "actServiceFinalizationReceivedResponse\"i" +
      "\n)ContractServiceTerminationReceivedRequ" +
      "est\022\020\n\003pid\030\001 \001(\tR\003pid\022\022\n\004code\030\002 \001(\tR\004cod" +
      "e\022\026\n\006reason\030\003 \003(\tR\006reason\",\n*ContractSer" +
      "viceTerminationReceivedResponse2\261\010\n\017Cont" +
      "ractService\022l\n\tConfigure\022-.dsp.v1alpha2." +
      "ContractServiceConfigureRequest\032..dsp.v1" +
      "alpha2.ContractServiceConfigureResponse\"" +
      "\000\022~\n\017RequestReceived\0223.dsp.v1alpha2.Cont" +
      "ractServiceRequestReceivedRequest\0324.dsp." +
      "v1alpha2.ContractServiceRequestReceivedR" +
      "esponse\"\000\022x\n\rOfferReceived\0221.dsp.v1alpha" +
      "2.ContractServiceOfferReceivedRequest\0322." +
      "dsp.v1alpha2.ContractServiceOfferReceive" +
      "dResponse\"\000\022\201\001\n\020AcceptedReceived\0224.dsp.v" +
      "1alpha2.ContractServiceAcceptedReceivedR" +
      "equest\0325.dsp.v1alpha2.ContractServiceAcc" +
      "eptedReceivedResponse\"\000\022\204\001\n\021AgreementRec" +
      "eived\0225.dsp.v1alpha2.ContractServiceAgre" +
      "ementReceivedRequest\0326.dsp.v1alpha2.Cont" +
      "ractServiceAgreementReceivedResponse\"\000\022\215" +
      "\001\n\024VerificationReceived\0228.dsp.v1alpha2.C" +
      "ontractServiceVerificationReceivedReques" +
      "t\0329.dsp.v1alpha2.ContractServiceVerifica" +
      "tionReceivedResponse\"\000\022\215\001\n\024FinalizationR" +
      "eceived\0228.dsp.v1alpha2.ContractServiceFi" +
      "nalizationReceivedRequest\0329.dsp.v1alpha2" +
      ".ContractServiceFinalizationReceivedResp" +
      "onse\"\000\022\212\001\n\023TerminationReceived\0227.dsp.v1a" +
      "lpha2.ContractServiceTerminationReceived" +
      "Request\0328.dsp.v1alpha2.ContractServiceTe" +
      "rminationReceivedResponse\"\000B\251\001\n\020com.dsp." +
      "v1alpha2B\rContractProtoP\001Z5github.com/bu" +
      "fbuild/buf-tour/dsp/v1alpha2;dspv1alpha2" +
      "\242\002\003DXX\252\002\014Dsp.V1alpha2\312\002\014Dsp\\V1alpha2\342\002\030D" +
      "sp\\V1alpha2\\GPBMetadata\352\002\rDsp::V1alpha2b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_dsp_v1alpha2_ContractServiceConfigureRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dsp_v1alpha2_ContractServiceConfigureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceConfigureRequest_descriptor,
        new String[] { "ConnectorAddress", "VerificationToken", });
    internal_static_dsp_v1alpha2_ContractServiceConfigureResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_dsp_v1alpha2_ContractServiceConfigureResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceConfigureResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceRequestReceivedRequest_descriptor,
        new String[] { "Pid", "Offer", });
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_dsp_v1alpha2_ContractServiceRequestReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceRequestReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceOfferReceivedRequest_descriptor,
        new String[] { "Pid", "Offer", });
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_dsp_v1alpha2_ContractServiceOfferReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceOfferReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedRequest_descriptor,
        new String[] { "Pid", });
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceAcceptedReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedRequest_descriptor,
        new String[] { "Pid", });
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceAgreementReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedRequest_descriptor,
        new String[] { "Pid", });
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceVerificationReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedRequest_descriptor,
        new String[] { "Pid", });
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceFinalizationReceivedResponse_descriptor,
        new String[] { });
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedRequest_descriptor,
        new String[] { "Pid", "Code", "Reason", });
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dsp_v1alpha2_ContractServiceTerminationReceivedResponse_descriptor,
        new String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
