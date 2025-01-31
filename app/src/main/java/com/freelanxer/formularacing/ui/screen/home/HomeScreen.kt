package com.freelanxer.formularacing.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.freelanxer.formularacing.R
import com.freelanxer.formularacing.ui.component.MeetingItemView
import com.freelanxer.formularacing.ui.component.RacingAppBar
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
            MeetingOverview()
        }
    }
}

@Composable
fun MeetingOverview(
    viewModel: HomeViewModel = koinViewModel()
) {
    val meetingList = viewModel.meetingList.collectAsState().value
    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        itemsIndexed(meetingList) { index, item ->
            MeetingItemView(
                meeting = item,
                isFirstItem = index == 0
            ) {

            }
        }
    }

}