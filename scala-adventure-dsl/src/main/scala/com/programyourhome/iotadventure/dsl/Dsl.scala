package com.programyourhome.iotadventure.dsl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.reflect.ClassTag

import com.programyourhome.iotadventure.dsl.Types.EventHandler
import com.programyourhome.iotadventure.dsl.events.mapping.EventMappingBase
import com.programyourhome.iotadventure.dsl.events.Event
import com.programyourhome.iotadventure.dsl.events.eventbus.EventBus
import com.programyourhome.iotadventure.dsl.events.eventbus.EventListener

object Dsl {

  // TODO: how can we nicer share a Dsl instance between Java and Scala?
  val instance: Dsl = new Dsl

}

class Dsl {

  //TODO: reminder: you can also post at intervals
  val eventBus = EventBus()

  def subscribeFromJava[E <: Event](listener: EventListener[E], clazz: Class[E]) {
    eventBus.subscribe[E](event => listener.handleEvent(event.asInstanceOf[E]))(ClassTag(clazz))
  }

  def subscribe[T](e: EventHandler[T])(implicit c: ClassTag[T]) = eventBus.subscribe(e)
  def subscribeAsync[T](e: EventHandler[T])(implicit c: ClassTag[T]) = eventBus.subscribeAsync(e)

  def post(event: Event) = eventBus.post(event)

  val eventMapping = Class.forName("EventMapping").newInstance.asInstanceOf[EventMappingBase].map
  // Initialize the Event Mapping
  subscribeAsync[Event] { receivedEvent =>
    for ((event, scriptCalls) <- eventMapping) {
      if (event.equals(receivedEvent)) {
        scriptCalls.foreach { scriptCall =>
          scriptCall.script.apply(scriptCall.params)
        }
      }
    }
  }

}