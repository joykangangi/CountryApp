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

fun toStringIdd(idd: Idd): String {
    val iddNos = mutableListOf<String>()
    if (idd.root != null && idd.suffixes !=null) {
        iddNos.add(idd.root + idd.suffixes)
    }
    return iddNos.toString().replace("[","").replace("]","")
}