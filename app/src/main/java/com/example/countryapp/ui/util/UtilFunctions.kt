package com.example.countryapp.ui.util

import java.util.*

fun cleanList(details: List<Any>): String {
    return details.toString().removeSurrounding('['.toString(), ']'.toString())
}

fun Int.formatCommaSeparator(): String {
    return this.toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}

fun String.firstCapital(): String {
    return this.substring(0,1).uppercase() + this.substring(1)
}

object CountryCodeConverter {
    // map iso2 to iso3; associate iso2 string to iso3 string and the iso2 locale to Locale
    private val countryCodes: Map<String, Locale> = Locale.getISOCountries().associateBy(
        { Locale("", it).isO3Country.uppercase() }, //String
        { Locale("", it) } //Locale
    )

    // take iso3 codes and read their values from the map
    fun iso3ToIso2Code(iso3CountryCode: List<String?>): String {
        val countryNames = mutableListOf<String>()
        for (code in iso3CountryCode) {
            //countryNames.add(countryCodes[code]?.displayCountry)
            countryCodes[code]?.displayCountry?.let { countryNames.add(it) }
        }
        return cleanList(countryNames)
    }
}