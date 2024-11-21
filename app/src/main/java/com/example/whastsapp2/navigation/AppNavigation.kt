package com.example.whastsapp2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whastsapp2.screens.FirstScreen
import com.example.whastsapp2.screens.SecondScreen


@Composable
fun AppNavigation(modifier: Modifier){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.FirstScreen.route
    ) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(navController, modifier)
        }
        composable(AppScreen.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) {
            SecondScreen(navController, it.arguments?.getString("text"), modifier)
        }
    }

}