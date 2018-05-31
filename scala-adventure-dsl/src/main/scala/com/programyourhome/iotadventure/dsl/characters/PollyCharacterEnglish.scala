package com.programyourhome.iotadventure.dsl.characters

class PollyCharacterEnglish(val name: String, voiceName: String) extends PollyCharacter(name, voiceName) with CharacterEnglish {

  def sais(text: String) = saisImpl(text)

}