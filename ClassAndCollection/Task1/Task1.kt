class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int)

fun main(){
    Event(title="Study Kotlin", description="Commit to studying Kotlin at least 15 minutes per day.", daypart="Evening", durationInMinutes=15)
}