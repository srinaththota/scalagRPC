package io.iohk.test.protos.credentials

object CredentialsServiceGrpc {
  val METHOD_GET_CREDENTIALS: _root_.io.grpc.MethodDescriptor[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest, _root_.io.iohk.test.protos.credentials.GetCredentialsResponse] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("io.iohk.test.protos.CredentialsService", "GetCredentials"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[_root_.io.iohk.test.protos.credentials.GetCredentialsResponse])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(io.iohk.test.protos.credentials.CredentialsProto.javaDescriptor.getServices.get(0).getMethods.get(0)))
      .build()
  
  val METHOD_GET_USERS: _root_.io.grpc.MethodDescriptor[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest, _root_.io.iohk.test.protos.credentials.GetUsersResponse] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("io.iohk.test.protos.CredentialsService", "getUsers"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[_root_.io.iohk.test.protos.credentials.GetUsersResponse])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(io.iohk.test.protos.credentials.CredentialsProto.javaDescriptor.getServices.get(0).getMethods.get(1)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("io.iohk.test.protos.CredentialsService")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(io.iohk.test.protos.credentials.CredentialsProto.javaDescriptor))
      .addMethod(METHOD_GET_CREDENTIALS)
      .addMethod(METHOD_GET_USERS)
      .build()
  
  /** There is a single API which returns the credentials available for the given user id.
    *
    * There is no registration needed, just generate a random UUID, and use that, the server
    * will generate credentials automatically for it.
    */
  trait CredentialsService extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = CredentialsService
    def getCredentials(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): scala.concurrent.Future[_root_.io.iohk.test.protos.credentials.GetCredentialsResponse]
    def getUsers(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): scala.concurrent.Future[_root_.io.iohk.test.protos.credentials.GetUsersResponse]
  }
  
  object CredentialsService extends _root_.scalapb.grpc.ServiceCompanion[CredentialsService] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[CredentialsService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = io.iohk.test.protos.credentials.CredentialsProto.javaDescriptor.getServices().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = CredentialsProto.scalaDescriptor.services(0)
  }
  
  /** There is a single API which returns the credentials available for the given user id.
    *
    * There is no registration needed, just generate a random UUID, and use that, the server
    * will generate credentials automatically for it.
    */
  trait CredentialsServiceBlockingClient {
    def serviceCompanion = CredentialsService
    def getCredentials(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): _root_.io.iohk.test.protos.credentials.GetCredentialsResponse
    def getUsers(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): _root_.io.iohk.test.protos.credentials.GetUsersResponse
  }
  
  class CredentialsServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[CredentialsServiceBlockingStub](channel, options) with CredentialsServiceBlockingClient {
    override def getCredentials(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): _root_.io.iohk.test.protos.credentials.GetCredentialsResponse = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_GET_CREDENTIALS, options, request)
    }
    
    override def getUsers(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): _root_.io.iohk.test.protos.credentials.GetUsersResponse = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_GET_USERS, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): CredentialsServiceBlockingStub = new CredentialsServiceBlockingStub(channel, options)
  }
  
  class CredentialsServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[CredentialsServiceStub](channel, options) with CredentialsService {
    override def getCredentials(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): scala.concurrent.Future[_root_.io.iohk.test.protos.credentials.GetCredentialsResponse] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_GET_CREDENTIALS, options, request)
    }
    
    override def getUsers(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest): scala.concurrent.Future[_root_.io.iohk.test.protos.credentials.GetUsersResponse] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_GET_USERS, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): CredentialsServiceStub = new CredentialsServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: CredentialsService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
    _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
    .addMethod(
      METHOD_GET_CREDENTIALS,
      _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest, _root_.io.iohk.test.protos.credentials.GetCredentialsResponse] {
        override def invoke(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest, observer: _root_.io.grpc.stub.StreamObserver[_root_.io.iohk.test.protos.credentials.GetCredentialsResponse]): Unit =
          serviceImpl.getCredentials(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
            executionContext)
      }))
    .addMethod(
      METHOD_GET_USERS,
      _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[_root_.io.iohk.test.protos.credentials.GetCredentialsRequest, _root_.io.iohk.test.protos.credentials.GetUsersResponse] {
        override def invoke(request: _root_.io.iohk.test.protos.credentials.GetCredentialsRequest, observer: _root_.io.grpc.stub.StreamObserver[_root_.io.iohk.test.protos.credentials.GetUsersResponse]): Unit =
          serviceImpl.getUsers(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
            executionContext)
      }))
    .build()
  
  def blockingStub(channel: _root_.io.grpc.Channel): CredentialsServiceBlockingStub = new CredentialsServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): CredentialsServiceStub = new CredentialsServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = io.iohk.test.protos.credentials.CredentialsProto.javaDescriptor.getServices().get(0)
  
}