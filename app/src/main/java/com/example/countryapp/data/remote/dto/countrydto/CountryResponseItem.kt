package com.example.countryapp.data.remote.dto.countrydto


import com.example.countryapp.domain.model.Country
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
fun getCurrencyProp1(currencies: Currencies): Map<String, *> {
val nonNullCurrencies = currencies.let {
val nonNullProperties = Currencies::class.memberProperties
.filter { prop-> prop.get(it) != null }
.map { propFiltered-> propFiltered.name to propFiltered.get(it) }
.map { (name, value)-> name to value }

nonNullProperties.toMap()
}
return nonNullCurrencies

}
 *
 *
fun Idd.toListIdd(idd: Idd): String {
val iddNos = mutableListOf<String>()
if (root != null && suffixes !=null) {
iddNos.add(root + suffixes)
}
return iddNos.toString()
}
 *
 *
 *
fun toListLang(languages: Languages?): List<String> {
val languageList = mutableListOf<String>()
val properties = Languages::class.memberProperties
for (language in properties) {
//extracts the value of each property using the get function and casts it to a String
val lang = languages?.let { language.get(it) } as String?
if (lang != null) {
languageList.add(lang)
}
}
return languageList
}
 */

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
    val car: Car? = null,
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
    @Json(name = "currencies")
    val currencies: Map<String, Currencies>? = null,
    @Json(name = "continents")
    val continents: List<String>? = null,
    @Json(name = "demonyms")
    val demonyms: Demonyms? = null,
    @Json(name = "fifa")
    val fifa: String?,
    @Json(name = "flag")
    val flag: String? = null,
    @Json(name = "flags")
    val flags: Flags? = null,
    @Json(name = "idd")
    val idd: Idd?,
    @Json(name = "independent")
    val independent: Boolean?,
    @Json(name = "landlocked")
    val landlocked: Boolean?,
    @Json(name = "languages")
    val languages: Languages?,
    @Json(name = "latlng")
    val latlng: List<Double>? = null,
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
    val translations: Map<String, Translations>? = null,
    @Json(name = "unMember")
    val unMember: Boolean?
)

fun CountryResponseItem.toCountry(): Country {

    return Country(
        flagEmoji = flags?.png?:"N/A",
        name = name.common ?: "N/A",
        capital = capital ?: emptyList(),
        area = area,
        carSide = car?.side ?: "N/A",
        coatOfArms = coatOfArms?.png ?: "",
        currencyName = currencies?.values?.first()?.name ?: "N/A",
        currencySymbol = currencies?.values?.first()?.symbol ?: "N/A",
        flags = flags?.png ?:"",
        idd = idd ?: Idd(null, null),
        independent = independent,
        landlocked = landlocked,
        languages = languages,
        population = population ?: 0,
        region = region ?: "N/A",
        subregion = subregion ?: "N/A",
        timezones = timezones ?: emptyList(),
        unMember = unMember
    )
}