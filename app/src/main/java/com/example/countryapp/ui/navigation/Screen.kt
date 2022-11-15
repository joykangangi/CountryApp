package com.example.countryapp.ui.navigation

//Has routes to different screens

sealed class Screen(val route: String) {
    object CountryListScreen: Screen("list")
    object CountryDetailScreen: Screen("detail")
}
