package com.nerisal.openswimlab.ui.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FlowNavigationButton(
    onClick: () -> Unit,
    text: String,
    imageVector: ImageVector,
    contentDescription: String?,
) {
    var colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            ),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(

            modifier = Modifier
                .size(width = 70.dp, height = 40.dp)
                .background(
                    color = colorScheme.secondary,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center,

        )
        {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Text(
            text = text,
            color = colorScheme.primary
        )
    }

}