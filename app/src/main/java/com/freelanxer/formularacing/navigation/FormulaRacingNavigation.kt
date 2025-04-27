package com.freelanxer.formularacing.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freelanxer.formularacing.ui.screen.home.HomeScreen
import com.freelanxer.formularacing.ui.theme.ScreenCommonBackground

@Composable
fun FormulaRacingNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FormulaRacingScreens.HomeScreen.route
    ) {
        composable(route = FormulaRacingScreens.HomeScreen.route) {
            HomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ScreenCommonBackground),
                navController = navController
            )
        }
    }
}