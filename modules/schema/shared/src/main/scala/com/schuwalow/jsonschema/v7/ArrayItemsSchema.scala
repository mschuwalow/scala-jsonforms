package com.schuwalow.jsonschema.v7

sealed trait ArrayItemsSchema

object ArrayItemsSchema {

  final case class SingleItem(schema: JsonSchema) extends ArrayItemsSchema

  final case class MultipleItems(schemas: List[JsonSchema]) extends ArrayItemsSchema

}
