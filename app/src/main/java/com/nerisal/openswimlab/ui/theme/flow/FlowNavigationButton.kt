package com.nerisal.openswimlab.ui.theme.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FlowNavigationButton(
    onClick: () -> Unit,
    text: String,
    imageVector: ImageVector,
    selected: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme

    val textColor = if(selected) colorScheme.primary else colorScheme.onPrimary
    val backgroundColor = if(selected)  colorScheme.secondary else Color.Transparent
    val iconTintColor = if(selected) colorScheme.primary else colorScheme.onPrimary


    Column(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Box(
            modifier = Modifier
                .size(width = 65.dp, height = 35.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center,

        )
        {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .size(FlowSizes.IconLarge)
            )
        }
        Text(
            text = text,
            color = textColor
        )
    }

}