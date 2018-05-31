package com.programyourhome.iotadventure.dsl.events

case class SwitchEvent(switchId: String, on: Boolean) extends Event
