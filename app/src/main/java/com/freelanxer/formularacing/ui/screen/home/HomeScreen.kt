package com.freelanxer.formularacing.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.freelanxer.formularacing.R
import com.freelanxer.formularacing.ui.component.MeetingItemView
import com.freelanxer.formularacing.ui.component.RacingAppBar
import com.freelanxer.formularacing.ui.component.TeamItemView
import com.freelanxer.formularacing.ui.component.TeamType
import com.freelanxer.formularacing.ui.theme.RacingTextTitle
import com.freelanxer.formularacing.ui.theme.ScreenCommonBackground
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            RacingAppBar(
                title = stringResource(R.string.screen_home),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(ScreenCommonBackground)
        ) {
            RacingOverview()
        }
    }
}

@Composable
fun RacingOverview(
    viewModel: HomeViewModel = koinViewModel()
) {
    val meetingList = viewModel.meetingList.collectAsState().value
    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        item {
            Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                OverviewTitle(
                    title = stringResource(R.string.teams),
                    icon = Icons.Default.Check
                )
            }
        }
        item {
            TeamsOverview()
        }
        item {
            Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                OverviewTitle(
                    title = stringResource(R.string.racing_sessions),
                    icon = Icons.Default.DateRange
                )
            }
        }
        itemsIndexed(meetingList) { index, item ->
            Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                MeetingItemView(
                    meeting = item,
                    isFirstItem = index == 0
                ) {

                }
            }
        }
    }
}

@Composable
fun TeamsOverview() {
    LazyRow(
        modifier = Modifier.padding(
            top = 16.dp,
            bottom = 24.dp
        )
    ) {
        itemsIndexed(TeamType.teams) { index, item ->
            TeamItemView(
                team = item,
                isFirstItem = index == 0
            ) {

            }
        }
    }
}

@Composable
fun OverviewTitle(
    title: String,
    icon: ImageVector? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = "Title icon"
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = title,
            style = RacingTextTitle
        )
    }
}