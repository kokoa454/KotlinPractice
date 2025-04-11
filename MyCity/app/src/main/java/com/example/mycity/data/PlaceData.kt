package com.example.mycity.data
import com.example.mycity.model.Place
import com.example.mycity.R

object PlaceData {
    val places: List<Place> = listOf()

    val places_nature_sightseeing = listOf(
        Place(
            name = "浜名湖",
            image = R.drawable.place_hamanako
        ),
        Place(
            name = "中田島砂丘",
            image = R.drawable.place_nakatajimasakyu
        ),
        Place(
            name = "浜名湖\nガーデンパーク",
            image = R.drawable.place_gardenpark
        )
    )

    val places_food = listOf(
        Place(
            name = "炭火焼きレストラン\nさわやか",
            image = R.drawable.place_sawayaka
        ),
        Place(
            name = "浜松餃子\n石松",
            image = R.drawable.place_ishimatsu
        )
    )

    val places_shopping = listOf(
        Place(
            name = "ザザシティ浜松",
            image = R.drawable.place_zazacity
        ),
        Place(
            name = "遠鉄百貨店",
            image = R.drawable.place_entetsu
        )
    )

    val places_music_culture = listOf(
        Place(
            name = "アクトシティ浜松",
            image = R.drawable.place_actcity
        ),
        Place(
            name = "浜松市楽器博物館",
            image = R.drawable.place_museum
        )
    )

    val places_others = listOf(
        Place(
            name = "浜松市動物園",
            image = R.drawable.place_zoo
        ),
        Place(
            name = "フルーツパーク\n時之栖",
            image = R.drawable.place_fruitspark
        )
    )
}