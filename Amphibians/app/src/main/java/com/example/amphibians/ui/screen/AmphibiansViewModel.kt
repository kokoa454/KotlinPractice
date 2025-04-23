package com.example.amphibians.ui.screen

import com.example.amphibians.ui.model.AmphibiansPhoto

sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<AmphibiansPhoto>) : AmphibiansUiState
    data object Error : AmphibiansUiState
    data object Loading : AmphibiansUiState
}