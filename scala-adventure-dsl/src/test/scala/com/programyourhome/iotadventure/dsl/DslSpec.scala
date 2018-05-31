package com.programyourhome.iotadventure.dsl;

import org.mockito.Mockito._
import org.scalatest.FlatSpec
import org.scalatest.Matchers

import com.programyourhome.iotadventure.amazon.polly.AmazonPolly
import com.programyourhome.iotadventure.dsl.events.ButtonEvent
import com.programyourhome.iotadventure.dsl.services.Services
import org.scalatest.mockito.MockitoSugar

class DslSpec extends FlatSpec with Matchers {

  "Adventure DSL" should "initialize successfully" in {
    val pollyMock = mock(classOf[AmazonPolly])

    Services.setAmazonPolly(pollyMock)
    val dsl = Dsl.instance
    dsl.post(ButtonEvent("b5"))

    verify(pollyMock, times(1)).say("Jim", "Hello! This is a test, arg: testValue")
  }

}