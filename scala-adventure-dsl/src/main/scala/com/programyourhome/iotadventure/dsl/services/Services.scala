package com.programyourhome.iotadventure.dsl.services

import com.programyourhome.iotadventure.hue.PhilipsHue
import com.programyourhome.iotadventure.amazon.polly.AmazonPolly

object Services {

  var philipsHue: PhilipsHue = null
  def setPhilipsHue(philipsHueImpl: PhilipsHue) = philipsHue = philipsHueImpl

  var amazonPolly: AmazonPolly = null
  def setAmazonPolly(amazonPollyImpl: AmazonPolly) = amazonPolly = amazonPollyImpl

}