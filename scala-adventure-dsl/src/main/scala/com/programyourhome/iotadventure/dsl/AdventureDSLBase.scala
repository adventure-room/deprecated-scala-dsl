package com.programyourhome.iotadventure.dsl

import java.awt.Color
import scala.util.Random
import com.programyourhome.iotadventure.dsl.services.Services

class Number
class Name
class Dice
// See: https://www.andiamo.co.uk/resources/iso-language-codes and https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
case class Language(englishName: String, localName: String, region: String, code2: String, code3: String, regionCode: String) {
  val name = localName
  val codeWithRegion = code2 + (regionCode + "")
}

class Run {
  def scriptImpl(adventure: ScriptBase, args: (String, String)*) = adventure(args: _*)
}

class Set {
  protected def dummyImpl(obj: Object) = this
  protected def roomImpl(name: String) = new Room(name)
  protected def randomImpl(number: Number) = 5
  protected def randomImpl(name: Name) = "random"
  protected def printImpl(ref: Any) = println(ref)
  protected def theImpl(dice: Dice) = Random.nextInt(6) + 1
  protected def secondsImpl(amount: Int) = println("Pause for " + amount + " seconds")
  protected def lightsImpl(color: String) = Services.philipsHue.setColorRGB(3, new Color(255, 0, 255))
  protected def sayImpl(text: String) = Services.amazonPolly.say("Joanna", text)
}

class Room(name: String) {
  def toImpl(newName: String) = println("Room from name " + name + " to " + newName)
}
