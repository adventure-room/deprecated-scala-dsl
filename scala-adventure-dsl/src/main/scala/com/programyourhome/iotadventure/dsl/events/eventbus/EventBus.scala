package com.programyourhome.iotadventure.dsl.events.eventbus

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import scala.concurrent.duration.FiniteDuration
import scala.reflect.ClassTag

import com.programyourhome.iotadventure.dsl.Types.EventHandler

// Forked from: https://github.com/hipjim/scala-event-bus
sealed trait EventBus {
  def post[T](event: => T)(implicit ec: ExecutionContext): Unit
  def postAtInterval[T](interval: FiniteDuration, initialDelay: FiniteDuration = 0.seconds)(event: => T)(implicit ec: Scheduler): Unit
  def subscribe[T](e: EventHandler[T])(implicit c: ClassTag[T]): EventBus
  def subscribeAsync[T](e: EventHandler[T])(implicit c: ClassTag[T]): EventBus
  def canHandleEventType[T](implicit c: ClassTag[T]): Boolean
}

object EventBus {
  def apply(): EventBus = new ReferenceEventBus()

  private case class ReferenceEventBus(async: Boolean = false)
      extends EventBus {
    private[this] val eventHandlerRegistry = new Registry()
    private[this] val asyncEventHandlersRegistry = new Registry()

    override def post[T](event: => T)(implicit ec: ExecutionContext): Unit = {
      eventHandlerRegistry.lookUpEventHandler(event).foreach { f =>
        f(event)
      }
      asyncEventHandlersRegistry.lookUpEventHandler(event).foreach { f =>
        val future = Future(f(event))
        //TODO: proper logging
        future.onFailure { case t => t.printStackTrace() }
      }
    }

    override def postAtInterval[T](interval: FiniteDuration,
      initialDelay: FiniteDuration = 0.seconds)(
        event: => T)(implicit ec: Scheduler): Unit = {
      ec.scheduleAtFixedRate(initialDelay, interval, new Runnable {
        override def run(): Unit = post(event)
      })
    }

    override def subscribe[T](e: EventHandler[T])(
      implicit c: ClassTag[T]): EventBus = {
      eventHandlerRegistry.registerEventHandler(e)
      this
    }

    override def subscribeAsync[T](e: EventHandler[T])(
      implicit c: ClassTag[T]): EventBus = {
      asyncEventHandlersRegistry.registerEventHandler(e)
      this
    }

    override def canHandleEventType[T](implicit c: ClassTag[T]): Boolean =
      eventHandlerRegistry.hasEventHandlerFor(c) ||
        asyncEventHandlersRegistry.hasEventHandlerFor(c)

  }
}
