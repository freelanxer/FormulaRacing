package com.freelanxer.formularacing.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.freelanxer.formularacing.R
import com.freelanxer.formularacing.extension.DateFormatPattern
import com.freelanxer.formularacing.extension.dateFormat
import com.freelanxer.formularacing.model.sessions.RacingSession
import com.freelanxer.formularacing.model.sessions.SessionMeeting
import com.freelanxer.formularacing.ui.theme.RacingTextContentTitle
import com.freelanxer.formularacing.ui.theme.RacingTextSecondTitle
import com.freelanxer.formularacing.ui.theme.RacingTextTitle

@Composable
fun MeetingItemView(
    meeting: SessionMeeting,
    isFirstItem: Boolean = false,
    onClicked: (SessionMeeting) -> Unit = {},
) {
    var isExpand by rememberSaveable { mutableStateOf(false) }
    val rotateAngle by animateFloatAsState(
        targetValue = if (isExpand) 180f else 0f,
        label = "rotate"
    )

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = if (isFirstItem) 16.dp else 0.dp,
                bottom = 16.dp
            )
            .shadow(
                elevation = 5.dp,
                shape = MaterialTheme.shapes.large
            )
            .clickable { onClicked.invoke(meeting) },
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            val circuit = CircuitType.fromCircuitKey(meeting.circuitKey!!)
            val background = circuit?.backgroundResId ?: R.drawable.bg_uae_70
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(background),
                contentDescription = "Circuit background"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 100.dp)
                    .padding(top = 16.dp, bottom = 0.dp, start = 16.dp, end = 16.dp),
            ) {
                // Circuit icon
                circuit?.let {
                    Image(
                        modifier = Modifier.align(Alignment.TopEnd),
                        painter = painterResource(it.iconResId),
                        contentDescription = "Circuit"
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    Text(
                        text = meeting.meetingName ?: "",
                        style = RacingTextTitle
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = meeting.year.toString(),
                            style = RacingTextSecondTitle
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = meeting.locationName ?: "",
                            style = RacingTextSecondTitle
                        )
                    }

                    AnimatedVisibility(visible = isExpand) {
                        Column {
                            Spacer(modifier = Modifier.height(16.dp))
                            meeting.sessionList?.forEach {
                                SessionDataTimeView(it)
                            }
                        }
                    }

                    IconButton(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        onClick = {
                            isExpand = !isExpand
                        }
                    ) {
                        Icon(
                            modifier = Modifier.rotate(rotateAngle),
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expandable arrow"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SessionDataTimeView(
    session: RacingSession,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = session.sessionName,
            style = RacingTextContentTitle
        )
        Text(
            text = session.dateStart.dateFormat(
                inputFormat = DateFormatPattern.UTC_ISO_8601,
                outputFormat = DateFormatPattern.MMDDHHMM
            )
        )
    }
}