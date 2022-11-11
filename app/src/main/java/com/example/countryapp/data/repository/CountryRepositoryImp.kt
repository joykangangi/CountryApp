package com.example.countryapp.data.repository

import com.example.countryapp.data.remote.CountryApi
import com.example.countryapp.data.remote.dto.countrydetaildto.CountryDetailResponse
import com.example.countryapp.data.remote.dto.countrydetaildto.CountryDetailResponseItem
import com.example.countryapp.data.remote.dto.countrydetaildto.Currencies
import com.example.countryapp.data.remote.dto.countrydetaildto.Languages
import com.example.countryapp.data.remote.dto.countrydto.CountryResponse
import com.example.countryapp.domain.repository.CountryRepository

/**
 * This contains the implementations of the repository defined in the domain layer
 */
class CountryRepositoryImp(private val api: CountryApi): CountryRepository {
    override suspend fun getCountries(): CountryResponse {
        return api.getAllCountries()
    }

    override suspend fun getCountryByName(name: String): CountryDetailResponseItem {
        return api.getCountryByName(name)
    }

    override suspend fun getCountryByRegion(region: String): CountryDetailResponse {
        return api.getCountryByReg(region)
    }

    override suspend fun getCountryBySubRegion(subReg: String): CountryDetailResponse {
        return api.getCountryBySubReg(subReg)
    }

    override suspend fun getCountryByCapital(capital: List<String>): CountryDetailResponseItem {
        return api.getCountryByCapital(capital)
    }

    override suspend fun getCountryByLanguage(language: Languages): CountryDetailResponse {
        return api.getCountryByLang(language)
    }

    override suspend fun getCountryByCurrency(currency: Currencies): CountryDetailResponse {
        return api.getCountryByCurrency(currency)
    }
}