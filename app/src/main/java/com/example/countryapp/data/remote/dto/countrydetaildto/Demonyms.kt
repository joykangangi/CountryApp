package com.example.countryapp.data.remote.dto.countrydetaildto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Demonyms(
    @Json(name = "eng")
    val eng: Eng,
    @Json(name = "fra")
    val fra: Fra
)