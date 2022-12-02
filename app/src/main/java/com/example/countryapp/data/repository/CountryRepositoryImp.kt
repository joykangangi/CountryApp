package com.example.countryapp.data.repository

import com.example.countryapp.data.remote.CountryApi
import com.example.countryapp.data.remote.dto.countrydto.CountryResponseItem
import com.example.countryapp.data.remote.dto.countrydto.Currencies
import com.example.countryapp.data.remote.dto.countrydto.Languages
import com.example.countryapp.domain.repository.CountryRepository

/**
 * This contains the implementations of the repository defined in the domain layer
 */
class CountryRepositoryImp(private val api: CountryApi): CountryRepository {
    override suspend fun getCountries(): List<CountryResponseItem> {
        return api.getAllCountries()
    }

    override suspend fun getCountryByName(name: String): List<CountryResponseItem> {
        return api.getCountryByName(name)
    }

    override suspend fun getCountryByRegion(region: String): List<CountryResponseItem> {
        return api.getCountryByReg(region)
    }

    override suspend fun getCountryBySubRegion(subReg: String): List<CountryResponseItem> {
        return api.getCountryBySubReg(subReg)
    }

    override suspend fun getCountryByCapital(capital: List<String>): CountryResponseItem {
        return api.getCountryByCapital(capital)
    }

    override suspend fun getCountryByLanguage(language: Languages): List<CountryResponseItem> {
        return api.getCountryByLang(language)
    }

    override suspend fun getCountryByCurrency(currency: Currencies): List<CountryResponseItem> {
        return api.getCountryByCurrency(currency)
    }
}