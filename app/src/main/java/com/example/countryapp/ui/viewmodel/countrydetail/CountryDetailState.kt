package com.example.countryapp.ui.viewmodel.countrydetail

import com.example.countryapp.data.repository.model.CountryDetail

data class CountryDetailState(
    val country: CountryDetail? = null,
    val error: String = "",
    val isLoading: Boolean = false,

)