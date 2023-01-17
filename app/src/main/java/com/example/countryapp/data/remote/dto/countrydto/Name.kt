package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.json.JSONObject

@JsonClass(generateAdapter = true)
data class Name(
    @Json(name = "common")
    val common: String?,
    @Json(name = "nativeName")
    val nativeName: Map<String, NativeName> = mapOf(),
    @Json(name = "official")
    val official: String
)