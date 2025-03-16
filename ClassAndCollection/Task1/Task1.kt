class Event(title: String, description: String? = null, daypart: String, durationInMinutes: Int)

fun main(){
    Event(title="Study Kotlin", description="Commit to studying Kotlin at least 15 minutes per day.", daypart="Evening", durationInMinutes=15)
}