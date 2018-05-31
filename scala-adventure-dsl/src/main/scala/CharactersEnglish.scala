import com.programyourhome.iotadventure.dsl.characters.PollyCharacterEnglish
import com.programyourhome.iotadventure.dsl.characters.CharactersBase

trait CharactersEnglish extends CharactersBase {

  def polly(name: String, voiceName: String) = new PollyCharacterEnglish(name, voiceName)

}
