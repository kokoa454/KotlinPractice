package com.example.bookshelf.ui.network

import com.example.bookshelf.ui.model.BookPhoto
import retrofit2.http.GET

interface BookshelfApiService {
    @GET(/*TODO*/)
    suspend fun getPhotos(): List<BookPhoto>
}