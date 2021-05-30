package com.schuwalow.jsonschema.v7

sealed trait DependencySchema

object DependencySchema {

  final case class PropertyDependency(
    properties: List[String]
  ) extends DependencySchema

  final case class SchemaDependency(
    schema: JsonSchema
  )

}
