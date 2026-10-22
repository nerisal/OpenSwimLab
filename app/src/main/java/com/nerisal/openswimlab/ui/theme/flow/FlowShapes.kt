package com.nerisal.openswimlab.ui.theme.flow

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
// For future use
fun buttonShapeByIndex(
    index: Int,
    count: Int,

    smoothRadius: Dp = FlowShapesDefaults.smoothRadius,
    sharpRadius: Dp = FlowShapesDefaults.sharpRadius

): RoundedCornerShape {
    val isTop = index == 0
    val isBottom = index == count - 1

    val topRadius = if (isTop) smoothRadius else sharpRadius
    val bottomRadius = if (isBottom) smoothRadius else sharpRadius

    return RoundedCornerShape(
        topStart = topRadius,
        topEnd = topRadius,
        bottomEnd = bottomRadius,
        bottomStart = bottomRadius
    )
}

@Composable
fun contentPaddingByIndex(
    index: Int,
    count: Int,

    spacing: Dp,
): PaddingValues {

    // For future use
    val isTop = index == 0

    val isBottom = index == count - 1

    return if (isBottom) {
        PaddingValues(
            top = spacing,
            bottom = spacing,
            start = spacing,
            end = spacing
        )
    } else {
        PaddingValues(
            top = spacing,
            bottom = 0.dp,
            start = spacing,
            end = spacing
        )
    }

}

fun concentricRadius(outer: Dp, inset: Dp): Dp = (outer - inset).coerceAtLeast(0.dp)