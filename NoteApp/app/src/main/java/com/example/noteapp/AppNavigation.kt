package com.example.noteapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.name) {
        composable(route = Screens.SplashScreen.name) {
            SplashScreen(navController)
        }
        composable(route = Screens.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(route = Screens.GetStartedScreen.name) {
            GetStartedScreen(navController)
        }
        composable(route = Screens.FavoriteScreen.name) {
            FavoriteScreen(navController)
        }
//        composable(route = Screens.CategoryScreen.name) {
//            CategoryScreen(navController)
//        }
//        composable(route = Screens.AddNoteScreen.name) {
//            AddNoteScreen(navController)
//        }
    }
}
