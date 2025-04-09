package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PlaceDetails(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
