package com.example.amphibians.ui.screen

import android.os.Build.VERSION.SDK_INT
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL
import com.example.amphibians.R
import com.example.amphibians.ui.model.AmphibiansPhoto

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
){
    when(amphibiansUiState){
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxWidth())
        is AmphibiansUiState.Success -> AmphibiansList(amphibiansPhoto = amphibiansUiState.amphibians, modifier = modifier)
        is AmphibiansUiState.Error -> ErrorScreen(modifier = modifier.fillMaxWidth())
    }
}

enum class AmphibiansCardState {
    LOADING,
    ERROR,
    SUCCESS
}

@Composable
fun AmphibiansCard(
    amphibiansPhoto: AmphibiansPhoto,
    modifier: Modifier = Modifier
){
    var cardState by remember { mutableStateOf(AmphibiansCardState.LOADING) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = CardDefaults.outlinedCardBorder(),
    ) {
        Column{
            Text(
                text = amphibiansPhoto.name + " (" + amphibiansPhoto.type + ")",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            when (cardState) {
                AmphibiansCardState.LOADING -> {
                    val context = LocalContext.current
                    LoadingScreen()
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(amphibiansPhoto.imgSrc)
                            .crossfade(true)
                            .build(),
                        onSuccess = { cardState = AmphibiansCardState.SUCCESS},
                        onError = { cardState = AmphibiansCardState.ERROR },
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                AmphibiansCardState.SUCCESS -> {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(amphibiansPhoto.imgSrc)
                            .crossfade(true)
                            .build(),
                        contentDescription = amphibiansPhoto.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                AmphibiansCardState.ERROR -> {
                    ErrorScreen()
                }
            }

            Text(
                text = amphibiansPhoto.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun AmphibiansList(
    amphibiansPhoto: List<AmphibiansPhoto>,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = amphibiansPhoto,
            key = { photo -> photo.name }
        ) { photo ->
            AmphibiansCard(
                amphibiansPhoto = photo,
                modifier = Modifier
                    .padding(4.dp)
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
    val imageLoader = ImageLoader.Builder(context)
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

@Preview
@Composable
fun AmphibiansCardPreview(){
    AmphibiansCard(
        AmphibiansPhoto(
            name = "name",
            type = "type",
            description = "description",
            imgSrc = "imgSrc"
        )
    )
}

@Preview
@Composable
fun AmphibiansListPreview(){
    AmphibiansList(
        amphibiansPhoto = listOf(
            AmphibiansPhoto(
                name = "name1",
                type = "type1",
                description = "description1",
                imgSrc = "imgSrc1"
            ),
            AmphibiansPhoto(
                name = "name2",
                type = "type2",
                description = "description2",
                imgSrc = "imgSrc2"
            )
        )
    )
}