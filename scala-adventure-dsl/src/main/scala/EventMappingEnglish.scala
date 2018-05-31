import com.programyourhome.iotadventure.dsl.events.ButtonEvent
import com.programyourhome.iotadventure.dsl.events.mapping.EventMappingBase

trait EventMappingEnglish extends EventMappingBase {

  def button(id: String) = ButtonEvent(id)

}