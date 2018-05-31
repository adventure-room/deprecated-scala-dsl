package com.programyourhome.iotadventure.dsl.state

import scala.collection.mutable.Map

class State {

  private val map = Map[String, Object]()

  def get(key: String) = map(key)

  def set(key: String, value: Object) = map += (key -> value)

}