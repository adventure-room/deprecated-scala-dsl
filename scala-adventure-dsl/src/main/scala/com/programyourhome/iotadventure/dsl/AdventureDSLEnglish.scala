package com.programyourhome.iotadventure.dsl

import com.programyourhome.iotadventure.dsl.state.State

class StateEnglish extends State

object RunEnglish extends Run {
  def script(adventure: ScriptBase, args: (String, String)*) = scriptImpl(adventure, args: _*)
}

object SetEnglish extends Set {
  def dummy(obj: Object) = dummyImpl(obj)
  def room(name: String) = roomImpl(name)
  def random(number: Number) = randomImpl(number)
  def random(name: Name) = randomImpl(name)
  def print(ref: Any) = printImpl(ref)
  def the(dice: Dice) = theImpl(dice)
  def seconds(amount: Int) = secondsImpl(amount)
  def say(text: String) = sayImpl(text)
  def lights(color: String) = lightsImpl(color)
}

class RoomEnglish(name: String) extends Room(name) {
  def to(newName: String) = toImpl(newName)
}
