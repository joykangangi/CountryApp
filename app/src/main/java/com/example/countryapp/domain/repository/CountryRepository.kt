package com.example.countryapp.domain.repository

import com.example.countryapp.data.remote.dto.countrydto.CountryResponseItem
import com.example.countryapp.data.remote.dto.countrydto.Currencies
import com.example.countryapp.data.remote.dto.countrydto.Languages

/**
 * The repository on this layer(domain) only has definitions
 * The functions are what the API should do for us.
 * Incase there was caching,the insert functions to the db would be her
 *
 * CountryDetailResponse-ArrayList of countries
 * CountryDetailResponseItem - One Country
 *  Get Country Details given the:
 *  -name path{} from url.
 *  -region
 *  -sub-region
 *  -capital
 *  -currency
 *  -language
 */

interface CountryRepository {
    suspend fun getCountries(): List<CountryResponseItem>

    suspend fun getCountryByName(name: String): CountryResponseItem
    suspend fun getCountryByRegion(region: String): List<CountryResponseItem>
    suspend fun getCountryBySubRegion(subReg: String): List<CountryResponseItem>
    suspend fun getCountryByCapital(capital: List<String>): CountryResponseItem
    suspend fun getCountryByLanguage(language: Languages): List<CountryResponseItem>
    suspend fun getCountryByCurrency(currency: Currencies): List<CountryResponseItem>
}