package com.example.countryapp.ui.viewmodel.countrylist

import com.example.countryapp.data.repository.model.Country

data class CountryListState(
    val countries: List<Country> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
