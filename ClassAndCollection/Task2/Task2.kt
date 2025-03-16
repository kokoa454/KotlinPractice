class Event(
    title: String,
    description: String? = null,
    daypart: Daypart, 
    durationInMinutes: Int
)

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

fun main(){
    Event(title="Study Kotlin", description="Commit to studying Kotlin at least 15 minutes per day.", daypart=Daypart.EVENING, durationInMinutes=15)
}