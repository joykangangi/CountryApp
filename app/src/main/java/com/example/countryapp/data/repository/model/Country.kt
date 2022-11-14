package com.example.countryapp.data.repository.model

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
    val capital: List<String>,
    val area: Double?,
    val carSide: String?,
    val coatOfArms: String?,
    val currencies: Currencies?,
    val flags: String,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages?,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
    val unMember: Boolean
)
