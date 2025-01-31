package com.freelanxer.formularacing.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freelanxer.formularacing.ui.theme.DarkRed

@Preview(showBackground = true)
@Composable
fun RacingAppBar(
    title: String = "Title",
    backgroundColor: Color = DarkRed,
    navIcon: ImageVector? = null,
    onNavIconClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .statusBarsPadding()
    ) {
        TopAppBar(
            backgroundColor = DarkRed,
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars),
            elevation = 0.dp,
            title = {
                Text(text = title, color = Color.White)
            },
            navigationIcon = if (navIcon != null) {
                {
                    Icon(
                        imageVector = navIcon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                onNavIconClicked.invoke()
                            }
                    )
                }
            } else null
        )
    }
}