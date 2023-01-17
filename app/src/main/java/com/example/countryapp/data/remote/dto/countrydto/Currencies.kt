package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.*
import java.util.*
import kotlin.reflect.full.memberProperties

@JsonClass(generateAdapter = true)
data class Currencies(
   @Json(name = "name")
   val name: String?,
   @Json(name = "symbol")
   val symbol: String?
)