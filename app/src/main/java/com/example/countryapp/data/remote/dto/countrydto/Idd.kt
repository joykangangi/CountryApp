package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Idd(
    @Json(name = "root")
    val root: String?,
    @Json(name = "suffixes")
    val suffixes: List<String?>?
)

fun Idd.toListIdd(idd: Idd): String {
    val iddNos = mutableListOf<String>()
    if (root != null && suffixes !=null) {
        iddNos.add(root + suffixes)
    }
    return iddNos.toString()
}