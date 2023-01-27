package com.example.countryapp.ui.viewmodel.countrylist

import com.example.countryapp.domain.model.Country

data class CountryListState(
    val countries: Map<Char, List<Country>>? = emptyMap(),
    val error: String = "",
    val isLoading: Boolean = true,
    val searchQuery: String = "",
    val darkTheme: Boolean = false
)
