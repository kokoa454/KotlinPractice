package com.example.amphibians.ui.data

import com.example.amphibians.ui.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val amphibiansRepository: AmphibiansRepository
}

class DefaultAppContainer: AppContainer{
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/" //base url has to end with a slash

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansRepository: AmphibiansRepository by lazy{
        NetworkAmphibiansPhotosRepository(retrofitService)
    }
}