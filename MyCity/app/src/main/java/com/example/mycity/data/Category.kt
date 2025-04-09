package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val name: String,
    @DrawableRes val image: Int,
)
