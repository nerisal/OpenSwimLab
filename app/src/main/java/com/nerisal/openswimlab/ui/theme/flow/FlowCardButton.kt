package com.nerisal.openswimlab.ui.theme.flow

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.OpenInNew
import androidx.compose.material.icons.sharp.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

@Composable
fun FlowCardButton(
    item: FlowCardItem,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current

    val onClick: () -> Unit = when (val action = item.action) {
        is FlowCardAction.Link -> {
            { context.startActivity(Intent(Intent.ACTION_VIEW, action.url.toUri())) }
        }

        is FlowCardAction.Navigate -> action.onClick
        is FlowCardAction.Toggle -> {
            { action.onCheckedChange(!action.checked) }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                role = Role.Button,
                onClick = onClick
            )
            .padding(contentPadding)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .size(FlowSizes.IconBoxMedium)
                    .background(
                        colorScheme.background,
                        RoundedCornerShape(
                            concentricRadius(
                                FlowShapesDefaults.smoothRadius,
                                FlowSpacing.Small
                            )
                        )
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = colorScheme.onPrimary,
                    modifier = Modifier
                        .size(FlowSizes.IconMedium)
                )
            }


            Text(modifier = Modifier.padding(FlowSpacing.Small, 0.dp), text = item.label)
        }


        when (val action = item.action) {
            is FlowCardAction.Link -> Icon(
                Icons.AutoMirrored.Sharp.OpenInNew,
                contentDescription = null
            )

            is FlowCardAction.Navigate -> Icon(Icons.Sharp.ChevronRight, contentDescription = null)
            is FlowCardAction.Toggle -> Switch(
                checked = action.checked,
                onCheckedChange = null
            )
        }
    }
}

sealed interface FlowCardAction {
    data class Link(val url: String) : FlowCardAction
    data class Toggle(val checked: Boolean, val onCheckedChange: (Boolean) -> Unit) : FlowCardAction
    data class Navigate(val onClick: () -> Unit) : FlowCardAction
}