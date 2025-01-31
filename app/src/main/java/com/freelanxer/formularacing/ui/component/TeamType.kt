package com.freelanxer.formularacing.ui.component

import com.freelanxer.formularacing.R

sealed class TeamType(
    val teamName: String,
    val cardImageId: Int,
    val teamColor: Long
) {
    data object RedBullRacing : TeamType(teamName = "Red Bull Racing", cardImageId = R.drawable.bg_team_car_red_bull_racing, teamColor = 0xFF3671C6)
    data object Williams : TeamType(teamName = "Williams", cardImageId = R.drawable.bg_team_car_williams, teamColor = 0xFF37BEDD)
    data object McLaren : TeamType(teamName = "McLaren", cardImageId = R.drawable.bg_team_car_mclaren, teamColor = 0xFFF58020)
    data object Alpine : TeamType(teamName = "Alpine", cardImageId = R.drawable.bg_team_car_alpine, teamColor = 0xFF2293D1)
    data object AstonMartin : TeamType(teamName = "Aston Martin", cardImageId = R.drawable.bg_team_car_aston_martin, teamColor = 0xFF358C75)
    data object Ferrari : TeamType(teamName = "Ferrari", cardImageId = R.drawable.bg_team_car_ferrari, teamColor = 0xFFF91536)
    data object Haas : TeamType(teamName = "Haas", cardImageId = R.drawable.bg_team_car_haas, teamColor = 0xFFB6BABD)
    data object RB : TeamType(teamName = "Racing Bulls", cardImageId = R.drawable.bg_team_car_racing_bulls, teamColor = 0xFF6692FF)
    data object KickSauber : TeamType(teamName = "Kick Sauber", cardImageId = R.drawable.bg_team_car_kick_sauber, teamColor = 0xFF52E252)
    data object Mercedes : TeamType(teamName = "Mercedes", cardImageId = R.drawable.bg_team_car_mercedes, teamColor = 0xFF27F4D2)

    companion object {
        val teams = listOf(
            McLaren,
            RedBullRacing,
            Mercedes,
            Williams,
            Alpine,
            AstonMartin,
            Ferrari,
            Haas,
            RB,
            KickSauber,
        )
    }
}