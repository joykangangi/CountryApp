package com.example.countryapp.ui.viewmodel.countrylist

import com.example.countryapp.data.repository.model.Country

data class CountryListState(
    val countries: Map<Char, List<Country>>? = emptyMap(),
    val error: String = "",
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
