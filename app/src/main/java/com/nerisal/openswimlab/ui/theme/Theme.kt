package com.nerisal.openswimlab.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = FlowCyanLight,
    secondary = FlowCyan,
    tertiary = FlowNavyLight,
    background = FlowNavyDark,
    surface = FlowNavyMid,
    surfaceDim = FlowNavy,
    onPrimary = White,
    onSecondary = FlowNavyDark,
    onTertiary = White,
    onBackground = White,
    onSurface = White,
    error = FlowCoral
)

private val LightColorScheme = lightColorScheme(
    primary = FlowNavyLight,
    secondary = FlowWhite,
    tertiary = FlowCyan,
    background = FlowWhite,
    surface = White,
    surfaceDim = White,
    onPrimary = FlowNavyDark,
    onSecondary = FlowNavyDark,
    onTertiary = FlowNavyDark,
    onBackground = FlowNavyDark,
    onSurface = FlowNavyDark,
    error = FlowCoral,

)

@Composable
fun OpenSwimLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}