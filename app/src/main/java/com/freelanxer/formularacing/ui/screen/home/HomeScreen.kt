package com.freelanxer.formularacing.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.freelanxer.formularacing.R
import com.freelanxer.formularacing.dsl.Action
import com.freelanxer.formularacing.dsl.Invoke
import com.freelanxer.formularacing.ui.component.HorizontalSpacer
import com.freelanxer.formularacing.ui.component.MeetingItemView
import com.freelanxer.formularacing.ui.component.RacingAppBar
import com.freelanxer.formularacing.ui.component.TeamItemView
import com.freelanxer.formularacing.ui.component.TeamType
import com.freelanxer.formularacing.ui.component.VerticalSpacer
import com.freelanxer.formularacing.ui.theme.Color1C1B1F
import com.freelanxer.formularacing.ui.theme.ColorFAFAFA
import com.freelanxer.formularacing.ui.theme.RacingTextTitle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    sessionClicked: Action<Int>,
) {
    val meetingList = viewModel.meetingList.collectAsState().value
    val teamList = TeamType.teams

    Scaffold(
        modifier = modifier,
        topBar = {
            RacingAppBar(
                title = stringResource(R.string.screen_home),
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = ColorFAFAFA)
                .padding(paddingValues)
        ) {
            item { VerticalSpacer(16.dp) }
            item {
                IconTitle(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = stringResource(R.string.teams),
                    icon = Icons.Default.Check
                )
                VerticalSpacer(16.dp)
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(teamList) { index, item ->
                        TeamItemView(
                            team = item,
                            isFirstItem = index == 0
                        )
                    }
                }
                VerticalSpacer(24.dp)
            }
            item {
                IconTitle(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = stringResource(R.string.racing_sessions),
                    icon = Icons.Default.DateRange
                )
            }
            itemsIndexed(meetingList) { index, item ->
                MeetingItemView(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    meeting = item,
                    isFirstItem = index == 0
                ) {
                    item.meetingKey?.let {
                        sessionClicked.invoke(it)
                    }
                }
            }
        }
    }
}

@Composable
fun IconTitle(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = it,
                tint = Color1C1B1F,
                contentDescription = "Title icon"
            )
            HorizontalSpacer(8.dp)
        }
        Text(
            text = text,
            style = RacingTextTitle
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFAFAFA)
@Composable
private fun IconTitlePreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        IconTitle(
            text = "Overview",
            icon = Icons.Default.DateRange
        )
    }
}