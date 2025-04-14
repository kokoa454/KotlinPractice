package com.example.mycity.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.data.CategoryList.categories
import com.example.mycity.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopAppBar(
    title: String = stringResource(R.string.app_name),
    canNavigateBack: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        navigationIcon = {
            if(canNavigateBack){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun CategoryListItem(
    category: Category,
    onClicked: (Category) -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        onClick = {
            onClicked(category)
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 36.sp)
            )
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp, end = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.atr_black),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = category.number.toString(),
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryList(
    categories: List<Category>,
    onClicked: (Category) -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.padding(24.dp)
){
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(categories.size) { index ->
            CategoryListItem(
                category = categories[index],
                onClicked = onClicked,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun MyCityTopAppBarPreview(){
    MyCityTopAppBar()
}

@Preview
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(
        category = categories.first()
    )
}

@Preview
@Composable
fun CategoryListPreview() {
    CategoryList(
        categories = categories
    )
}