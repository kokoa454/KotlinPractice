open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    open fun switchOff() {
        isScreenLightOn = false
    }
    
    open fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFold: Boolean = true) : Phone(){
    override fun switchOn() {
        if(isFold = false) {
            super.switchOn()
        }
    }

    override fun switchOff(){
        if(isFold = true) {
            super.switchOff()
        }
    }

    fun toggleFoldState(){
        isFold = !isFold
    }
}