package com.programyourhome.iotadventure.dsl.characters

class PollyCharacterDutch(val naam: String, voiceName: String) extends PollyCharacter(naam, voiceName) with CharacterDutch {

  def name = naam

  def zegt(text: String) = saisImpl(text)

}