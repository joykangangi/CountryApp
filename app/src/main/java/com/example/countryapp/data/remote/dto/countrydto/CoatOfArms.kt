package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoatOfArms(
    @Json(name = "png")
    val png: String,
    @Json(name = "svg")
    val svg: String
)