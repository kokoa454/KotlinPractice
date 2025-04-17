package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.utils.MyCityContentType

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route?.substringBefore("/")
    val currentScreen = MyCityScreen.entries.find { it.name == currentRoute } ?: MyCityScreen.Start
    val contentType = when(windowSize){
        WindowWidthSizeClass.Compact -> MyCityContentType.LIST_ONLY
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> MyCityContentType.LIST_AND_DETAIL
        else -> MyCityContentType.LIST_ONLY
    }

    Scaffold(
        topBar = { MyCityTopAppBar(
            title = stringResource(currentScreen.title),
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() }
        ) },
    ){ innerPadding ->
        MyCityNavHost(
            navController = navController,
            contentType = contentType,
            modifier = Modifier.padding(innerPadding)
        )
    }
}