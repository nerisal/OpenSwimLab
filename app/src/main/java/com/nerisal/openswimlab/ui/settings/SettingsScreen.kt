package com.nerisal.openswimlab.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AcUnit
import androidx.compose.material.icons.sharp.AddToDrive
import androidx.compose.material.icons.sharp.BubbleChart
import androidx.compose.material.icons.sharp.BugReport
import androidx.compose.material.icons.sharp.Code
import androidx.compose.material.icons.sharp.DeveloperMode
import androidx.compose.material.icons.sharp.Handyman
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Policy
import androidx.compose.material.icons.sharp.TableBar
import androidx.compose.material.icons.sharp.WaterDrop
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nerisal.openswimlab.ui.theme.flow.FlowCardAction
import com.nerisal.openswimlab.ui.theme.flow.FlowCardButtonsGroup
import com.nerisal.openswimlab.ui.theme.flow.FlowCardItem
import com.nerisal.openswimlab.ui.theme.flow.FlowSpacing

@Composable
fun SettingsScreen(
    onDebugClick: () -> Unit,
    onBack:() -> Unit,
) {
    val general = listOf({})
    var showDevOptions by remember { mutableStateOf(false) }

    val about = listOf(
        FlowCardItem(
            icon = Icons.Sharp.Code,
            label = "Repository",
            action = FlowCardAction.Link("https://github.com/")
        ),
        FlowCardItem(
            icon = Icons.Sharp.DeveloperMode,
            label = "Developer Options",
            action = FlowCardAction.Toggle(checked = showDevOptions, onCheckedChange = {showDevOptions = !showDevOptions}),
        ),
        FlowCardItem(
            icon = Icons.Sharp.TableBar,
            label = "Developer Screen",
            action = FlowCardAction.Navigate({}),
            hidden = !showDevOptions
        )
    )

    Column(modifier = Modifier.padding(FlowSpacing.Medium), verticalArrangement = Arrangement.SpaceEvenly) {
        Text(modifier = Modifier.padding(FlowSpacing.Small), text = "General")

        Text(modifier = Modifier.padding(FlowSpacing.Small), text = "App")
        FlowCardButtonsGroup(about.filter {!it.hidden})
    }
}