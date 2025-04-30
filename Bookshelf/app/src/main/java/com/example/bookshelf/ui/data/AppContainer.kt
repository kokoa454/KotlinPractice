package com.example.bookshelf.ui.data

import com.example.bookshelf.ui.network.BookshelfApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer{
    val bookshelfRepository: BookshelfRepository
}

class DefaultAppContainer: AppContainer{
    private val baseUrl = "/*TODO*/"

    private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(baseUrl)
    .build()

    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    override val bookshelfRepository: BookshelfRepository by lazy{
        NetworkBookPhotosRepository(retrofitService)
    }
}