package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.theme.MyCityNavHost

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { MyCityTopAppBar() },
    ){ innerPadding ->
        val navController: NavHostController = rememberNavController()

        MyCityNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}