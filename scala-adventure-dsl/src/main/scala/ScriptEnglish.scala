import com.programyourhome.iotadventure.dsl.Dice
import com.programyourhome.iotadventure.dsl.Name
import com.programyourhome.iotadventure.dsl.Number
import com.programyourhome.iotadventure.dsl.RunEnglish
import com.programyourhome.iotadventure.dsl.ScriptBase
import com.programyourhome.iotadventure.dsl.SetEnglish
import com.programyourhome.iotadventure.dsl.StateEnglish

// Note: all constants defined below cannot be used anymore as variable in the script!
trait ScriptEnglish extends ScriptBase {
  val set = SetEnglish
  val polly = SetEnglish

  val generate = SetEnglish

  val number = new Number
  val name = new Name
  val dice = new Dice
  val run = RunEnglish

  // Dummy words for better grammar
  val word = new Object
  val dummy = new Object

  val state = new StateEnglish
  val act = SetEnglish
  val go = SetEnglish
  val play = SetEnglish
  val roll = SetEnglish
  val pause = SetEnglish
}