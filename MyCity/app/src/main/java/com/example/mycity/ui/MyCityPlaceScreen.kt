package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.model.Place
import com.example.mycity.data.PlaceData.places_nature_sightseeing

@Composable
fun PlaceListItem(
    place: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onItemClick(place) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ){
            Image(
                painter = painterResource(place.image),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(8.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun PlaceList(
    places: List<Place>,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        items(places) { place ->
            PlaceListItem(
                place = place,
                onItemClick = onItemClick,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PlaceListItemPreview(){
    val place = places_nature_sightseeing.first()
    PlaceListItem(
        place = place,
        onItemClick = {}
    )
}

@Preview
@Composable
fun PlaceListPreview(){
    PlaceList(
        places = places_nature_sightseeing,
        onItemClick = {}
    )
}