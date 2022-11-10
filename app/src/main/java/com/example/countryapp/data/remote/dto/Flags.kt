package com.example.countryapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flags(
    @Json(name = "png")
    val png: String,
    @Json(name = "svg")
    val svg: String
)