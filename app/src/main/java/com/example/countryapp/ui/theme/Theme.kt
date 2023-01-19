package com.example.countryapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    onPrimary = White2,
    secondary = LightGrey,
    onSecondary = White,
    primaryVariant = DarkBlue,
    surface = DarkBlue,
    background = DarkBlue,
    onSurface = White2,
    onBackground = White2
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = Black2,
    secondary = White,
    onPrimary = Black2,
    onSecondary = Black2,
    onSurface = Black2,
    onBackground = LightGrey,
    surface = White,
    background = LightGrey

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CountryAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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