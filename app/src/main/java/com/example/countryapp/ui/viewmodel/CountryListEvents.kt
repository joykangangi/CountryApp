package com.example.countryapp.ui.viewmodel

/**
 * Events users can do in the list
 */
sealed class CountryListEvents {
    data class OnSearchQueryChange(val query: String): CountryListEvents()
    data class OnSelectFilter(val tag: List<String>): CountryListEvents()
}
