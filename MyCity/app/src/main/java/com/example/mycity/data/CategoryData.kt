package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category

object CategoryData{
    val categories = listOf(
        Category(
            name = "自然・観光",
            number = "1",
            image = R.drawable.category_nature_sightseeing
        ),
        Category(
            name = "グルメ",
            number = "1",
            image = R.drawable.category_food
        ),
        Category(
            name = "ショッピング",
            number = "1",
            image = R.drawable.category_shopping
        ),
        Category(
            name = "音楽・文化",
            number = "1",
            image = R.drawable.category_music_culture
        ),
        Category(
            name = "その他",
            number = "1",
            image = R.drawable.category_others
        )
    )
}