package com.freelanxer.formularacing.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freelanxer.formularacing.ui.screen.home.HomeScreen

@Composable
fun FormulaRacingNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FormulaRacingScreens.HomeScreen.route
    ) {
        composable(route = FormulaRacingScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}