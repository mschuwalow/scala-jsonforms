package com.schuwalow.rjson

import cats.Eval

sealed trait Json

object Json {

  case object JNull extends Json

  final case class JBoolean(value: Boolean) extends Json

  final case class JNumber(value: JsonNumber) extends Json

  final case class JString(value: String) extends Json

  final case class JArray(value: Vector[Json]) extends Json

  final case class JObject(value: JsonObject) extends Json

  final case class Ref(get: Eval[Json]) extends Json
}
