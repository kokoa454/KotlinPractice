package com.example.bookshelf.ui.data

import com.example.bookshelf.ui.model.BookPhoto
import com.example.bookshelf.ui.network.BookshelfApiService

interface BookshelfRepository{
    suspend fun getBookPhotos(): List<BookPhoto>
}

class NetworkBookPhotosRepository(
    private val bookshelfApiService: BookshelfApiService
): BookshelfRepository{
    override suspend fun getBookPhotos(): List<BookPhoto> = bookshelfApiService.getPhotos()
}