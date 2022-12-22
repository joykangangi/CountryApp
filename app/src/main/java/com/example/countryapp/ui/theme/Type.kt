package com.example.countryapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.countryapp.R

// Set of Material typography styles to start with

//For regular text in the application
private val AxiFormaFont = FontFamily(
   Font(R.font.axiforma_regular),
   Font(R.font.axiforma_light, FontWeight.W300),
   Font(R.font.axiforma_bold, FontWeight.W700),
   Font(R.font.axiforma_medium, FontWeight.W500)
)


//For the logo
val ElsieFont = FontFamily(
    Font(R.font.elsieswashcaps_black)
)

val Typography = Typography(
    h6 = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = AxiFormaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)