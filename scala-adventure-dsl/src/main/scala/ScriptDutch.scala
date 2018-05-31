import com.programyourhome.iotadventure.dsl.Dice
import com.programyourhome.iotadventure.dsl.Name
import com.programyourhome.iotadventure.dsl.Number
import com.programyourhome.iotadventure.dsl.RunDutch
import com.programyourhome.iotadventure.dsl.ScriptBase
import com.programyourhome.iotadventure.dsl.SetDutch
import com.programyourhome.iotadventure.dsl.state.State

// Note: all constants defined below cannot be used anymore as variable in the script!
trait ScriptDutch extends ScriptBase {
  val zet = SetDutch

  val generate = SetDutch

  val nummer = new Number
  val naam = new Name
  val dobbelsteen = new Dice
  val start = RunDutch

  // Dummy words for better grammar
  val woord = new Object
  val dummy = new Object

  val toestand = new State
  val doe = SetDutch
  val ga = SetDutch
  val speelaf = SetDutch
  val gooi = SetDutch
  val pauzeer = SetDutch
}