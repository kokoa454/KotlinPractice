package com.example.bookshelf.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.ui.data.BookshelfRepository
import com.example.bookshelf.ui.model.BookPhoto
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookshelfUiState{
    data class Success(val bookList: List<BookPhoto>) : BookshelfUiState
    data object Error : BookshelfUiState
    data object Loading : BookshelfUiState
}

class BookshelfViewModel(
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init{
        getBookPhotos()
    }

    private fun getBookPhotos(){
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try{
                BookshelfUiState.Success(bookshelfRepository.getBookPhotos())
            } catch (e: IOException) {
                BookshelfUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }
}