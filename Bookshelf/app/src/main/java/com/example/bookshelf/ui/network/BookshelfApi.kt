package com.example.bookshelf.ui.network

import com.example.bookshelf.ui.model.BooksResponse
import retrofit2.http.GET

interface BookshelfApiService {
    @GET("volumes?q=Russia")
    suspend fun getPhotos(): BooksResponse
}