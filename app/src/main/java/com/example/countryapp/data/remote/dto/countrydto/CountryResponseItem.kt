package com.example.countryapp.data.remote.dto.countrydto


import com.example.countryapp.data.repository.model.Country
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryResponseItem(
    @Json(name = "altSpellings")
    val altSpellings: List<String>?,
    @Json(name = "area")
    val area: Double?,
    @Json(name = "borders")
    val borders: List<String>?,
    @Json(name = "capital")
    val capital: List<String>?,
    @Json(name = "capitalInfo")
    val capitalInfo: CapitalInfo?,
    @Json(name = "car")
    val car: Car?,
    @Json(name = "cca2")
    val cca2: String?,
    @Json(name = "cca3")
    val cca3: String?,
    @Json(name = "ccn3")
    val ccn3: String?,
    @Json(name = "cioc")
    val cioc: String?,
    @Json(name = "coatOfArms")
    val coatOfArms: CoatOfArms?,
    @Json(name = "continents")
    val continents: List<String>?,
    @Json(name = "currencies")
    val currencies: Currencies?,
    @Json(name = "demonyms")
    val demonyms: Demonyms?,
    @Json(name = "fifa")
    val fifa: String?,
    @Json(name = "flag")
    val flag: String,
    @Json(name = "flags")
    val flags: Flags,
    @Json(name = "gini")
    val gini: Gini?,
    @Json(name = "idd")
    val idd: Idd?,
    @Json(name = "independent")
    val independent: Boolean?,
    @Json(name = "landlocked")
    val landlocked: Boolean?,
    @Json(name = "languages")
    val languages: Languages?,
    @Json(name = "latlng")
    val latlng: List<Double>?,
    @Json(name = "maps")
    val maps: Maps?,
    @Json(name = "name")
    val name: Name,
    @Json(name = "population")
    val population: Int?,
    @Json(name = "postalCode")
    val postalCode: PostalCode?,
    @Json(name = "region")
    val region: String?,
    @Json(name = "startOfWeek")
    val startOfWeek: String?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "subregion")
    val subregion: String?,
    @Json(name = "timezones")
    val timezones: List<String>?,
    @Json(name = "tld")
    val tld: List<String>?,
    @Json(name = "translations")
    val translations: Translations?,
    @Json(name = "unMember")
    val unMember: Boolean?
)

fun CountryResponseItem.toCountry(): Country {
    return Country(
        flagEmoji = flags.png,
        name = name.official,
        capital = capital ?: listOf("N/A"),
        area = area,
        carSide = car?.side,
        coatOfArms = coatOfArms?.png,
        currencies = currencies,
        flags = flags.png,
        idd = idd ?: Idd(null, null),
        independent = independent ?: true,
        landlocked = landlocked ?: false,
        languages = languages,
        population = population ?: 0,
        region = region ?: "N/A",
        subregion = subregion ?: "N/A",
        timezones = timezones ?: listOf("N/A"),
        unMember = unMember ?: false
    )
}