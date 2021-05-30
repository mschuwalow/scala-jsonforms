package com.schuwalow.jsonschema.v7

import cats.Eval
import javax.xml.validation.Schema
import com.schuwalow.rjson.{Json, JsonNumber}

sealed trait JsonSchema

object JsonSchema {

  final case class Resolved(
    `type`: DataType = DataType.Unspecified,
    title: Option[String] = None,
    description: Option[String] = None,
    default: Option[Json] = None,
    examples: List[Json] = Nil,
    readOnly: Boolean = false,
    writeOnly: Boolean = false,
    enum: Set[Json] = Set.empty,
    const: Option[Json] = None,
    allOf: Set[JsonSchema] = Set.empty,
    anyOf: Set[JsonSchema] = Set.empty,
    oneOf: List[JsonSchema] = Nil,
    not: Option[JsonSchema] = None,
    `if`: Option[Schema] = None,
    `then`: Option[Schema] = None,
    `else`: Option[Schema] = None,
    minLength: Option[JsonNumber] = None,
    maxLength: Option[JsonNumber] = None,
    pattern: Option[String] = None,
    format: Option[String] = None,
    contentEncoding: Option[String] = None,
    contentMediaType: Option[String] = None,
    multipleOf: Option[JsonNumber] = None,
    minimum: Option[JsonNumber] = None,
    exclusiveMinimum: Option[JsonNumber] = None,
    maximum: Option[JsonNumber] = None,
    exclusiveMaximum: Option[JsonNumber] = None,
    items: Option[ArrayItemsSchema] = None,
    additionalItems: Boolean = true,
    contains: Option[JsonSchema] = None,
    minItems: Option[JsonNumber] = None,
    maxItems: Option[JsonNumber] = None,
    uniqueItems: Boolean = false,
    properties: Map[String, JsonSchema] = Map.empty,
    patternProperties: Map[String, JsonSchema] = Map.empty,
    additionalProperties: Boolean = true,
    required: List[String] = Nil,
    propertyNames: Option[String] = None,
    minProperties: Option[JsonNumber] = None,
    maxProperties: Option[JsonNumber] = None,
    dependencies: Map[String, DependencySchema] = Map.empty
  ) extends JsonSchema

  final case class Delayed(value: Eval[Resolved]) extends JsonSchema

}
