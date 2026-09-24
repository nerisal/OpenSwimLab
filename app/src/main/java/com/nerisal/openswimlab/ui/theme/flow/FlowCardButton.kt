package com.nerisal.openswimlab.ui.theme.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FlowCardButton (
    imageVector: ImageVector,
    text: String,
    onClick: () -> Unit,
    verticalSpacing: PaddingValues,
){
    val colorScheme = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(verticalSpacing),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Box(
            modifier = Modifier
                .size(FlowSizes.IconBoxMedium)
                .background(colorScheme.background, RoundedCornerShape(concentricRadius(FlowShapesDefaults.smoothRadius, FlowSpacing.Small))),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = colorScheme.onPrimary,
                modifier = Modifier
                    .size(FlowSizes.IconMedium)
            )
        }


        Text(modifier = Modifier.padding(FlowSpacing.Small, 0.dp).fillMaxWidth(), text = text,)
    }
}