package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TMT(
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String
)