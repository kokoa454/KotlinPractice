package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CategoryData
import com.example.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MyCityUiState(
    val categories: List<Category> = emptyList()
)

class MyCityViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(MyCityUiState(
        categories = CategoryData.categories
    ))
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()
}