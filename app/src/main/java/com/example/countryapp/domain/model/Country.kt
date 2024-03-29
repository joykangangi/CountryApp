package com.example.countryapp.domain.model

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
    val currencyName: String,
    val currencySymbol: String,
    val flags: String,
    val idd: Idd,
    val independent: Boolean?,
    val landlocked: Boolean?,
    val languages: Languages?,
    val population: Int,
    val region: String,
    val borders: List<String>,
    val subregion: String,
    val timezones: List<String>,
    val unMember: Boolean?,
    val startOfWeek: String,
    val demonyms: String,
    val code: String
)
fun Country.getBorder(code: String) :Borders{
    return Borders(
        code = code,
        name = name
    )
}

data class Borders(
    val code: String,
    val name: String
)
