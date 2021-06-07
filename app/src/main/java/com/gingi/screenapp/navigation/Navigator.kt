package com.gingi.screenapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gingi.screenapp.main.MainScreen
import com.gingi.screenapp.second.SecondScreen

@Composable
fun ScreenNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Main.name) {
        composable(Destinations.Main.name) {
            MainScreen(navController = navController, viewModel = hiltViewModel())
        }

        composable(Destinations.Second.name) {
            SecondScreen()
        }
    }
}