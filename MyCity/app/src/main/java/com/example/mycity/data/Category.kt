package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val name: String,
    val number: String,
    @DrawableRes val image: Int,
)
