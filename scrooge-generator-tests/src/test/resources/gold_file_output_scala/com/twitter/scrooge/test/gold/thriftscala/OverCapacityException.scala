/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object OverCapacityException extends ThriftStructCodec3[OverCapacityException] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("OverCapacityException")
  val ChillTimeSecondsField = new TField("chillTimeSeconds", TType.I32, 1)
  val ChillTimeSecondsFieldManifest = implicitly[Manifest[Int]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      ChillTimeSecondsField,
      false,
      false,
      ChillTimeSecondsFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: OverCapacityException): Unit = {
  }

  def withoutPassthroughFields(original: OverCapacityException): OverCapacityException =
    new OverCapacityException(
      chillTimeSeconds =
        {
          val field = original.chillTimeSeconds
          field
        }
    )

  override def encode(_item: OverCapacityException, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  override def decode(_iprot: TProtocol): OverCapacityException = {
    var chillTimeSeconds: Int = 0
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I32 =>
                chillTimeSeconds = readChillTimeSecondsValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'chillTimeSeconds' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new OverCapacityException(
      chillTimeSeconds,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    chillTimeSeconds: Int
  ): OverCapacityException =
    new OverCapacityException(
      chillTimeSeconds
    )

  def unapply(_item: OverCapacityException): _root_.scala.Option[Int] = _root_.scala.Some(_item.chillTimeSeconds)


  @inline private def readChillTimeSecondsValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeChillTimeSecondsField(chillTimeSeconds_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ChillTimeSecondsField)
    writeChillTimeSecondsValue(chillTimeSeconds_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeChillTimeSecondsValue(chillTimeSeconds_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(chillTimeSeconds_item)
  }


}

class OverCapacityException(
    val chillTimeSeconds: Int,
    val _passthroughFields: immutable$Map[Short, TFieldBlob])
  extends ThriftException with com.twitter.finagle.SourcedException with ThriftStruct
  with scala.Product1[Int]
  with HasThriftStructCodec3[OverCapacityException]
  with java.io.Serializable
{
  import OverCapacityException._
  def this(
    chillTimeSeconds: Int
  ) = this(
    chillTimeSeconds,
    Map.empty
  )

  def _1 = chillTimeSeconds


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (true) {
                writeChillTimeSecondsValue(chillTimeSeconds, _oprot)
                _root_.scala.Some(OverCapacityException.ChillTimeSecondsField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
            _root_.scala.Some(TFieldBlob(_field, _data))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): OverCapacityException = {
    var chillTimeSeconds: Int = this.chillTimeSeconds
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        chillTimeSeconds = readChillTimeSecondsValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new OverCapacityException(
      chillTimeSeconds,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): OverCapacityException = {
    var chillTimeSeconds: Int = this.chillTimeSeconds

    _fieldId match {
      case 1 =>
        chillTimeSeconds = 0
      case _ =>
    }
    new OverCapacityException(
      chillTimeSeconds,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetChillTimeSeconds: OverCapacityException = unsetField(1)


  override def write(_oprot: TProtocol): Unit = {
    OverCapacityException.validate(this)
    _oprot.writeStructBegin(Struct)
    writeChillTimeSecondsField(chillTimeSeconds, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    chillTimeSeconds: Int = this.chillTimeSeconds,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): OverCapacityException =
    new OverCapacityException(
      chillTimeSeconds,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[OverCapacityException]

  private def _equals(x: OverCapacityException, y: OverCapacityException): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[OverCapacityException]) &&
      _passthroughFields == other.asInstanceOf[OverCapacityException]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 1

  override def productElement(n: Int): Any = n match {
    case 0 => this.chillTimeSeconds
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "OverCapacityException"

  def _codec: ThriftStructCodec3[OverCapacityException] = OverCapacityException
}