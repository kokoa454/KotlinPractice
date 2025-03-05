class Song(val title: String, val artistName: String, val releasedYear: Int, val viewCount: Int){
    var popularity = "unknown"

    fun checkPopularity(){
        if(viewCount < 1000){
            popularity = "Not Popular"     
        } else {
            popularity = "Popular"
        }
    }

    fun printInfo(){
        println("$title perfomed by $artistName, was released in $releasedYear")
    }
}

fun main(){
    val songA = Song("Saturday Night's Alright", "Elton John", 1973, 14000000)

    songA.printInfo()
}