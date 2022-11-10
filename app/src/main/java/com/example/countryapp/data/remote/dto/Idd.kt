package com.example.countryapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Idd(
    @Json(name = "root")
    val root: String,
    @Json(name = "suffixes")
    val suffixes: List<String>
)