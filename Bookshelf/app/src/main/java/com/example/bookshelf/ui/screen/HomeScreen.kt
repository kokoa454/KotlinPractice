package com.example.bookshelf.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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