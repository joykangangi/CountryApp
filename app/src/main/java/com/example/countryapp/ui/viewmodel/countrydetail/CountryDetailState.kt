package com.example.countryapp.ui.viewmodel.countrydetail

import com.example.countryapp.domain.model.Country

data class CountryDetailState(
    val country: Country? = null,
    val error: String = "",
    val isLoading: Boolean = false
    )