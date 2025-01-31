package com.freelanxer.formularacing.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamItemView(
    team: TeamType = TeamType.RB,
    isFirstItem: Boolean = false,
    onClicked: (TeamType) -> Unit = {}
) {
    ElevatedCard(
        modifier = Modifier
            .size(width = 250.dp, height = 100.dp)
            .padding(
                start = if (isFirstItem) 20.dp else 0.dp,
                end = 16.dp
            )
            .shadow(
                elevation = 5.dp,
                shape = MaterialTheme.shapes.large
            )
            .clickable { onClicked.invoke(team) },
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(team.cardImageId),
                contentDescription = null
            )
            Text(
                text = team.teamName,
                fontSize = 16.sp,
                color = Color(team.teamColor),
                fontWeight = FontWeight.Bold
            )
        }
    }
}