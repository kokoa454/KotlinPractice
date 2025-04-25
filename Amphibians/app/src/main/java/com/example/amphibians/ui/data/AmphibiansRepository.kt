package com.example.amphibians.ui.data

import com.example.amphibians.ui.model.AmphibiansPhoto
import com.example.amphibians.ui.network.AmphibiansApiService

interface AmphibiansRepository{
    suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto>
}

class NetworkAmphibiansPhotosRepository(
    private val amphibiansApiService: AmphibiansApiService
): AmphibiansRepository{
    override suspend fun getAmphibiansPhotos(): List<AmphibiansPhoto> = amphibiansApiService.getPhotos()
}