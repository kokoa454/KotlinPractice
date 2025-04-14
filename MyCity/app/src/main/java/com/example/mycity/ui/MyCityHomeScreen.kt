package com.example.mycity.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.data.CategoryList.categories
import com.example.mycity.model.Category

@Composable
fun MyCityHomeScreen(
    modifier: Modifier = Modifier
){

}

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
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = { /*TODO*/ },
        modifier = modifier
    )
}

@Composable
fun CategoryListItem(
    category: Category,
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
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 36.sp)
            )
        }
    }
}

@Composable
fun CategoryList(
    categories: List<Category>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(categories.size) { index ->
            CategoryListItem(
                category = categories[index],
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