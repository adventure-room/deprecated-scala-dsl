import com.programyourhome.iotadventure.dsl.events.ButtonEvent
import com.programyourhome.iotadventure.dsl.events.mapping.EventMappingBase

trait EventMappingDutch extends EventMappingBase {

  def knop(id: String) = ButtonEvent(id)

}