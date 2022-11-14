package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gini(
    @Json(name = "1992")
    val x1992: Double?,
    @Json(name = "1998")
    val x1998: Double?,
    @Json(name = "1999")
    val x1999: Double?,
    @Json(name = "2003")
    val x2003: Double?,
    @Json(name = "2004")
    val x2004: Double?,
    @Json(name = "2005")
    val x2005: Double?,
    @Json(name = "2006")
    val x2006: Double?,
    @Json(name = "2008")
    val x2008: Double?,
    @Json(name = "2009")
    val x2009: Double?,
    @Json(name = "2010")
    val x2010: Double?,
    @Json(name = "2011")
    val x2011: Double?,
    @Json(name = "2012")
    val x2012: Double?,
    @Json(name = "2013")
    val x2013: Double?,
    @Json(name = "2014")
    val x2014: Double?,
    @Json(name = "2015")
    val x2015: Double?,
    @Json(name = "2016")
    val x2016: Double?,
    @Json(name = "2017")
    val x2017: Double?,
    @Json(name = "2018")
    val x2018: Double?,
    @Json(name = "2019")
    val x2019: Double?
)