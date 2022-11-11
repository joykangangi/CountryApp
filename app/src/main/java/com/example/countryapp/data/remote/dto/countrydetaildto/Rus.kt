package com.example.countryapp.data.remote.dto.countrydetaildto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rus(
    @Json(name = "common")
    val common: String,
    @Json(name = "official")
    val official: String
)