package com.example.amphibians.ui.network

import com.example.amphibians.ui.model.AmphibiansPhoto
import retrofit2.http.GET

interface AmphibiansApiService{
    @GET("amphibians")
    suspend fun getPhotos(): List<AmphibiansPhoto>
}