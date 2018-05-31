package com.programyourhome.iotadventure.dsl

object RunDutch extends Run {
  def script(adventure: ScriptBase) = scriptImpl(adventure)
}

object SetDutch extends Set {
  def dummy(obj: Object) = dummyImpl(obj)
  def kamer(name: String) = roomImpl(name)
  def willekeurig(number: Number) = randomImpl(number)
  def willekeurig(name: Name) = randomImpl(name)
  def print(ref: Any) = printImpl(ref)
  def zeg(text: String) = sayImpl(text)
  def de(dice: Dice) = theImpl(dice)
  def seconden(amount: Int) = secondsImpl(amount)
  def lichten(color: String) = lightsImpl(color)
}

class RoomDutch(name: String) extends Room(name) {
  def naar(newName: String) = toImpl(newName)
}
