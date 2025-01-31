package com.freelanxer.formularacing.navigation

sealed class FormulaRacingScreens(
    val route: String
) {
    data object HomeScreen : FormulaRacingScreens(route = "home")
}