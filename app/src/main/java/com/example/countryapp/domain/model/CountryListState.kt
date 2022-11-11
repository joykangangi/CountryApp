package com.example.countryapp.domain.model

import com.example.countryapp.data.repository.model.Country

data class CountryListState(
    val countries: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
