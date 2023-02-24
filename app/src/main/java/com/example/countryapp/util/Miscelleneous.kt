package com.example.countryapp.util
/*
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.countryapp.domain.model.Borders
import com.example.countryapp.domain.model.Country
import kotlinx.coroutines.launch*/

/**
 * Functions I tried to get the borders names from their code :(
 *
 * Error faced - They are all returning an empty list/ one item list.
 *
 * I created a map to store the code and name of each country when
 * all countries are loaded successfully.
 * Then get the value of the code(key in my Map) given the borders codes from
 * the UI.
 */

/*

private fun collectMap() = viewModelScope.launch {
    val countries = _state.value.countries?.values
    if (countries != null) {
        for (countriess in countries) {
            for (country in countriess) {
                borderMap[country.code] = country.name
            }
        }
    }
    Log.i("CountryListViewModel", "Map= $borderMap")

}

fun codeToName(codes: List<String>): List<String> {
    val codeList = mutableListOf<String>()
    for (code in codes) {
        codeList.add(borderMap.getValue(code))
    }
    return codeList
}

fun getBorders(code: String): List<Borders>? {
    val countries = _state.value.countries?.values?.first()
    val country: Country? = countries?.first { it.code == code }
    val borders = countries?.filter { it.code in (country?.borders ?: emptyList()) }?.map {
        Borders(it.code, it.name)
    }

    return borders
}*/
