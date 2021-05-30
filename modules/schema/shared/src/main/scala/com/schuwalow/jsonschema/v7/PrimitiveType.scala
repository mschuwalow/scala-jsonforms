package com.schuwalow.jsonschema.v7

sealed trait PrimitiveType

object PrimitiveType {

  case object JString extends PrimitiveType

  case object JInteger extends PrimitiveType

  case object JNumber extends PrimitiveType

  case object JObject extends PrimitiveType

  case object JArray extends PrimitiveType

  case object JBoolean extends PrimitiveType

  case object JNull extends PrimitiveType

}
