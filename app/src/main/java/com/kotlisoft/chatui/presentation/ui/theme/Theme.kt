package com.kotlisoft.chatui.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = LightRed,
    primaryVariant = LightWhite,
    onPrimary = TextColor,
    secondary = ThreeDotsColor,
    onSecondary = LightWhite,
    surface = Color.White,
    onSurface = TimestampColor,
    background = Color.White,
)

private val LightColorPalette = lightColors(
    primary = LightRed,
    primaryVariant = LightWhite,
    onPrimary = TextColor,
    secondary = ThreeDotsColor,
    onSecondary = LightWhite,
    surface = Color.White,
    onSurface = TimestampColor,
    background = Color.White,
)

@Composable
fun ChatUITheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}