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

    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
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

    fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel(){
        channelNumber--
        println("Channel number decreased to $channelNumber.")
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

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
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

class SmartHome(val smartTVDevice: SmartTVDevice, val smartLightDevice: SmartLightDevice){
    var deviceTurnOnCount = 0
        private set
    
    fun turnOnTV(){
        if(smartTVDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartTVDevice.turnOn()   
        }
    }

    fun turnOffTV(){
        if(smartTVDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartTVDevice.turnOff()
        }
    }

    fun printSmartTVInfo(){
        smartTVDevice.printDeviceInfo()
    }

    fun increaseTVVolume(){
        if(smartTVDevice.deviceStatus == "on"){
            smartTVDevice.increaseSpeakerVolume()
        }
    }

    fun decreaseTVVolume(){
        if(smartTVDevice.deviceStatus == "on"){
            smartTVDevice.decreaseSpeakerVolume()
        }
    }

    fun changeTVChannelToNext(){
        if(smartTVDevice.deviceStatus == "on"){
            smartTVDevice.nextChannel()
        }
    }

    fun changeTVChannelToPrevious(){
        if(smartTVDevice.deviceStatus == "on"){
            smartTVDevice.previousChannel()
        }
    }

    fun turnOnLight(){
        if(smartLightDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight(){
        if(smartLightDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun printSmartLightInfo(){
        if(smartLightDevice.deviceStatus == "on"){
            smartLightDevice.printDeviceInfo()
        }
    }

    fun increaseLightBrightness(){
        if(smartLightDevice.deviceStatus == "on"){
            smartLightDevice.increaseBrightness()
        }
    }

    fun decreaseLightBrightness(){
        if(smartLightDevice.deviceStatus == "on"){
            smartLightDevice.decreaseBrightness()
        }
    }

    fun turnOffAllDevices(){
        if(smartTVDevice.deviceStatus == "on"){
            turnOffTV()
        }

        if(smartLightDevice.deviceStatus == "on"){
            turnOffLight()
        }
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
    var smartDevice: SmartDevice = SmartTVDevice("Android TV", "Entertainment")
    smartDevice.printDeviceInfo()
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.printDeviceInfo()
    smartDevice.turnOn()
}