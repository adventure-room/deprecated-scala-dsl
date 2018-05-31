package com.programyourhome.iotadventure.dsl

object Types {
  type EventHandler[T] = T => Unit
}
