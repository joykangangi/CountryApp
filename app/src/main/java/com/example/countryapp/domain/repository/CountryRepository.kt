package com.example.countryapp.domain.repository

import com.example.countryapp.data.remote.dto.countrydetaildto.CountryDetailResponse
import com.example.countryapp.data.remote.dto.countrydetaildto.CountryDetailResponseItem
import com.example.countryapp.data.remote.dto.countrydetaildto.Currencies
import com.example.countryapp.data.remote.dto.countrydetaildto.Languages
import com.example.countryapp.data.remote.dto.countrydto.CountryResponse
import com.example.countryapp.data.remote.dto.countrydto.CountryResponseItem

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
    suspend fun getCountries(): CountryResponse
    suspend fun getCountryByName(name: String): CountryDetailResponseItem
    suspend fun getCountryByRegion(region: String): CountryDetailResponse
    suspend fun getCountryBySubRegion(subReg: String): CountryDetailResponse
    suspend fun getCountryByCapital(capital: List<String>): CountryDetailResponseItem
    suspend fun getCountryByLanguage(language: Languages): CountryDetailResponse
    suspend fun getCountryByCurrency(currency: Currencies): CountryDetailResponse
}