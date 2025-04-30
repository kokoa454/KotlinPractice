package com.example.bookshelf.ui.screen

import android.os.Build.VERSION.SDK_INT
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader.*
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL
import com.example.bookshelf.R
import com.example.bookshelf.ui.model.BookPhoto

@Composable
fun HomeScreen(
    //bookshelfUiState: BookshelfUiState,
    modifier: Modifier = Modifier
) {
//    when(bookshelfUiState){
//        is BookshelfUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is BookshelfUiState.Success -> BookList(bookshelfUiState.bookList, modifier)
//        is BookshelfUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
//    }
}

enum class BookCardState {
    LOADING,
    ERROR,
    SUCCESS
}

@Composable
fun BookCard(
    bookPhoto: BookPhoto,
    modifier: Modifier = Modifier
){
    var cardState by remember { mutableStateOf(BookCardState.LOADING) }


    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = CardDefaults.outlinedCardBorder(),
    ){
        when (cardState) {
            BookCardState.LOADING -> {
                LoadingScreen()
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(bookPhoto.imgSrc)
                        .crossfade(true)
                        .build(),
                    onSuccess = { cardState = BookCardState.SUCCESS},
                    onError = { cardState = BookCardState.ERROR },
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            BookCardState.SUCCESS -> {
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
            BookCardState.ERROR -> {
                ErrorScreen()
            }
        }
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

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        GIFImage(
            gifImage = R.drawable.loading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        GIFImage(
            gifImage = R.drawable.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun GIFImage(
    modifier: Modifier = Modifier,
    @DrawableRes gifImage: Int,
) {
    val context = LocalContext.current
    val imageLoader = Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = gifImage).apply(block = {
                size(ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}