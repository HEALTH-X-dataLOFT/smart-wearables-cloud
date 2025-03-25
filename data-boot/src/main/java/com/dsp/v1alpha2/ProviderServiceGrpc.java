package com.dsp.v1alpha2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The ProviderService is the expected grpc service that RUN-DSP will interface with.
 * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
 * The reason for this is that authorization will vary between dataspaces. Also, the provider
 * will want to show different data dependent on the credentials.
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: dsp/v1alpha2/provider.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProviderServiceGrpc {

  private ProviderServiceGrpc() {}

  public static final String SERVICE_NAME = "dsp.v1alpha2.ProviderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PingRequest,
      PingResponse> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = PingRequest.class,
      responseType = PingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PingRequest,
      PingResponse> getPingMethod() {
    io.grpc.MethodDescriptor<PingRequest, PingResponse> getPingMethod;
    if ((getPingMethod = ProviderServiceGrpc.getPingMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getPingMethod = ProviderServiceGrpc.getPingMethod) == null) {
          ProviderServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<PingRequest, PingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetCatalogueRequest,
      GetCatalogueResponse> getGetCatalogueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalogue",
      requestType = GetCatalogueRequest.class,
      responseType = GetCatalogueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetCatalogueRequest,
      GetCatalogueResponse> getGetCatalogueMethod() {
    io.grpc.MethodDescriptor<GetCatalogueRequest, GetCatalogueResponse> getGetCatalogueMethod;
    if ((getGetCatalogueMethod = ProviderServiceGrpc.getGetCatalogueMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getGetCatalogueMethod = ProviderServiceGrpc.getGetCatalogueMethod) == null) {
          ProviderServiceGrpc.getGetCatalogueMethod = getGetCatalogueMethod =
              io.grpc.MethodDescriptor.<GetCatalogueRequest, GetCatalogueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalogue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetCatalogueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetCatalogueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("GetCatalogue"))
              .build();
        }
      }
    }
    return getGetCatalogueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetDatasetRequest,
      GetDatasetResponse> getGetDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataset",
      requestType = GetDatasetRequest.class,
      responseType = GetDatasetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetDatasetRequest,
      GetDatasetResponse> getGetDatasetMethod() {
    io.grpc.MethodDescriptor<GetDatasetRequest, GetDatasetResponse> getGetDatasetMethod;
    if ((getGetDatasetMethod = ProviderServiceGrpc.getGetDatasetMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getGetDatasetMethod = ProviderServiceGrpc.getGetDatasetMethod) == null) {
          ProviderServiceGrpc.getGetDatasetMethod = getGetDatasetMethod =
              io.grpc.MethodDescriptor.<GetDatasetRequest, GetDatasetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetDatasetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("GetDataset"))
              .build();
        }
      }
    }
    return getGetDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<PublishDatasetRequest,
      PublishDatasetResponse> getPublishDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PublishDataset",
      requestType = PublishDatasetRequest.class,
      responseType = PublishDatasetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PublishDatasetRequest,
      PublishDatasetResponse> getPublishDatasetMethod() {
    io.grpc.MethodDescriptor<PublishDatasetRequest, PublishDatasetResponse> getPublishDatasetMethod;
    if ((getPublishDatasetMethod = ProviderServiceGrpc.getPublishDatasetMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getPublishDatasetMethod = ProviderServiceGrpc.getPublishDatasetMethod) == null) {
          ProviderServiceGrpc.getPublishDatasetMethod = getPublishDatasetMethod =
              io.grpc.MethodDescriptor.<PublishDatasetRequest, PublishDatasetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PublishDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PublishDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PublishDatasetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("PublishDataset"))
              .build();
        }
      }
    }
    return getPublishDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UnpublishDatasetRequest,
      UnpublishDatasetResponse> getUnpublishDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnpublishDataset",
      requestType = UnpublishDatasetRequest.class,
      responseType = UnpublishDatasetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UnpublishDatasetRequest,
      UnpublishDatasetResponse> getUnpublishDatasetMethod() {
    io.grpc.MethodDescriptor<UnpublishDatasetRequest, UnpublishDatasetResponse> getUnpublishDatasetMethod;
    if ((getUnpublishDatasetMethod = ProviderServiceGrpc.getUnpublishDatasetMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getUnpublishDatasetMethod = ProviderServiceGrpc.getUnpublishDatasetMethod) == null) {
          ProviderServiceGrpc.getUnpublishDatasetMethod = getUnpublishDatasetMethod =
              io.grpc.MethodDescriptor.<UnpublishDatasetRequest, UnpublishDatasetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnpublishDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UnpublishDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UnpublishDatasetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("UnpublishDataset"))
              .build();
        }
      }
    }
    return getUnpublishDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SuspendPublishedDatasetRequest,
      SuspendPublishedDatasetResponse> getSuspendPublishedDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuspendPublishedDataset",
      requestType = SuspendPublishedDatasetRequest.class,
      responseType = SuspendPublishedDatasetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SuspendPublishedDatasetRequest,
      SuspendPublishedDatasetResponse> getSuspendPublishedDatasetMethod() {
    io.grpc.MethodDescriptor<SuspendPublishedDatasetRequest, SuspendPublishedDatasetResponse> getSuspendPublishedDatasetMethod;
    if ((getSuspendPublishedDatasetMethod = ProviderServiceGrpc.getSuspendPublishedDatasetMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getSuspendPublishedDatasetMethod = ProviderServiceGrpc.getSuspendPublishedDatasetMethod) == null) {
          ProviderServiceGrpc.getSuspendPublishedDatasetMethod = getSuspendPublishedDatasetMethod =
              io.grpc.MethodDescriptor.<SuspendPublishedDatasetRequest, SuspendPublishedDatasetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuspendPublishedDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SuspendPublishedDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SuspendPublishedDatasetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("SuspendPublishedDataset"))
              .build();
        }
      }
    }
    return getSuspendPublishedDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UnsuspendPublishedDatasetRequest,
      UnsuspendPublishedDatasetResponse> getUnsuspendPublishedDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnsuspendPublishedDataset",
      requestType = UnsuspendPublishedDatasetRequest.class,
      responseType = UnsuspendPublishedDatasetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UnsuspendPublishedDatasetRequest,
      UnsuspendPublishedDatasetResponse> getUnsuspendPublishedDatasetMethod() {
    io.grpc.MethodDescriptor<UnsuspendPublishedDatasetRequest, UnsuspendPublishedDatasetResponse> getUnsuspendPublishedDatasetMethod;
    if ((getUnsuspendPublishedDatasetMethod = ProviderServiceGrpc.getUnsuspendPublishedDatasetMethod) == null) {
      synchronized (ProviderServiceGrpc.class) {
        if ((getUnsuspendPublishedDatasetMethod = ProviderServiceGrpc.getUnsuspendPublishedDatasetMethod) == null) {
          ProviderServiceGrpc.getUnsuspendPublishedDatasetMethod = getUnsuspendPublishedDatasetMethod =
              io.grpc.MethodDescriptor.<UnsuspendPublishedDatasetRequest, UnsuspendPublishedDatasetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnsuspendPublishedDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UnsuspendPublishedDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UnsuspendPublishedDatasetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProviderServiceMethodDescriptorSupplier("UnsuspendPublishedDataset"))
              .build();
        }
      }
    }
    return getUnsuspendPublishedDatasetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProviderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProviderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProviderServiceStub>() {
        @Override
        public ProviderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProviderServiceStub(channel, callOptions);
        }
      };
    return ProviderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProviderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProviderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProviderServiceBlockingStub>() {
        @Override
        public ProviderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProviderServiceBlockingStub(channel, callOptions);
        }
      };
    return ProviderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProviderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProviderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProviderServiceFutureStub>() {
        @Override
        public ProviderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProviderServiceFutureStub(channel, callOptions);
        }
      };
    return ProviderServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The ProviderService is the expected grpc service that RUN-DSP will interface with.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
   * The reason for this is that authorization will vary between dataspaces. Also, the provider
   * will want to show different data dependent on the credentials.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Ping is a request to test if the provider is working, and to test the auth information.
     * </pre>
     */
    default void ping(PingRequest request,
                      io.grpc.stub.StreamObserver<PingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the catalogue based on the query parameters and the authorization header.
     * </pre>
     */
    default void getCatalogue(GetCatalogueRequest request,
                              io.grpc.stub.StreamObserver<GetCatalogueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCatalogueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a single dataset.
     * </pre>
     */
    default void getDataset(GetDatasetRequest request,
                            io.grpc.stub.StreamObserver<GetDatasetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Publishes a dataset,
     * </pre>
     */
    default void publishDataset(PublishDatasetRequest request,
                                io.grpc.stub.StreamObserver<PublishDatasetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unpublishes a dataset.
     * </pre>
     */
    default void unpublishDataset(UnpublishDatasetRequest request,
                                  io.grpc.stub.StreamObserver<UnpublishDatasetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnpublishDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Asks provider to suspend a transfer
     * </pre>
     */
    default void suspendPublishedDataset(SuspendPublishedDatasetRequest request,
                                         io.grpc.stub.StreamObserver<SuspendPublishedDatasetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSuspendPublishedDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Asks provider to unsuspend (re-publish?) a transfer
     * </pre>
     */
    default void unsuspendPublishedDataset(UnsuspendPublishedDatasetRequest request,
                                           io.grpc.stub.StreamObserver<UnsuspendPublishedDatasetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsuspendPublishedDatasetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProviderService.
   * <pre>
   * The ProviderService is the expected grpc service that RUN-DSP will interface with.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
   * The reason for this is that authorization will vary between dataspaces. Also, the provider
   * will want to show different data dependent on the credentials.
   * </pre>
   */
  public static abstract class ProviderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProviderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProviderService.
   * <pre>
   * The ProviderService is the expected grpc service that RUN-DSP will interface with.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
   * The reason for this is that authorization will vary between dataspaces. Also, the provider
   * will want to show different data dependent on the credentials.
   * </pre>
   */
  public static final class ProviderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProviderServiceStub> {
    private ProviderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProviderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProviderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Ping is a request to test if the provider is working, and to test the auth information.
     * </pre>
     */
    public void ping(PingRequest request,
                     io.grpc.stub.StreamObserver<PingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the catalogue based on the query parameters and the authorization header.
     * </pre>
     */
    public void getCatalogue(GetCatalogueRequest request,
                             io.grpc.stub.StreamObserver<GetCatalogueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a single dataset.
     * </pre>
     */
    public void getDataset(GetDatasetRequest request,
                           io.grpc.stub.StreamObserver<GetDatasetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Publishes a dataset,
     * </pre>
     */
    public void publishDataset(PublishDatasetRequest request,
                               io.grpc.stub.StreamObserver<PublishDatasetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unpublishes a dataset.
     * </pre>
     */
    public void unpublishDataset(UnpublishDatasetRequest request,
                                 io.grpc.stub.StreamObserver<UnpublishDatasetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnpublishDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Asks provider to suspend a transfer
     * </pre>
     */
    public void suspendPublishedDataset(SuspendPublishedDatasetRequest request,
                                        io.grpc.stub.StreamObserver<SuspendPublishedDatasetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuspendPublishedDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Asks provider to unsuspend (re-publish?) a transfer
     * </pre>
     */
    public void unsuspendPublishedDataset(UnsuspendPublishedDatasetRequest request,
                                          io.grpc.stub.StreamObserver<UnsuspendPublishedDatasetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsuspendPublishedDatasetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProviderService.
   * <pre>
   * The ProviderService is the expected grpc service that RUN-DSP will interface with.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
   * The reason for this is that authorization will vary between dataspaces. Also, the provider
   * will want to show different data dependent on the credentials.
   * </pre>
   */
  public static final class ProviderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProviderServiceBlockingStub> {
    private ProviderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProviderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProviderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Ping is a request to test if the provider is working, and to test the auth information.
     * </pre>
     */
    public PingResponse ping(PingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the catalogue based on the query parameters and the authorization header.
     * </pre>
     */
    public GetCatalogueResponse getCatalogue(GetCatalogueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a single dataset.
     * </pre>
     */
    public GetDatasetResponse getDataset(GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Publishes a dataset,
     * </pre>
     */
    public PublishDatasetResponse publishDataset(PublishDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unpublishes a dataset.
     * </pre>
     */
    public UnpublishDatasetResponse unpublishDataset(UnpublishDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnpublishDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Asks provider to suspend a transfer
     * </pre>
     */
    public SuspendPublishedDatasetResponse suspendPublishedDataset(SuspendPublishedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuspendPublishedDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Asks provider to unsuspend (re-publish?) a transfer
     * </pre>
     */
    public UnsuspendPublishedDatasetResponse unsuspendPublishedDataset(UnsuspendPublishedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsuspendPublishedDatasetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProviderService.
   * <pre>
   * The ProviderService is the expected grpc service that RUN-DSP will interface with.
   * Outside of the defined calls, RUN-DSP will also forward the `authorization` header.
   * The reason for this is that authorization will vary between dataspaces. Also, the provider
   * will want to show different data dependent on the credentials.
   * </pre>
   */
  public static final class ProviderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProviderServiceFutureStub> {
    private ProviderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProviderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProviderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Ping is a request to test if the provider is working, and to test the auth information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<PingResponse> ping(
        PingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the catalogue based on the query parameters and the authorization header.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GetCatalogueResponse> getCatalogue(
        GetCatalogueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a single dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GetDatasetResponse> getDataset(
        GetDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Publishes a dataset,
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<PublishDatasetResponse> publishDataset(
        PublishDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unpublishes a dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<UnpublishDatasetResponse> unpublishDataset(
        UnpublishDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnpublishDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Asks provider to suspend a transfer
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<SuspendPublishedDatasetResponse> suspendPublishedDataset(
        SuspendPublishedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuspendPublishedDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Asks provider to unsuspend (re-publish?) a transfer
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<UnsuspendPublishedDatasetResponse> unsuspendPublishedDataset(
        UnsuspendPublishedDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsuspendPublishedDatasetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_GET_CATALOGUE = 1;
  private static final int METHODID_GET_DATASET = 2;
  private static final int METHODID_PUBLISH_DATASET = 3;
  private static final int METHODID_UNPUBLISH_DATASET = 4;
  private static final int METHODID_SUSPEND_PUBLISHED_DATASET = 5;
  private static final int METHODID_UNSUSPEND_PUBLISHED_DATASET = 6;

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
        case METHODID_PING:
          serviceImpl.ping((PingRequest) request,
              (io.grpc.stub.StreamObserver<PingResponse>) responseObserver);
          break;
        case METHODID_GET_CATALOGUE:
          serviceImpl.getCatalogue((GetCatalogueRequest) request,
              (io.grpc.stub.StreamObserver<GetCatalogueResponse>) responseObserver);
          break;
        case METHODID_GET_DATASET:
          serviceImpl.getDataset((GetDatasetRequest) request,
              (io.grpc.stub.StreamObserver<GetDatasetResponse>) responseObserver);
          break;
        case METHODID_PUBLISH_DATASET:
          serviceImpl.publishDataset((PublishDatasetRequest) request,
              (io.grpc.stub.StreamObserver<PublishDatasetResponse>) responseObserver);
          break;
        case METHODID_UNPUBLISH_DATASET:
          serviceImpl.unpublishDataset((UnpublishDatasetRequest) request,
              (io.grpc.stub.StreamObserver<UnpublishDatasetResponse>) responseObserver);
          break;
        case METHODID_SUSPEND_PUBLISHED_DATASET:
          serviceImpl.suspendPublishedDataset((SuspendPublishedDatasetRequest) request,
              (io.grpc.stub.StreamObserver<SuspendPublishedDatasetResponse>) responseObserver);
          break;
        case METHODID_UNSUSPEND_PUBLISHED_DATASET:
          serviceImpl.unsuspendPublishedDataset((UnsuspendPublishedDatasetRequest) request,
              (io.grpc.stub.StreamObserver<UnsuspendPublishedDatasetResponse>) responseObserver);
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
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PingRequest,
              PingResponse>(
                service, METHODID_PING)))
        .addMethod(
          getGetCatalogueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetCatalogueRequest,
              GetCatalogueResponse>(
                service, METHODID_GET_CATALOGUE)))
        .addMethod(
          getGetDatasetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetDatasetRequest,
              GetDatasetResponse>(
                service, METHODID_GET_DATASET)))
        .addMethod(
          getPublishDatasetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              PublishDatasetRequest,
              PublishDatasetResponse>(
                service, METHODID_PUBLISH_DATASET)))
        .addMethod(
          getUnpublishDatasetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              UnpublishDatasetRequest,
              UnpublishDatasetResponse>(
                service, METHODID_UNPUBLISH_DATASET)))
        .addMethod(
          getSuspendPublishedDatasetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              SuspendPublishedDatasetRequest,
              SuspendPublishedDatasetResponse>(
                service, METHODID_SUSPEND_PUBLISHED_DATASET)))
        .addMethod(
          getUnsuspendPublishedDatasetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              UnsuspendPublishedDatasetRequest,
              UnsuspendPublishedDatasetResponse>(
                service, METHODID_UNSUSPEND_PUBLISHED_DATASET)))
        .build();
  }

  private static abstract class ProviderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProviderServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProviderProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProviderService");
    }
  }

  private static final class ProviderServiceFileDescriptorSupplier
      extends ProviderServiceBaseDescriptorSupplier {
    ProviderServiceFileDescriptorSupplier() {}
  }

  private static final class ProviderServiceMethodDescriptorSupplier
      extends ProviderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProviderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProviderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProviderServiceFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getGetCatalogueMethod())
              .addMethod(getGetDatasetMethod())
              .addMethod(getPublishDatasetMethod())
              .addMethod(getUnpublishDatasetMethod())
              .addMethod(getSuspendPublishedDatasetMethod())
              .addMethod(getUnsuspendPublishedDatasetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
