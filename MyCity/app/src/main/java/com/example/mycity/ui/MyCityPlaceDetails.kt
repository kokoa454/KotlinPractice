package com.example.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 36.sp),
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

@Preview
@Composable
fun PlaceDetailsPreview(){
    PlaceDetailsList(
        place = places.first(),
    )
}