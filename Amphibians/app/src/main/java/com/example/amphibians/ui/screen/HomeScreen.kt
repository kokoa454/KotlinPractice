package com.example.amphibians.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.ui.model.AmphibiansPhoto

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
){
//    when(amphibiansUiState){
//        is AmphibiansUiState.Loading -> /*Todo*/
//        is AmphibiansUiState.Success -> /*Todo*/
//        is AmphibiansUiState.Error -> /*Todo*/
//    }
}

@Composable
fun AmphibiansCard(
    amphibiansPhoto: AmphibiansPhoto,
    modifier: Modifier = Modifier
){
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = amphibiansPhoto.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = 8.dp),
                )
                Text(
                    text = amphibiansPhoto.type,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier,
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibiansPhoto.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = amphibiansPhoto.name,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.loading),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = amphibiansPhoto.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
            )
        }
    }
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