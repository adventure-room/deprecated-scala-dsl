package com.programyourhome.iotadventure.dsl.events.eventbus

import com.programyourhome.iotadventure.dsl.events.Event

trait EventListener[E <: Event] {
  def handleEvent(event: E)
}