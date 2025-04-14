package com.example.mycity.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.data.PlaceList.places
import com.example.mycity.model.Place

@Composable
fun PlaceListItem(
    place: Place,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 36.sp,
                    lineHeight = 48.sp
                    )
            )
        }
    }
}

@Composable
fun PlaceList(
    places: List<Place>,
    type: String,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(places.size) { index ->
            if(places[index].type == type){
                PlaceListItem(
                    place = places[index],
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PlaceListItemPreview() {
    PlaceListItem(
        place = places.first()
    )
}

@Preview
@Composable
fun PlaceListPreview() {
    PlaceList(
        places = places,
        type = "観光"
    )
}