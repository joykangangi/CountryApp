package com.example.countryapp.data.remote.dto.countrydetaildto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Translations(
    @Json(name = "ara")
    val ara: Ara,
    @Json(name = "bre")
    val bre: Bre,
    @Json(name = "ces")
    val ces: Ces,
    @Json(name = "cym")
    val cym: Cym,
    @Json(name = "deu")
    val deu: Deu,
    @Json(name = "est")
    val est: Est,
    @Json(name = "fin")
    val fin: Fin,
    @Json(name = "fra")
    val fra: FraX,
    @Json(name = "hrv")
    val hrv: Hrv,
    @Json(name = "hun")
    val hun: Hun,
    @Json(name = "ita")
    val ita: Ita,
    @Json(name = "jpn")
    val jpn: Jpn,
    @Json(name = "kor")
    val kor: Kor,
    @Json(name = "nld")
    val nld: Nld,
    @Json(name = "per")
    val per: Per,
    @Json(name = "pol")
    val pol: Pol,
    @Json(name = "por")
    val por: Por,
    @Json(name = "rus")
    val rus: Rus,
    @Json(name = "slk")
    val slk: Slk,
    @Json(name = "spa")
    val spa: Spa,
    @Json(name = "swe")
    val swe: Swe,
    @Json(name = "tur")
    val tur: Tur,
    @Json(name = "urd")
    val urd: Urd,
    @Json(name = "zho")
    val zho: Zho
)