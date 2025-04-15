package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route?.substringBefore("/")
    val currentScreen = MyCityScreen.entries.find { it.name == currentRoute } ?: MyCityScreen.Start

    Scaffold(
        topBar = { MyCityTopAppBar(
            title = stringResource(currentScreen.title),
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        ) },
    ){ innerPadding ->
        MyCityNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}