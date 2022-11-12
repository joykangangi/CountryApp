package com.example.countryapp.ui.navigation

//Has routes to different screens

sealed class Screen(val route: String) {
    object CountryListScreen: Screen("country_list_screen")
    object CountryDetailScreen: Screen("country_detail_screen")
}
