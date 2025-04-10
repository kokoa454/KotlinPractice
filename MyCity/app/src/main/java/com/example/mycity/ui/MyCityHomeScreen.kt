package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.data.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    canNavigateBack: Boolean = false,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        colors = mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onItemClick(category) }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
                .background(color = MaterialTheme.colorScheme.surface)
        ){
            Image(
                painter = painterResource(category.image),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.titleLarge,
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

@Preview
@Composable
fun AppTopBarPreview(){
    AppTopBar()
}

@Preview
@Composable
fun CategoryListItemPreview(){
    CategoryListItem(
        category = Category(LocalContext.current.resources.getStringArray(R.array.category_names)[0],LocalContext.current.resources.getStringArray(R.array.category_numbers)[0], R.drawable.image1),
        onItemClick = {}
    )
}