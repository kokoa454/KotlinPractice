package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.CategoryData
import com.example.mycity.data.PlaceData
import com.example.mycity.data.PlaceData.places
import com.example.mycity.model.Category
import com.example.mycity.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val places: List<Place> = emptyList()
)

class MyCityViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(MyCityUiState(
        categories = CategoryData.categories,
        places = places
    ))
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun toPlaceList(categoryListName: String): MyCityUiState {
        when(categoryListName){
            "category_nature_sightseeing" ->
                return _uiState.value.copy(
                    places = PlaceData.places_nature_sightseeing
                )
            "category_food" ->
                return _uiState.value.copy(
                    places = PlaceData.places_food
                )
            "category_shopping" ->
                return _uiState.value.copy(
                    places = PlaceData.places_shopping
                )
            "category_music_culture" ->
                return _uiState.value.copy(
                    places = PlaceData.places_music_culture
                )
            else ->
                return _uiState.value.copy(
                    places = PlaceData.places_others
                )
        }
    }
}