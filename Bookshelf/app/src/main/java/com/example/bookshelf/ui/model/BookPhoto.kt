package com.example.bookshelf.ui.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BookPhoto (
    val id: String,
    @SerialName("imageLinks")
    val imgSrc: String
)