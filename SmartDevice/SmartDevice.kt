import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String){
    var deviceStatus = "online"
        protected set 

    open val deviceType = "unknown"

    open fun turnOn(){
        deviceStatus = "on"
    }

    open fun turnOff(){
        deviceStatus = "off"
    }
}

class SmartTVDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn(){
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    override fun turnOff(){
        super.turnOff()
        println("$name turned off.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory){
    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is set to $brightnessLevel.")
    }

    override fun turnOff(){
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off.")
    }
}

class SmartHome(val SmartTVDevice: SmartTVDevice, val smartLightDevice: SmartLightDevice){
    var deviceTurnOnCount = 0
        private set
    
    fun turnOnTV(){
        deviceTurnOnCount++
        SmartTVDevice.turnOn()
    }

    fun turnOffTV(){
        deviceTurnOnCount--
        SmartTVDevice.turnOff()
    }

    fun increaseTVVolume(){
        SmartTVDevice.increaseSpeakerVolume()
    }

    fun changeTVChannelToNext(){
        SmartTVDevice.nextChannel()
    }

    fun turnOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight(){
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        turnOffTV()
        turnOffLight()
    }
}

class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue){
            fieldData = value
        }
    }
}

fun main(){
    var SmartDevice: SmartDevice = SmartTVDevice("Android TV", "Entertainment")
    SmartDevice.turnOn()

    SmartDevice = SmartLightDevice("Google Light", "Utility")
    SmartDevice.turnOn()
}