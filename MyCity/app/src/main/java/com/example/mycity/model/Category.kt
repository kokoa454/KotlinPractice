package com.example.mycity.model

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    val number: String,
    @DrawableRes val image: Int,
)

