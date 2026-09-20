package com.nerisal.openswimlab.ui.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

@Composable
fun FlowBackground (
    modifier: Modifier = Modifier,
    ) {
    val colorScheme = MaterialTheme.colorScheme

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                listOf(
                    colorScheme.background,
                    colorScheme.surfaceDim
                )
            )
        )
    ) {
    }
}