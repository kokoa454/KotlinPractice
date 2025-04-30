package com.example.bookshelf.ui.data

import com.example.bookshelf.ui.model.BookPhoto
import com.example.bookshelf.ui.network.BookshelfApiService

interface BookshelfRepository{
    suspend fun getBookPhotos(): List<BookPhoto>
}

class NetworkBookPhotosRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfRepository {
    override suspend fun getBookPhotos(): List<BookPhoto> {
        val response = bookshelfApiService.getPhotos()
        return response.items.mapNotNull { item ->
            val thumbnail = item.volumeInfo.imageLinks?.thumbnail
            if (thumbnail != null) {
                BookPhoto(id = item.id, imgSrc = thumbnail)
            } else null
        }
    }
}