package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel(){
    private val _revenue = MutableStateFlow(0)
    val revenue: StateFlow<Int> = _revenue.asStateFlow()

    private val _dessertsSold = MutableStateFlow(0)
    val dessertsSold: StateFlow<Int> = _dessertsSold.asStateFlow()

    private val _currentDessert = MutableStateFlow(Datasource.dessertList.first())
    val currentDessert : StateFlow<Dessert> = _currentDessert.asStateFlow()

    fun onDessertClicked() {
        _revenue.value += _currentDessert.value.price
        _dessertsSold.value++

        _currentDessert.value = determineDessertToShow(Datasource.dessertList, _dessertsSold.value)
    }

    private fun determineDessertToShow(
        dessert: List<Dessert>,
        dessertsSold: Int
    ): Dessert{
        return dessert.lastOrNull {dessertsSold >= it.startProductionAmount } ?: dessert.first()
    }
}