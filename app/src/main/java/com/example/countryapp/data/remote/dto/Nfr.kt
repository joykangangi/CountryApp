package com.example.countryapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Nfr(
    @Json(name = "common")
    val common: String,
    @Json(name = "official")
    val official: String
)