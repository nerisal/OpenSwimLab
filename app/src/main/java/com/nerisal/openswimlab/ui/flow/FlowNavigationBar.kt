package com.nerisal.openswimlab.ui.flow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Analytics
import androidx.compose.material.icons.sharp.AreaChart
import androidx.compose.material.icons.sharp.EmojiEvents
import androidx.compose.material.icons.sharp.FormatListNumbered
import androidx.compose.material.icons.sharp.Pool
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.Upload
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FlowNavigationBar(
    modifier: Modifier? = Modifier,
) {
    BottomAppBar(
        containerColor = Color.Transparent,
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                FlowNavigationButton(
                    onClick = { /* Do something */},
                    text = "Workouts",
                    imageVector = Icons.Sharp.Pool,
                    contentDescription = "Workouts",
                )

                FlowNavigationButton(
                    onClick = { /* Do something */},
                    text = "Analytics",
                    imageVector = Icons.Sharp.Analytics,
                    contentDescription = "Analytics",
                )

                FlowNavigationButton(
                    onClick = { /* Do something */},
                    text = "Records",
                    imageVector = Icons.Sharp.EmojiEvents,
                    contentDescription = "Records",
                )

                FlowNavigationButton(
                    onClick = { /* Do something */},
                    text = "Settings",
                    imageVector = Icons.Sharp.Settings,
                    contentDescription = "Settings",
                )
            }



        }
    )
}
