package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rar(
    @Json(name = "common")
    val common: String?,
    @Json(name = "official")
    val official: String?
)