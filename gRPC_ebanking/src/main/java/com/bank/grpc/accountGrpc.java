package com.bank.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: account.proto")
public final class accountGrpc {

  private accountGrpc() {}

  public static final String SERVICE_NAME = "account";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty,
      com.bank.grpc.Account.APIResponse> getCheckBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "check_balance",
      requestType = com.bank.grpc.Account.Empty.class,
      responseType = com.bank.grpc.Account.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty,
      com.bank.grpc.Account.APIResponse> getCheckBalanceMethod() {
    io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty, com.bank.grpc.Account.APIResponse> getCheckBalanceMethod;
    if ((getCheckBalanceMethod = accountGrpc.getCheckBalanceMethod) == null) {
      synchronized (accountGrpc.class) {
        if ((getCheckBalanceMethod = accountGrpc.getCheckBalanceMethod) == null) {
          accountGrpc.getCheckBalanceMethod = getCheckBalanceMethod = 
              io.grpc.MethodDescriptor.<com.bank.grpc.Account.Empty, com.bank.grpc.Account.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "account", "check_balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accountMethodDescriptorSupplier("check_balance"))
                  .build();
          }
        }
     }
     return getCheckBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bank.grpc.Account.TransactionRequest,
      com.bank.grpc.Account.APIResponse> getDisplayTransactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "display_transactions",
      requestType = com.bank.grpc.Account.TransactionRequest.class,
      responseType = com.bank.grpc.Account.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.bank.grpc.Account.TransactionRequest,
      com.bank.grpc.Account.APIResponse> getDisplayTransactionsMethod() {
    io.grpc.MethodDescriptor<com.bank.grpc.Account.TransactionRequest, com.bank.grpc.Account.APIResponse> getDisplayTransactionsMethod;
    if ((getDisplayTransactionsMethod = accountGrpc.getDisplayTransactionsMethod) == null) {
      synchronized (accountGrpc.class) {
        if ((getDisplayTransactionsMethod = accountGrpc.getDisplayTransactionsMethod) == null) {
          accountGrpc.getDisplayTransactionsMethod = getDisplayTransactionsMethod = 
              io.grpc.MethodDescriptor.<com.bank.grpc.Account.TransactionRequest, com.bank.grpc.Account.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "account", "display_transactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.TransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accountMethodDescriptorSupplier("display_transactions"))
                  .build();
          }
        }
     }
     return getDisplayTransactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty,
      com.bank.grpc.Account.APIResponse> getDirectDebitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "direct_debit",
      requestType = com.bank.grpc.Account.Empty.class,
      responseType = com.bank.grpc.Account.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty,
      com.bank.grpc.Account.APIResponse> getDirectDebitMethod() {
    io.grpc.MethodDescriptor<com.bank.grpc.Account.Empty, com.bank.grpc.Account.APIResponse> getDirectDebitMethod;
    if ((getDirectDebitMethod = accountGrpc.getDirectDebitMethod) == null) {
      synchronized (accountGrpc.class) {
        if ((getDirectDebitMethod = accountGrpc.getDirectDebitMethod) == null) {
          accountGrpc.getDirectDebitMethod = getDirectDebitMethod = 
              io.grpc.MethodDescriptor.<com.bank.grpc.Account.Empty, com.bank.grpc.Account.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "account", "direct_debit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bank.grpc.Account.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accountMethodDescriptorSupplier("direct_debit"))
                  .build();
          }
        }
     }
     return getDirectDebitMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static accountStub newStub(io.grpc.Channel channel) {
    return new accountStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static accountBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new accountBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static accountFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new accountFutureStub(channel);
  }

  /**
   */
  public static abstract class accountImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Check Balance - Serverside Streaming gRPC
     * </pre>
     */
    public void checkBalance(com.bank.grpc.Account.Empty request,
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckBalanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Display Transaction - birectional Streaming gRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bank.grpc.Account.TransactionRequest> displayTransactions(
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDisplayTransactionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Direct Debit - Client Side Streaming gRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bank.grpc.Account.Empty> directDebit(
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDirectDebitMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckBalanceMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.bank.grpc.Account.Empty,
                com.bank.grpc.Account.APIResponse>(
                  this, METHODID_CHECK_BALANCE)))
          .addMethod(
            getDisplayTransactionsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.bank.grpc.Account.TransactionRequest,
                com.bank.grpc.Account.APIResponse>(
                  this, METHODID_DISPLAY_TRANSACTIONS)))
          .addMethod(
            getDirectDebitMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.bank.grpc.Account.Empty,
                com.bank.grpc.Account.APIResponse>(
                  this, METHODID_DIRECT_DEBIT)))
          .build();
    }
  }

  /**
   */
  public static final class accountStub extends io.grpc.stub.AbstractStub<accountStub> {
    private accountStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check Balance - Serverside Streaming gRPC
     * </pre>
     */
    public void checkBalance(com.bank.grpc.Account.Empty request,
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Display Transaction - birectional Streaming gRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bank.grpc.Account.TransactionRequest> displayTransactions(
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getDisplayTransactionsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Direct Debit - Client Side Streaming gRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.bank.grpc.Account.Empty> directDebit(
        io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDirectDebitMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class accountBlockingStub extends io.grpc.stub.AbstractStub<accountBlockingStub> {
    private accountBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check Balance - Serverside Streaming gRPC
     * </pre>
     */
    public java.util.Iterator<com.bank.grpc.Account.APIResponse> checkBalance(
        com.bank.grpc.Account.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class accountFutureStub extends io.grpc.stub.AbstractStub<accountFutureStub> {
    private accountFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK_BALANCE = 0;
  private static final int METHODID_DISPLAY_TRANSACTIONS = 1;
  private static final int METHODID_DIRECT_DEBIT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final accountImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(accountImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_BALANCE:
          serviceImpl.checkBalance((com.bank.grpc.Account.Empty) request,
              (io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISPLAY_TRANSACTIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.displayTransactions(
              (io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse>) responseObserver);
        case METHODID_DIRECT_DEBIT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.directDebit(
              (io.grpc.stub.StreamObserver<com.bank.grpc.Account.APIResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class accountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    accountBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bank.grpc.Account.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("account");
    }
  }

  private static final class accountFileDescriptorSupplier
      extends accountBaseDescriptorSupplier {
    accountFileDescriptorSupplier() {}
  }

  private static final class accountMethodDescriptorSupplier
      extends accountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    accountMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (accountGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new accountFileDescriptorSupplier())
              .addMethod(getCheckBalanceMethod())
              .addMethod(getDisplayTransactionsMethod())
              .addMethod(getDirectDebitMethod())
              .build();
        }
      }
    }
    return result;
  }
}
