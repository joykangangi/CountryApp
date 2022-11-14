package com.example.countryapp.data.remote


import com.example.countryapp.data.remote.dto.countrydto.CountryResponse
import com.example.countryapp.data.remote.dto.countrydto.CountryResponseItem
import com.example.countryapp.data.remote.dto.countrydto.Currencies
import com.example.countryapp.data.remote.dto.countrydto.Languages
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Functions and Routes to be accessed from the API
 * 1. Get All countries
 * 2. Get Country Details given the:
 *  -name path{} from url.
 *  -region
 *  -sub-region
 *  -capital
 *  -currency
 *  -language
 *
 * 3. Search Country given the queryString
 */

interface CountryApi {
    @GET("/v3.1/all")
    suspend fun getAllCountries(): List<CountryResponseItem>

    @GET("/v3.1/name/{name}")
    suspend fun getCountryByName(@Path("name") officialName: String):CountryResponseItem

    @GET("/v3.1/currency/{currency}")
    suspend fun getCountryByCurrency(@Path("currency") currency: Currencies): List<CountryResponseItem>

    @GET("/v3.1/lang/{lang}")
    suspend fun getCountryByLang(@Path("lang")lang: Languages): List<CountryResponseItem>

    @GET("/v3.1/capital/{capital}")
    suspend fun getCountryByCapital(@Path("capital")capital: List<String>): CountryResponseItem

    @GET("/v3.1/region/{region}")
    suspend fun getCountryByReg(@Path("region")region:String): List<CountryResponseItem>

    @GET("/v3.1/subregion/{region}")
    suspend fun getCountryBySubReg(@Path("region")subRegion: String): List<CountryResponseItem>

}