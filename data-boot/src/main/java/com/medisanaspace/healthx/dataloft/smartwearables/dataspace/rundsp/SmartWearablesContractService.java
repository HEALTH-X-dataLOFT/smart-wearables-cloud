package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.rundsp;

import com.dsp.v1alpha2.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class SmartWearablesContractService extends ContractServiceGrpc.ContractServiceImplBase {

    @Override
    public void configure(ContractServiceConfigureRequest request, StreamObserver<ContractServiceConfigureResponse> responseObserver) {
        log.info("Received gRPC request -> configure");
        super.configure(request, responseObserver);
    }

    @Override
    public void requestReceived(ContractServiceRequestReceivedRequest request, StreamObserver<ContractServiceRequestReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> requestReceived");
        super.requestReceived(request, responseObserver);
    }

    @Override
    public void offerReceived(ContractServiceOfferReceivedRequest request, StreamObserver<ContractServiceOfferReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> offerReceived");
        super.offerReceived(request, responseObserver);
    }

    @Override
    public void acceptedReceived(ContractServiceAcceptedReceivedRequest request, StreamObserver<ContractServiceAcceptedReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> acceptedReceived");
        super.acceptedReceived(request, responseObserver);
    }

    @Override
    public void agreementReceived(ContractServiceAgreementReceivedRequest request, StreamObserver<ContractServiceAgreementReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> agreementReceived");
        super.agreementReceived(request, responseObserver);
    }

    @Override
    public void verificationReceived(ContractServiceVerificationReceivedRequest request, StreamObserver<ContractServiceVerificationReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> verificationReceived");
        super.verificationReceived(request, responseObserver);
    }

    @Override
    public void finalizationReceived(ContractServiceFinalizationReceivedRequest request, StreamObserver<ContractServiceFinalizationReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> finalizationReceived");
        super.finalizationReceived(request, responseObserver);
    }

    @Override
    public void terminationReceived(ContractServiceTerminationReceivedRequest request, StreamObserver<ContractServiceTerminationReceivedResponse> responseObserver) {
        log.info("Received gRPC request -> terminationReceived");
        super.terminationReceived(request, responseObserver);
    }
}
