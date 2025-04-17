package com.example.mycity.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.model.Place
import com.example.mycity.data.PlaceList.places

@Composable
fun PlaceDetailsList(
    place: Place,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = place.name,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
                lineHeight = 48.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
        )
        Text(
            text = place.description,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 24.sp,
                lineHeight = 32.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ListAndDetails(
    places: List<Place>,
    selectedPlace: Place,
    type: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    var place by remember { mutableStateOf(selectedPlace) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        PlaceList(
            places = places,
            type = type,
            onClicked = { clickedPlace ->
                place = clickedPlace
            },
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(2f)
        )
        PlaceDetailsList(
            place = place,
            modifier = Modifier.weight(3f)
        )
    }
}


@Preview
@Composable
fun PlaceDetailsPreview(){
    PlaceDetailsList(
        place = places.first(),
    )
}

@Preview(
    widthDp = 600,
    heightDp = 400
)
@Composable
fun ListAndDetailsPreview() {
    ListAndDetails(
        places = places,
        type = "観光",
        selectedPlace = places.first()
    )
}