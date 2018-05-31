package com.programyourhome.iotadventure.dsl.events

import com.programyourhome.iotadventure.dsl.ScriptBase
import com.programyourhome.iotadventure.dsl.events.mapping.EventMappingBase
import com.programyourhome.iotadventure.dsl.events.mapping.ScriptCall

trait Event {

  def -->(script: ScriptBase)(implicit mapping: EventMappingBase) = mapping.map.addBinding(this, ScriptCall(script, Map()))

  def -->(script: ScriptBase, arguments: Map[String, Object])(implicit mapping: EventMappingBase) = mapping.map.addBinding(this, ScriptCall(script, arguments))

}