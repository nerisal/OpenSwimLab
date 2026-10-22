package com.nerisal.openswimlab.ui.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nerisal.openswimlab.ui.theme.flow.FlowShapesDefaults
import com.nerisal.openswimlab.ui.theme.flow.FlowSpacing

@Composable
fun AnalyticsScreen() {

    val colorScheme = MaterialTheme.colorScheme

    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).padding(FlowSpacing.Medium)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.surface, RoundedCornerShape(FlowShapesDefaults.smoothRadius))
                .padding(20.dp)
        ) {
            Text("Analytics Screen")
        }
    }
}