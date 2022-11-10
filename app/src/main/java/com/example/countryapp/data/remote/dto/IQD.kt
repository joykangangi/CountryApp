package com.example.countryapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IQD(
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String
)