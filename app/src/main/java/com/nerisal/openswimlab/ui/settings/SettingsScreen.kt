package com.nerisal.openswimlab.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AcUnit
import androidx.compose.material.icons.sharp.AddToDrive
import androidx.compose.material.icons.sharp.BugReport
import androidx.compose.material.icons.sharp.Code
import androidx.compose.material.icons.sharp.Handyman
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Policy
import androidx.compose.material.icons.sharp.WaterDrop
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nerisal.openswimlab.ui.theme.flow.FlowCardButtonsGroup
import com.nerisal.openswimlab.ui.theme.flow.FlowCardItem

@Composable
fun SettingsScreen(
    onDebugClick: () -> Unit,
    onBack:() -> Unit,
) {
    val general = listOf(
        FlowCardItem(Icons.Sharp.WaterDrop, "PROVA", {}),
        FlowCardItem(Icons.Sharp.Handyman, "PROVA", {}),
        FlowCardItem(Icons.Sharp.AcUnit, "PROVA", {},),
        FlowCardItem(Icons.Sharp.AddToDrive, "PROVA", {},),
    )

    val about = listOf(
        FlowCardItem(Icons.Sharp.Info, "Version", {}),
        FlowCardItem(Icons.Sharp.Policy, "License", {}),
        FlowCardItem(Icons.Sharp.Code, "Source Code", {}),
        FlowCardItem(Icons.Sharp.BugReport, "Bug Report", {})
    )
    general
    Column(modifier = Modifier.padding(24.dp)) {
        Text("General")
        FlowCardButtonsGroup(general)

        Text("About")
        FlowCardButtonsGroup(about)
    }
}