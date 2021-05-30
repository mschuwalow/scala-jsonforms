package com.schuwalow.jsonschema.v7

sealed trait DataType

object DataType {

  case object Unspecified extends DataType

  final case class Single(value: PrimitiveType) extends DataType

  final case class Multiple(values: Set[PrimitiveType]) extends DataType

}
