package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { MyCityTopAppBar() },
    ){ innerPadding ->
        MyCityHomeScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}