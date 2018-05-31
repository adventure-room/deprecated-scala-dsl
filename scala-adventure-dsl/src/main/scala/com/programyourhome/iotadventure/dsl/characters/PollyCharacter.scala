package com.programyourhome.iotadventure.dsl.characters

import com.programyourhome.iotadventure.dsl.services.Services

class PollyCharacter(name: String, voiceName: String) {

  protected def saisImpl(text: String) = Services.amazonPolly.say(voiceName, text)

}
