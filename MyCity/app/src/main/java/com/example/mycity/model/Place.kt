package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val name: String,
    @DrawableRes val image: Int,
)
