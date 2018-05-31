package com.programyourhome.iotadventure.dsl

import scala.collection.JavaConverters.mapAsScalaMapConverter
import scala.collection.immutable.Map

// Note: all constants defined below cannot be used anymore as variable in the script! (solution = naming convention?)
trait ScriptBase extends DelayedInit {
  //TODO: can we get rid of the var here?
  var scriptCode: () => Unit = _
  override def delayedInit(initCode: => Unit) {
    scriptCode = (() => initCode)
  }

  val args = scala.collection.mutable.Map[String, Object]()
  def apply(theArgs: Map[String, Object]) = {
    args ++= theArgs
    scriptCode()
  }
  def apply(theArgs: (String, Object)*): Unit = {
    apply(theArgs.toMap)
  }
  def runFromJava(theArgs: java.util.Map[String, Object]) = {
    apply(theArgs.asScala.toList: _*)
  }
}