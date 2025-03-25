package com.dsp.v1alpha2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
 * negotiation steps.
 * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
 * the caller can be verified by the service.
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: dsp/v1alpha2/contract.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContractServiceGrpc {

  private ContractServiceGrpc() {}

  public static final String SERVICE_NAME = "dsp.v1alpha2.ContractService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ContractServiceConfigureRequest,
      ContractServiceConfigureResponse> getConfigureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Configure",
      requestType = ContractServiceConfigureRequest.class,
      responseType = ContractServiceConfigureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceConfigureRequest,
      ContractServiceConfigureResponse> getConfigureMethod() {
    io.grpc.MethodDescriptor<ContractServiceConfigureRequest, ContractServiceConfigureResponse> getConfigureMethod;
    if ((getConfigureMethod = ContractServiceGrpc.getConfigureMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getConfigureMethod = ContractServiceGrpc.getConfigureMethod) == null) {
          ContractServiceGrpc.getConfigureMethod = getConfigureMethod =
              io.grpc.MethodDescriptor.<ContractServiceConfigureRequest, ContractServiceConfigureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Configure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceConfigureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceConfigureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("Configure"))
              .build();
        }
      }
    }
    return getConfigureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceRequestReceivedRequest,
      ContractServiceRequestReceivedResponse> getRequestReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestReceived",
      requestType = ContractServiceRequestReceivedRequest.class,
      responseType = ContractServiceRequestReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceRequestReceivedRequest,
      ContractServiceRequestReceivedResponse> getRequestReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceRequestReceivedRequest, ContractServiceRequestReceivedResponse> getRequestReceivedMethod;
    if ((getRequestReceivedMethod = ContractServiceGrpc.getRequestReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getRequestReceivedMethod = ContractServiceGrpc.getRequestReceivedMethod) == null) {
          ContractServiceGrpc.getRequestReceivedMethod = getRequestReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceRequestReceivedRequest, ContractServiceRequestReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceRequestReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceRequestReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("RequestReceived"))
              .build();
        }
      }
    }
    return getRequestReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceOfferReceivedRequest,
      ContractServiceOfferReceivedResponse> getOfferReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OfferReceived",
      requestType = ContractServiceOfferReceivedRequest.class,
      responseType = ContractServiceOfferReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceOfferReceivedRequest,
      ContractServiceOfferReceivedResponse> getOfferReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceOfferReceivedRequest, ContractServiceOfferReceivedResponse> getOfferReceivedMethod;
    if ((getOfferReceivedMethod = ContractServiceGrpc.getOfferReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getOfferReceivedMethod = ContractServiceGrpc.getOfferReceivedMethod) == null) {
          ContractServiceGrpc.getOfferReceivedMethod = getOfferReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceOfferReceivedRequest, ContractServiceOfferReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OfferReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceOfferReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceOfferReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("OfferReceived"))
              .build();
        }
      }
    }
    return getOfferReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceAcceptedReceivedRequest,
      ContractServiceAcceptedReceivedResponse> getAcceptedReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptedReceived",
      requestType = ContractServiceAcceptedReceivedRequest.class,
      responseType = ContractServiceAcceptedReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceAcceptedReceivedRequest,
      ContractServiceAcceptedReceivedResponse> getAcceptedReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceAcceptedReceivedRequest, ContractServiceAcceptedReceivedResponse> getAcceptedReceivedMethod;
    if ((getAcceptedReceivedMethod = ContractServiceGrpc.getAcceptedReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getAcceptedReceivedMethod = ContractServiceGrpc.getAcceptedReceivedMethod) == null) {
          ContractServiceGrpc.getAcceptedReceivedMethod = getAcceptedReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceAcceptedReceivedRequest, ContractServiceAcceptedReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptedReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceAcceptedReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceAcceptedReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("AcceptedReceived"))
              .build();
        }
      }
    }
    return getAcceptedReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceAgreementReceivedRequest,
      ContractServiceAgreementReceivedResponse> getAgreementReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AgreementReceived",
      requestType = ContractServiceAgreementReceivedRequest.class,
      responseType = ContractServiceAgreementReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceAgreementReceivedRequest,
      ContractServiceAgreementReceivedResponse> getAgreementReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceAgreementReceivedRequest, ContractServiceAgreementReceivedResponse> getAgreementReceivedMethod;
    if ((getAgreementReceivedMethod = ContractServiceGrpc.getAgreementReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getAgreementReceivedMethod = ContractServiceGrpc.getAgreementReceivedMethod) == null) {
          ContractServiceGrpc.getAgreementReceivedMethod = getAgreementReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceAgreementReceivedRequest, ContractServiceAgreementReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AgreementReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceAgreementReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceAgreementReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("AgreementReceived"))
              .build();
        }
      }
    }
    return getAgreementReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceVerificationReceivedRequest,
      ContractServiceVerificationReceivedResponse> getVerificationReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerificationReceived",
      requestType = ContractServiceVerificationReceivedRequest.class,
      responseType = ContractServiceVerificationReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceVerificationReceivedRequest,
      ContractServiceVerificationReceivedResponse> getVerificationReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceVerificationReceivedRequest, ContractServiceVerificationReceivedResponse> getVerificationReceivedMethod;
    if ((getVerificationReceivedMethod = ContractServiceGrpc.getVerificationReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getVerificationReceivedMethod = ContractServiceGrpc.getVerificationReceivedMethod) == null) {
          ContractServiceGrpc.getVerificationReceivedMethod = getVerificationReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceVerificationReceivedRequest, ContractServiceVerificationReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerificationReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceVerificationReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceVerificationReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("VerificationReceived"))
              .build();
        }
      }
    }
    return getVerificationReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceFinalizationReceivedRequest,
      ContractServiceFinalizationReceivedResponse> getFinalizationReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FinalizationReceived",
      requestType = ContractServiceFinalizationReceivedRequest.class,
      responseType = ContractServiceFinalizationReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceFinalizationReceivedRequest,
      ContractServiceFinalizationReceivedResponse> getFinalizationReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceFinalizationReceivedRequest, ContractServiceFinalizationReceivedResponse> getFinalizationReceivedMethod;
    if ((getFinalizationReceivedMethod = ContractServiceGrpc.getFinalizationReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getFinalizationReceivedMethod = ContractServiceGrpc.getFinalizationReceivedMethod) == null) {
          ContractServiceGrpc.getFinalizationReceivedMethod = getFinalizationReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceFinalizationReceivedRequest, ContractServiceFinalizationReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FinalizationReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceFinalizationReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceFinalizationReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("FinalizationReceived"))
              .build();
        }
      }
    }
    return getFinalizationReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ContractServiceTerminationReceivedRequest,
      ContractServiceTerminationReceivedResponse> getTerminationReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TerminationReceived",
      requestType = ContractServiceTerminationReceivedRequest.class,
      responseType = ContractServiceTerminationReceivedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ContractServiceTerminationReceivedRequest,
      ContractServiceTerminationReceivedResponse> getTerminationReceivedMethod() {
    io.grpc.MethodDescriptor<ContractServiceTerminationReceivedRequest, ContractServiceTerminationReceivedResponse> getTerminationReceivedMethod;
    if ((getTerminationReceivedMethod = ContractServiceGrpc.getTerminationReceivedMethod) == null) {
      synchronized (ContractServiceGrpc.class) {
        if ((getTerminationReceivedMethod = ContractServiceGrpc.getTerminationReceivedMethod) == null) {
          ContractServiceGrpc.getTerminationReceivedMethod = getTerminationReceivedMethod =
              io.grpc.MethodDescriptor.<ContractServiceTerminationReceivedRequest, ContractServiceTerminationReceivedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TerminationReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceTerminationReceivedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ContractServiceTerminationReceivedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ContractServiceMethodDescriptorSupplier("TerminationReceived"))
              .build();
        }
      }
    }
    return getTerminationReceivedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContractServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractServiceStub>() {
        @Override
        public ContractServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractServiceStub(channel, callOptions);
        }
      };
    return ContractServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContractServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractServiceBlockingStub>() {
        @Override
        public ContractServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractServiceBlockingStub(channel, callOptions);
        }
      };
    return ContractServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContractServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractServiceFutureStub>() {
        @Override
        public ContractServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractServiceFutureStub(channel, callOptions);
        }
      };
    return ContractServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
   * negotiation steps.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
   * the caller can be verified by the service.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Configure sets some callback configuration parameters.
     * </pre>
     */
    default void configure(ContractServiceConfigureRequest request,
                           io.grpc.stub.StreamObserver<ContractServiceConfigureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConfigureMethod(), responseObserver);
    }

    /**
     * <pre>
     * RequestReceived is called when RUN-DSP receives a ContractRequestMessage.
     * </pre>
     */
    default void requestReceived(ContractServiceRequestReceivedRequest request,
                                 io.grpc.stub.StreamObserver<ContractServiceRequestReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * OfferReceived is called when RUN-DSP receives a ContractOfferMessage.
     * </pre>
     */
    default void offerReceived(ContractServiceOfferReceivedRequest request,
                               io.grpc.stub.StreamObserver<ContractServiceOfferReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOfferReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * AcceptedReceived is called when RUN-DSP receives an Accepted event message.
     * </pre>
     */
    default void acceptedReceived(ContractServiceAcceptedReceivedRequest request,
                                  io.grpc.stub.StreamObserver<ContractServiceAcceptedReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptedReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * AgreementReceived is called when RUN-DSP receives a ContractAgreementMessage.
     * </pre>
     */
    default void agreementReceived(ContractServiceAgreementReceivedRequest request,
                                   io.grpc.stub.StreamObserver<ContractServiceAgreementReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAgreementReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * VerificationReceived is called when RUN-DSP receives a ContractVerificationMessage.
     * </pre>
     */
    default void verificationReceived(ContractServiceVerificationReceivedRequest request,
                                      io.grpc.stub.StreamObserver<ContractServiceVerificationReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerificationReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * FinalizationReceived is called when RUN-DSP receives a Finalized event message.
     * </pre>
     */
    default void finalizationReceived(ContractServiceFinalizationReceivedRequest request,
                                      io.grpc.stub.StreamObserver<ContractServiceFinalizationReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFinalizationReceivedMethod(), responseObserver);
    }

    /**
     * <pre>
     * TerminationReceived is called when RUN-DSP receives a ContractTerminationMessage
     * </pre>
     */
    default void terminationReceived(ContractServiceTerminationReceivedRequest request,
                                     io.grpc.stub.StreamObserver<ContractServiceTerminationReceivedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTerminationReceivedMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ContractService.
   * <pre>
   * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
   * negotiation steps.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
   * the caller can be verified by the service.
   * </pre>
   */
  public static abstract class ContractServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return ContractServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContractService.
   * <pre>
   * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
   * negotiation steps.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
   * the caller can be verified by the service.
   * </pre>
   */
  public static final class ContractServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ContractServiceStub> {
    private ContractServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContractServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Configure sets some callback configuration parameters.
     * </pre>
     */
    public void configure(ContractServiceConfigureRequest request,
                          io.grpc.stub.StreamObserver<ContractServiceConfigureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConfigureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RequestReceived is called when RUN-DSP receives a ContractRequestMessage.
     * </pre>
     */
    public void requestReceived(ContractServiceRequestReceivedRequest request,
                                io.grpc.stub.StreamObserver<ContractServiceRequestReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * OfferReceived is called when RUN-DSP receives a ContractOfferMessage.
     * </pre>
     */
    public void offerReceived(ContractServiceOfferReceivedRequest request,
                              io.grpc.stub.StreamObserver<ContractServiceOfferReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOfferReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * AcceptedReceived is called when RUN-DSP receives an Accepted event message.
     * </pre>
     */
    public void acceptedReceived(ContractServiceAcceptedReceivedRequest request,
                                 io.grpc.stub.StreamObserver<ContractServiceAcceptedReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptedReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * AgreementReceived is called when RUN-DSP receives a ContractAgreementMessage.
     * </pre>
     */
    public void agreementReceived(ContractServiceAgreementReceivedRequest request,
                                  io.grpc.stub.StreamObserver<ContractServiceAgreementReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAgreementReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * VerificationReceived is called when RUN-DSP receives a ContractVerificationMessage.
     * </pre>
     */
    public void verificationReceived(ContractServiceVerificationReceivedRequest request,
                                     io.grpc.stub.StreamObserver<ContractServiceVerificationReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerificationReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * FinalizationReceived is called when RUN-DSP receives a Finalized event message.
     * </pre>
     */
    public void finalizationReceived(ContractServiceFinalizationReceivedRequest request,
                                     io.grpc.stub.StreamObserver<ContractServiceFinalizationReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFinalizationReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * TerminationReceived is called when RUN-DSP receives a ContractTerminationMessage
     * </pre>
     */
    public void terminationReceived(ContractServiceTerminationReceivedRequest request,
                                    io.grpc.stub.StreamObserver<ContractServiceTerminationReceivedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTerminationReceivedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContractService.
   * <pre>
   * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
   * negotiation steps.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
   * the caller can be verified by the service.
   * </pre>
   */
  public static final class ContractServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContractServiceBlockingStub> {
    private ContractServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContractServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Configure sets some callback configuration parameters.
     * </pre>
     */
    public ContractServiceConfigureResponse configure(ContractServiceConfigureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConfigureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RequestReceived is called when RUN-DSP receives a ContractRequestMessage.
     * </pre>
     */
    public ContractServiceRequestReceivedResponse requestReceived(ContractServiceRequestReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * OfferReceived is called when RUN-DSP receives a ContractOfferMessage.
     * </pre>
     */
    public ContractServiceOfferReceivedResponse offerReceived(ContractServiceOfferReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOfferReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * AcceptedReceived is called when RUN-DSP receives an Accepted event message.
     * </pre>
     */
    public ContractServiceAcceptedReceivedResponse acceptedReceived(ContractServiceAcceptedReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptedReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * AgreementReceived is called when RUN-DSP receives a ContractAgreementMessage.
     * </pre>
     */
    public ContractServiceAgreementReceivedResponse agreementReceived(ContractServiceAgreementReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAgreementReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * VerificationReceived is called when RUN-DSP receives a ContractVerificationMessage.
     * </pre>
     */
    public ContractServiceVerificationReceivedResponse verificationReceived(ContractServiceVerificationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerificationReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * FinalizationReceived is called when RUN-DSP receives a Finalized event message.
     * </pre>
     */
    public ContractServiceFinalizationReceivedResponse finalizationReceived(ContractServiceFinalizationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinalizationReceivedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * TerminationReceived is called when RUN-DSP receives a ContractTerminationMessage
     * </pre>
     */
    public ContractServiceTerminationReceivedResponse terminationReceived(ContractServiceTerminationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTerminationReceivedMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ContractService.
   * <pre>
   * The ContractService allows RUN-DSP to call an external service to approve/terminate contract
   * negotiation steps.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header so that
   * the caller can be verified by the service.
   * </pre>
   */
  public static final class ContractServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContractServiceFutureStub> {
    private ContractServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ContractServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Configure sets some callback configuration parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceConfigureResponse> configure(
        ContractServiceConfigureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConfigureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RequestReceived is called when RUN-DSP receives a ContractRequestMessage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceRequestReceivedResponse> requestReceived(
        ContractServiceRequestReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * OfferReceived is called when RUN-DSP receives a ContractOfferMessage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceOfferReceivedResponse> offerReceived(
        ContractServiceOfferReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOfferReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * AcceptedReceived is called when RUN-DSP receives an Accepted event message.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceAcceptedReceivedResponse> acceptedReceived(
        ContractServiceAcceptedReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptedReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * AgreementReceived is called when RUN-DSP receives a ContractAgreementMessage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceAgreementReceivedResponse> agreementReceived(
        ContractServiceAgreementReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAgreementReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * VerificationReceived is called when RUN-DSP receives a ContractVerificationMessage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceVerificationReceivedResponse> verificationReceived(
        ContractServiceVerificationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerificationReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * FinalizationReceived is called when RUN-DSP receives a Finalized event message.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceFinalizationReceivedResponse> finalizationReceived(
        ContractServiceFinalizationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFinalizationReceivedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * TerminationReceived is called when RUN-DSP receives a ContractTerminationMessage
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ContractServiceTerminationReceivedResponse> terminationReceived(
        ContractServiceTerminationReceivedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTerminationReceivedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONFIGURE = 0;
  private static final int METHODID_REQUEST_RECEIVED = 1;
  private static final int METHODID_OFFER_RECEIVED = 2;
  private static final int METHODID_ACCEPTED_RECEIVED = 3;
  private static final int METHODID_AGREEMENT_RECEIVED = 4;
  private static final int METHODID_VERIFICATION_RECEIVED = 5;
  private static final int METHODID_FINALIZATION_RECEIVED = 6;
  private static final int METHODID_TERMINATION_RECEIVED = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONFIGURE:
          serviceImpl.configure((ContractServiceConfigureRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceConfigureResponse>) responseObserver);
          break;
        case METHODID_REQUEST_RECEIVED:
          serviceImpl.requestReceived((ContractServiceRequestReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceRequestReceivedResponse>) responseObserver);
          break;
        case METHODID_OFFER_RECEIVED:
          serviceImpl.offerReceived((ContractServiceOfferReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceOfferReceivedResponse>) responseObserver);
          break;
        case METHODID_ACCEPTED_RECEIVED:
          serviceImpl.acceptedReceived((ContractServiceAcceptedReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceAcceptedReceivedResponse>) responseObserver);
          break;
        case METHODID_AGREEMENT_RECEIVED:
          serviceImpl.agreementReceived((ContractServiceAgreementReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceAgreementReceivedResponse>) responseObserver);
          break;
        case METHODID_VERIFICATION_RECEIVED:
          serviceImpl.verificationReceived((ContractServiceVerificationReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceVerificationReceivedResponse>) responseObserver);
          break;
        case METHODID_FINALIZATION_RECEIVED:
          serviceImpl.finalizationReceived((ContractServiceFinalizationReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceFinalizationReceivedResponse>) responseObserver);
          break;
        case METHODID_TERMINATION_RECEIVED:
          serviceImpl.terminationReceived((ContractServiceTerminationReceivedRequest) request,
              (io.grpc.stub.StreamObserver<ContractServiceTerminationReceivedResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getConfigureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceConfigureRequest,
              ContractServiceConfigureResponse>(
                service, METHODID_CONFIGURE)))
        .addMethod(
          getRequestReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceRequestReceivedRequest,
              ContractServiceRequestReceivedResponse>(
                service, METHODID_REQUEST_RECEIVED)))
        .addMethod(
          getOfferReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceOfferReceivedRequest,
              ContractServiceOfferReceivedResponse>(
                service, METHODID_OFFER_RECEIVED)))
        .addMethod(
          getAcceptedReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceAcceptedReceivedRequest,
              ContractServiceAcceptedReceivedResponse>(
                service, METHODID_ACCEPTED_RECEIVED)))
        .addMethod(
          getAgreementReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceAgreementReceivedRequest,
              ContractServiceAgreementReceivedResponse>(
                service, METHODID_AGREEMENT_RECEIVED)))
        .addMethod(
          getVerificationReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceVerificationReceivedRequest,
              ContractServiceVerificationReceivedResponse>(
                service, METHODID_VERIFICATION_RECEIVED)))
        .addMethod(
          getFinalizationReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceFinalizationReceivedRequest,
              ContractServiceFinalizationReceivedResponse>(
                service, METHODID_FINALIZATION_RECEIVED)))
        .addMethod(
          getTerminationReceivedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ContractServiceTerminationReceivedRequest,
              ContractServiceTerminationReceivedResponse>(
                service, METHODID_TERMINATION_RECEIVED)))
        .build();
  }

  private static abstract class ContractServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContractServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ContractProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContractService");
    }
  }

  private static final class ContractServiceFileDescriptorSupplier
      extends ContractServiceBaseDescriptorSupplier {
    ContractServiceFileDescriptorSupplier() {}
  }

  private static final class ContractServiceMethodDescriptorSupplier
      extends ContractServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContractServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ContractServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContractServiceFileDescriptorSupplier())
              .addMethod(getConfigureMethod())
              .addMethod(getRequestReceivedMethod())
              .addMethod(getOfferReceivedMethod())
              .addMethod(getAcceptedReceivedMethod())
              .addMethod(getAgreementReceivedMethod())
              .addMethod(getVerificationReceivedMethod())
              .addMethod(getFinalizationReceivedMethod())
              .addMethod(getTerminationReceivedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
