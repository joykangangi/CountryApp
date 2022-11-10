package com.example.countryapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Translations(
    @Json(name = "ara")
    val ara: Ara,
    @Json(name = "bre")
    val bre: Bre,
    @Json(name = "ces")
    val ces: CesX,
    @Json(name = "cym")
    val cym: Cym,
    @Json(name = "deu")
    val deu: DeuX,
    @Json(name = "est")
    val est: EstX,
    @Json(name = "fin")
    val fin: FinX,
    @Json(name = "fra")
    val fra: FraXX,
    @Json(name = "hrv")
    val hrv: HrvX,
    @Json(name = "hun")
    val hun: HunX,
    @Json(name = "ita")
    val ita: ItaX,
    @Json(name = "jpn")
    val jpn: JpnX,
    @Json(name = "kor")
    val kor: KorX,
    @Json(name = "nld")
    val nld: NldX,
    @Json(name = "per")
    val per: Per,
    @Json(name = "pol")
    val pol: PolX,
    @Json(name = "por")
    val por: PorX,
    @Json(name = "rus")
    val rus: RusX,
    @Json(name = "slk")
    val slk: SlkX,
    @Json(name = "spa")
    val spa: SpaX,
    @Json(name = "swe")
    val swe: SweX,
    @Json(name = "tur")
    val tur: TurX,
    @Json(name = "urd")
    val urd: UrdX,
    @Json(name = "zho")
    val zho: ZhoX
)