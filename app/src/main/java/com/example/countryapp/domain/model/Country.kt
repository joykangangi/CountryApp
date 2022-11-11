package com.example.countryapp.domain.model

import com.example.countryapp.data.remote.dto.countrydto.Currencies
import com.example.countryapp.data.remote.dto.countrydto.Idd
import com.example.countryapp.data.remote.dto.countrydto.Languages

/**
 * Domain Model-> has data to be accessed to be displayed in UI
 *
 * This class is customized to have data to display specific Country List (the needed, without extra entries)
 */

data class Country(
    val flagEmoji: String,
    val name: String,
    val capital: List<String>
)
