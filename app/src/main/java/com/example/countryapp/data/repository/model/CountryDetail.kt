package com.example.countryapp.data.repository.model

import com.example.countryapp.data.remote.dto.countrydetaildto.Currencies
import com.example.countryapp.data.remote.dto.countrydetaildto.Idd
import com.example.countryapp.data.remote.dto.countrydetaildto.Languages


data class CountryDetail(
    val area: Double,
    val capital: List<String>,
    val carSide: String,
    val coatOfArms: String,
    val currencies: Currencies,
    val flags: String,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val name: String,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
    val unMember: Boolean
)