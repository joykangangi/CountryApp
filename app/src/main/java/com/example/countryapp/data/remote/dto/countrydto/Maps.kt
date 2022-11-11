package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Maps(
    @Json(name = "googleMaps")
    val googleMaps: String,
    @Json(name = "openStreetMaps")
    val openStreetMaps: String
)