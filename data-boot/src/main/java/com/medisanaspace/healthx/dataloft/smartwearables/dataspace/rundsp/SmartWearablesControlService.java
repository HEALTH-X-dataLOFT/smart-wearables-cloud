package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import com.dsp.v1alpha2.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class SmartWearablesControlService extends ControlServiceGrpc.ControlServiceImplBase {
    @Override
    public void getProviderDatasetDownloadInformation(GetProviderDatasetDownloadInformationRequest request, StreamObserver<GetProviderDatasetDownloadInformationResponse> responseObserver) {
        log.info("Received gRPC request -> getProviderDatasetDownloadInformation");
        super.getProviderDatasetDownloadInformation(request, responseObserver);
    }

    @Override
    public void verifyConnection(VerifyConnectionRequest request, StreamObserver<VerifyConnectionResponse> responseObserver) {
        log.info("Received gRPC request -> verifyConnection");
        super.verifyConnection(request, responseObserver);
    }

    @Override
    public void getProviderCatalogue(GetProviderCatalogueRequest request, StreamObserver<GetProviderCatalogueResponse> responseObserver) {
        log.info("Received gRPC request -> getProviderCatalogue");
        super.getProviderCatalogue(request, responseObserver);
    }

    @Override
    public void getProviderDataset(GetProviderDatasetRequest request, StreamObserver<GetProviderDatasetResponse> responseObserver) {
        log.info("Received gRPC request -> getProviderDataset");
        super.getProviderDataset(request, responseObserver);
    }

    @Override
    public void contractRequest(ContractRequestRequest request, StreamObserver<ContractRequestResponse> responseObserver) {
        log.info("Received gRPC request -> contractRequest");
        super.contractRequest(request, responseObserver);
    }

    @Override
    public void contractOffer(ContractOfferRequest request, StreamObserver<ContractOfferResponse> responseObserver) {
        log.info("Received gRPC request -> contractOffer");
        super.contractOffer(request, responseObserver);
    }

    @Override
    public void contractAccept(ContractAcceptRequest request, StreamObserver<ContractAcceptResponse> responseObserver) {
        log.info("Received gRPC request -> contractAccept");
        super.contractAccept(request, responseObserver);
    }

    @Override
    public void contractAgree(ContractAgreeRequest request, StreamObserver<ContractAgreeResponse> responseObserver) {
        log.info("Received gRPC request -> contractAgree");
        super.contractAgree(request, responseObserver);
    }

    @Override
    public void contractVerify(ContractVerifyRequest request, StreamObserver<ContractVerifyResponse> responseObserver) {
        log.info("Received gRPC request -> contractVerify");
        super.contractVerify(request, responseObserver);
    }

    @Override
    public void contractFinalize(ContractFinalizeRequest request, StreamObserver<ContractFinalizeResponse> responseObserver) {
        log.info("Received gRPC request -> contractFinalize");
        super.contractFinalize(request, responseObserver);
    }

    @Override
    public void contractTerminate(ContractTerminateRequest request, StreamObserver<ContractTerminateResponse> responseObserver) {
        log.info("Received gRPC request -> contractTerminate");
        super.contractTerminate(request, responseObserver);
    }

    @Override
    public void signalTransferComplete(SignalTransferCompleteRequest request, StreamObserver<SignalTransferCompleteResponse> responseObserver) {
        log.info("Received gRPC request -> signalTransferComplete");
        super.signalTransferComplete(request, responseObserver);
    }

    @Override
    public void signalTransferCancelled(SignalTransferCancelledRequest request, StreamObserver<SignalTransferCancelledResponse> responseObserver) {
        log.info("Received gRPC request -> signalTransferCancelled");
        super.signalTransferCancelled(request, responseObserver);
    }

    @Override
    public void signalTransferSuspend(SignalTransferSuspendRequest request, StreamObserver<SignalTransferSuspendResponse> responseObserver) {
        log.info("Received gRPC request -> signalTransferSuspend");
        super.signalTransferSuspend(request, responseObserver);
    }

    @Override
    public void signalTransferResume(SignalTransferResumeRequest request, StreamObserver<SignalTransferResumeResponse> responseObserver) {
        log.info("Received gRPC request -> signalTransferResume");
        super.signalTransferResume(request, responseObserver);
    }
}
