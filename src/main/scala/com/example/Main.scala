package com.example

import com.example.hello.{GreeterGrpc, HelloReply, HelloRequest}

import scala.concurrent.{ExecutionContext, Future}
import io.grpc.{Server, ServerBuilder}
import io.iohk.test.protos.credentials
import io.iohk.test.protos.credentials.{GetCredentialsRequest, GetCredentialsResponse, GetUsersResponse}

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
object Main {

  def main(args:Array[String]): Unit ={
   // val server = new HelloWorldServer(ExecutionContext.global)
   val server = new ServerApp(ExecutionContext.global)
    server.start()
    server.blockUntilShutdown()
  }
  private val port = 50051
}
class ServerApp(executionContext: ExecutionContext) {
  self =>
  private[this] var server: Server = null
  def start(): Unit = {
    val database=new Database
    server = ServerBuilder
      .forPort(50051)
      .addService(
        credentials
          .CredentialsServiceGrpc
          .bindService(new CredentialsServiceImpl(database),executionContext))
      .build()
      .start()
  }
  def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }
}

class CredentialsServiceImpl(database: Database)(implicit ec: ExecutionContext)
  extends credentials.CredentialsServiceGrpc.CredentialsService {

  override def getCredentials(request: GetCredentialsRequest): Future[GetCredentialsResponse] = {
Future{
  val userId = UUID.fromString(request.userId)
 // val userId:String = (request.userId).toString()
  fillDatabase(userId)
  val limit = Option(request.limit).filter(_ > 0).getOrElse(3)
  val result = database.get(userId, limit, request.after)
  credentials.GetCredentialsResponse(result)
}(ec)
  }

  override def getUsers(request: GetCredentialsRequest): Future[GetUsersResponse] = {
    Future{
  val userId = UUID.fromString(request.userId)
 // val userId:String = (request.userId).toString()
  fillDatabase(userId)
  val limit = Option(request.limit).filter(_ > 0).getOrElse(3)
  //val result = database.get(userId, limit, request.after)
  val result= database.getUsers()
  credentials.GetUsersResponse(result)
}(ec)
  }
  private def fillDatabase(userId: UUID): Unit = {
    val maxEntries = 5
    println(userId)
    if (database.count(userId) >= maxEntries) {
      ()
    } else {
      println("reached in else part of fillDatabase")
      val newData = generateCredential()
      database.add(userId, newData)
    }
  }
  private def randomInt = scala.util.Random.nextInt(1000)
  private def generateCredential(): credentials.Credential = {
    credentials
      .Credential()
      .withIssuedOn(System.currentTimeMillis())
      .withIssuer(s"Issuer ${randomInt}")
      .withSubject(s"Subject ${randomInt}")
      .withTitle(s"Title ${randomInt}")
  }
  }

class HelloWorldServer(executionContext: ExecutionContext) {
  self =>
  private[this] var server: Server = null
   def start(): Unit = {
    server = ServerBuilder
            .forPort(50051)
          .addService(GreeterGrpc.bindService(new GreeterImpl, executionContext))
        .build().start()

    sys.addShutdownHook {
      System.err.println("*** shutting down gRPC server since JVM is shutting down")
      self.stop()
      System.err.println("*** server shut down")
    }
  }
  private def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }
   def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }

private class GreeterImpl extends GreeterGrpc.Greeter {
  override def sayHello(req: HelloRequest) = {
    val reply = HelloReply(message = "Hello " + req.name)
    Future.successful(reply)
  }
}
}
class Database {
  private var map: Map[UUID, List[credentials.Credential]] = Map.empty
  private var nextId = 1

  def add(userId: UUID, credential: credentials.Credential): Unit = {
    synchronized {
      val newData = credential.copy(id = nextId) :: map.getOrElse(
        userId,
        List.empty
      )
      nextId = nextId + 1
      println(newData)
      println(map)
      map = map + (userId -> newData)
    }
  }

  def count(userId: UUID): Int = {

    map.getOrElse(userId, List.empty).size
  }

  def get(userId: UUID,
          limit: Int,
          after: Int): List[credentials.Credential] = {
    map
      .getOrElse(userId, List.empty)
      .filter(_.id > after)
      .sortBy(_.id)
      .take(limit)
  }
  def getUsers(): List[credentials.Credential] = {

    val list:List[credentials.Credential] = map.values.toList.flatten
    list
    
  }
}