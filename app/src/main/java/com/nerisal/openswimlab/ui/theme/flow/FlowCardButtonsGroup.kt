package com.nerisal.openswimlab.ui.theme.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class FlowCardItem (
    val action: FlowCardAction,
    val icon: ImageVector,
    val label: String,
    val hidden: Boolean = false,
)

@Composable
fun FlowCardButtonsGroup(
    items: List<FlowCardItem>,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(modifier = modifier
        .background(colorScheme.surface, RoundedCornerShape(FlowShapesDefaults.smoothRadius)),
        verticalArrangement = Arrangement.SpaceAround) {
        items.forEachIndexed { index, item ->
            FlowCardButton(
                item,
                contentPadding = contentPaddingByIndex(index, items.count(), FlowSpacing.Small),
            )
        }
    }
}