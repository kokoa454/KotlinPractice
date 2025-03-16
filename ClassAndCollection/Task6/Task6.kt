class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart, 
    val durationInMinutes: Int
)

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

fun main(){
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)
    printShortTasks(events)
    printDayPart(events)
    printLastTaskOfTheDay(events)    
}

fun printShortTasks(events: List<Event>) {
    val shortEvent = events.filter { it.durationInMinutes < 60 }
    
    println("You have ${shortEvent.size} short events")
}

fun printDayPart(events: List<Event>) {
    val morningEvents = events.filter { it.daypart == Daypart.MORNING }
    val afternoonEvents = events.filter { it.daypart == Daypart.AFTERNOON }
    val eveningEvents = events.filter { it.daypart == Daypart.EVENING }

    println("Morning: ${morningEvents.size} events")
    println("Afternoon: ${afternoonEvents.size} events")
    println("Evening: ${eveningEvents.size} events")
}

fun printLastTaskOfTheDay(events: List<Event>) {
    val lastTask = events.last()
    println("Last task of the day: ${lastTask.title}")
}