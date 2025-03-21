package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic (
    @StringRes val stringResourceID: Int,
    val numberOfCourses: Int,
    @DrawableRes val imageResourceId: Int
)