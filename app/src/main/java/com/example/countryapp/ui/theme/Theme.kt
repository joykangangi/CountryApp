package com.example.countryapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    primaryVariant = DarkBlue2,
    onPrimary = DarkTextWhite,
    secondary = DarkTextGray,
    onSecondary = LightTextGray,
    background = DarkBlue,
    onBackground = DarkTextWhite,
    surface = DarkBlue,
    onSurface = DarkTextWhite
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = LightTextBlack,
    onPrimary = LightTextBlack,
    secondary = DarkTextWhite,
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = LightTextBlack,
    surface = DarkTextWhite,
    onSurface = Color.Black,


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

    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = colors, block = {
        systemUiController.setSystemBarsColor(
            color = colors.background,
            darkIcons = !darkTheme
        )
        //systemUiController.systemBarsDarkContentEnabled = false
    })
    
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}