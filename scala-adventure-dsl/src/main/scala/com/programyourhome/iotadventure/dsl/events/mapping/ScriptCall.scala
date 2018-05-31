package com.programyourhome.iotadventure.dsl.events.mapping

import com.programyourhome.iotadventure.dsl.events.Event
import com.programyourhome.iotadventure.dsl.ScriptBase

case class ScriptCall(script: ScriptBase, params: Map[String, Object]) {
  def apply() = ??? // (should be overridden)
}
