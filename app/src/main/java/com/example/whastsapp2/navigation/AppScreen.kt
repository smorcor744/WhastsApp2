package com.example.whastsapp2.navigation

sealed class AppScreen(val route : String) {
    object FirstScreen: AppScreen("FirstScreen")
    object SecondScreen: AppScreen("SecondScreen")
}