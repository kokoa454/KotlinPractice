package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.data.CategoryData.categories
import com.example.mycity.model.Category

@Composable
fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onItemClick(category) },
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
                painter = painterResource(category.image),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(2f)
            )
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(8.dp)
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if(isSystemInDarkTheme()){
                        Image(
                            painter = painterResource(R.drawable.atr_white),
                            contentDescription = "atr",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(20.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.atr_black),
                            contentDescription = "atr",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                    Text(
                        text = category.number,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList(
    categories: List<Category>,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        items(categories) { category ->
            CategoryListItem(
                category = category,
                onItemClick = onItemClick,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CategoryListItemPreview(){
    val category = categories.first()
    CategoryListItem(
        category = category,
        onItemClick = {}
    )
}

@Preview
@Composable
fun CategoryListPreview(){
    CategoryList(
        categories = categories,
        onItemClick = {}
    )
}