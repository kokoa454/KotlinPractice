package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import com.example.mycity.R
import com.example.mycity.data.CategoryList.categories
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mycity.data.PlaceList.places
import com.example.mycity.ui.utils.MyCityContentType

enum class MyCityScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Place(title = R.string.place),
    PlaceDetails(title = R.string.place_details)
}

@Composable
fun MyCityNavHost(
    navController: NavHostController,
    contentType: MyCityContentType,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = MyCityScreen.Start.name,
        modifier = modifier
    ){
        if(contentType == MyCityContentType.LIST_ONLY){
            composable(route = MyCityScreen.Start.name){
                CategoryList(
                    categories = categories,
                    onClicked = { category ->
                        navController.navigate("${MyCityScreen.Place.name}/${category.name}")
                    }
                )
            }
            composable(
                route = "${MyCityScreen.Place.name}/{type}",
                arguments = listOf(navArgument("type") { type = NavType.StringType })
            ) { backStackEntry ->
                val type = backStackEntry.arguments?.getString("type") ?: ""
                PlaceList(
                    places = places.filter { it.type == type },
                    type = type,
                    onClicked = { place ->
                        navController.navigate("${MyCityScreen.PlaceDetails.name}/${place.name}")
                    }
                )
            }
            composable(
                route = "${MyCityScreen.PlaceDetails.name}/{name}",
                arguments = listOf(navArgument("name") { type = NavType.StringType })
            ){ backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                PlaceDetailsList(
                    place = places.first { it.name == name },
                )
            }
        } else {
            composable(route = MyCityScreen.Start.name){
                CategoryListForExpanded(
                    categories = categories,
                    onClicked = { category ->
                        navController.navigate("${MyCityScreen.Place.name}/${category.name}")
                    }
                )
            }
            composable(
                route = "${MyCityScreen.Place.name}/{type}",
                arguments = listOf(navArgument("type") { type = NavType.StringType })
            ) { backStackEntry ->
                val type = backStackEntry.arguments?.getString("type") ?: ""
                val filteredPlaces = places.filter { it.type == type }
                val selectedPlace = filteredPlaces.find { it.name == navController.currentBackStackEntry?.arguments?.getString("name") } ?: filteredPlaces.first()

                ListAndDetails(
                    places = filteredPlaces,
                    selectedPlace = selectedPlace,
                    type = type
                )
            }
        }
    }
}