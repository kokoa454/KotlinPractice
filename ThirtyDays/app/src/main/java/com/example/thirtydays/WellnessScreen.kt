package com.example.thirtydays

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.thirtydays.model.Wellness
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydays.data.Datasource

@Composable
fun WellnessCard(dayNumber: Int, wellness: Wellness, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxWidth()
        .shadow(elevation = 4.dp)
        .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Day $dayNumber",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(
                    bottom = 8.dp
                )
            )
            Text(
                text = stringResource(wellness.wellnessName),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    bottom = 4.dp
                )
            )
            Text(
                text = stringResource(wellness.wellnessDescription),
                style = MaterialTheme.typography.labelLarge
            )

        }
    }
}

@Composable
fun WellnessList(wellnessList: List<Wellness>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(wellnessList) { wellness ->
            WellnessCard(dayNumber = wellnessList.indexOf(wellness) + 1, wellness = wellness, modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessCardPreview(){
    WellnessCard(1, Wellness(R.string.wellness_1, R.string.wellness_1_description))
}

@Preview(showBackground = true)
@Composable
fun WellnessListPreview(){
    WellnessList(wellnessList = Datasource().loadWellness())
}