package com.example.bookshelf.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.ui.model.BookPhoto

@Composable
fun HomeScreen(
    //bookshelfViewModel: BookshelfViewModel,
    modifier: Modifier = Modifier
) {
//    when(bookshelfUiState){
//        is BookshelfUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is BookshelfUiState.Success -> BookshelfScreen(bookshelfUiState.bookList, modifier)
//        is BookshelfUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
//    }
}

@Composable
fun BookCard(
    bookPhoto: BookPhoto,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = CardDefaults.outlinedCardBorder(),
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(bookPhoto.imgSrc)
                .crossfade(true)
                .build(),
            contentDescription = bookPhoto.id,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BookList(
    books: List<BookPhoto>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = books,
            key = { book -> book.id }
        ){
            book -> BookCard(
                bookPhoto = book,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}