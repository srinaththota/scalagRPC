// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package io.iohk.test.protos.credentials

@SerialVersionUID(0L)
final case class RepeatedCredentials(
    credentials: _root_.scala.Seq[io.iohk.test.protos.credentials.Credential] = _root_.scala.Seq.empty
    ) extends scalapb.GeneratedMessage with scalapb.Message[RepeatedCredentials] with scalapb.lenses.Updatable[RepeatedCredentials] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      credentials.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      __size
    }
    final override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      credentials.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): io.iohk.test.protos.credentials.RepeatedCredentials = {
      val __credentials = (_root_.scala.collection.immutable.Vector.newBuilder[io.iohk.test.protos.credentials.Credential] ++= this.credentials)
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __credentials += _root_.scalapb.LiteParser.readMessage(_input__, io.iohk.test.protos.credentials.Credential.defaultInstance)
          case tag => _input__.skipField(tag)
        }
      }
      io.iohk.test.protos.credentials.RepeatedCredentials(
          credentials = __credentials.result()
      )
    }
    def clearCredentials = copy(credentials = _root_.scala.Seq.empty)
    def addCredentials(__vs: io.iohk.test.protos.credentials.Credential*): RepeatedCredentials = addAllCredentials(__vs)
    def addAllCredentials(__vs: Iterable[io.iohk.test.protos.credentials.Credential]): RepeatedCredentials = copy(credentials = credentials ++ __vs)
    def withCredentials(__v: _root_.scala.Seq[io.iohk.test.protos.credentials.Credential]): RepeatedCredentials = copy(credentials = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => credentials
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(credentials.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = io.iohk.test.protos.credentials.RepeatedCredentials
}

object RepeatedCredentials extends scalapb.GeneratedMessageCompanion[io.iohk.test.protos.credentials.RepeatedCredentials] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[io.iohk.test.protos.credentials.RepeatedCredentials] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, _root_.scala.Any]): io.iohk.test.protos.credentials.RepeatedCredentials = {
    _root_.scala.Predef.require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    io.iohk.test.protos.credentials.RepeatedCredentials(
      __fieldsMap.getOrElse(__fields.get(0), Nil).asInstanceOf[_root_.scala.Seq[io.iohk.test.protos.credentials.Credential]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[io.iohk.test.protos.credentials.RepeatedCredentials] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      io.iohk.test.protos.credentials.RepeatedCredentials(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[io.iohk.test.protos.credentials.Credential]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = CredentialsProto.javaDescriptor.getMessageTypes.get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = CredentialsProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = io.iohk.test.protos.credentials.Credential
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = io.iohk.test.protos.credentials.RepeatedCredentials(
    credentials = _root_.scala.Seq.empty
  )
  implicit class RepeatedCredentialsLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, io.iohk.test.protos.credentials.RepeatedCredentials]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, io.iohk.test.protos.credentials.RepeatedCredentials](_l) {
    def credentials: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[io.iohk.test.protos.credentials.Credential]] = field(_.credentials)((c_, f_) => c_.copy(credentials = f_))
  }
  final val CREDENTIALS_FIELD_NUMBER = 1
  def of(
    credentials: _root_.scala.Seq[io.iohk.test.protos.credentials.Credential]
  ): _root_.io.iohk.test.protos.credentials.RepeatedCredentials = _root_.io.iohk.test.protos.credentials.RepeatedCredentials(
    credentials
  )
}