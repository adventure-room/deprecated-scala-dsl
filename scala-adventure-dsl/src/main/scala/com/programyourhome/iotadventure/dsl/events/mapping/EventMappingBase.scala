package com.programyourhome.iotadventure.dsl.events.mapping

import scala.collection.mutable.HashMap
import scala.collection.mutable.MultiMap
import scala.collection.mutable.Set

import com.programyourhome.iotadventure.dsl.events.Event

trait EventMappingBase {

  implicit val eventMapping: EventMappingBase = this

  val map = new HashMap[Event, Set[ScriptCall]] with MultiMap[Event, ScriptCall]

}