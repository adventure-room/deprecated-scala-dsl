import com.programyourhome.iotadventure.dsl.characters.PollyCharacterDutch
import com.programyourhome.iotadventure.dsl.characters.CharactersBase

trait CharactersDutch extends CharactersBase {

  def polly(name: String, voiceName: String) = new PollyCharacterDutch(name, voiceName)

}