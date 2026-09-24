package com.nerisal.openswimlab.ui.theme.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class FlowCardItem (
    val icon: ImageVector,
    val label: String,
    val onClick: () -> Unit
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
                imageVector = item.icon,
                text = item.label,
                onClick = item.onClick,
                verticalSpacing = verticalSpacingByIndex(index, items.count(), FlowSpacing.Small),
            )
        }
    }
}