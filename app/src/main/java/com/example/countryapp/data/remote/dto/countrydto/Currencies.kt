package com.example.countryapp.data.remote.dto.countrydto


import com.squareup.moshi.*
import java.util.*
import kotlin.reflect.full.memberProperties

@JsonClass(generateAdapter = true)
data class Currencies(
    @Json(name = "AED")
    val aED: AED?,
    @Json(name = "AFN")
    val aFN: AFN?,
    @Json(name = "ALL")
    val aLL: ALL?,
    @Json(name = "AMD")
    val aMD: AMD?,
    @Json(name = "ANG")
    val aNG: ANG?,
    @Json(name = "AOA")
    val aOA: AOA?,
    @Json(name = "ARS")
    val aRS: ARS?,
    @Json(name = "AUD")
    val aUD: AUD?,
    @Json(name = "AWG")
    val aWG: AWG?,
    @Json(name = "AZN")
    val aZN: AZN?,
    @Json(name = "BAM")
    val bAM: BAM?,
    @Json(name = "BBD")
    val bBD: BBD?,
    @Json(name = "BDT")
    val bDT: BDT?,
    @Json(name = "BGN")
    val bGN: BGN?,
    @Json(name = "BHD")
    val bHD: BHD?,
    @Json(name = "BIF")
    val bIF: BIF?,
    @Json(name = "BMD")
    val bMD: BMD?,
    @Json(name = "BND")
    val bND: BND?,
    @Json(name = "BOB")
    val bOB: BOB?,
    @Json(name = "BRL")
    val bRL: BRL?,
    @Json(name = "BSD")
    val bSD: BSD?,
    @Json(name = "BTN")
    val bTN: BTN?,
    @Json(name = "BWP")
    val bWP: BWP?,
    @Json(name = "BYN")
    val bYN: BYN?,
    @Json(name = "BZD")
    val bZD: BZD?,
    @Json(name = "CAD")
    val cAD: CAD?,
    @Json(name = "CDF")
    val cDF: CDF?,
    @Json(name = "CHF")
    val cHF: CHF?,
    @Json(name = "CKD")
    val cKD: CKD?,
    @Json(name = "CLP")
    val cLP: CLP?,
    @Json(name = "CNY")
    val cNY: CNY?,
    @Json(name = "COP")
    val cOP: COP?,
    @Json(name = "CRC")
    val cRC: CRC?,
    @Json(name = "CUC")
    val cUC: CUC?,
    @Json(name = "CUP")
    val cUP: CUP?,
    @Json(name = "CVE")
    val cVE: CVE?,
    @Json(name = "CZK")
    val cZK: CZK?,
    @Json(name = "DJF")
    val dJF: DJF?,
    @Json(name = "DKK")
    val dKK: DKK?,
    @Json(name = "DOP")
    val dOP: DOP?,
    @Json(name = "DZD")
    val dZD: DZD?,
    @Json(name = "EGP")
    val eGP: EGP?,
    @Json(name = "ERN")
    val eRN: ERN?,
    @Json(name = "ETB")
    val eTB: ETB?,
    @Json(name = "EUR")
    val eUR: EUR?,
    @Json(name = "FJD")
    val fJD: FJD?,
    @Json(name = "FKP")
    val fKP: FKP?,
    @Json(name = "FOK")
    val fOK: FOK?,
    @Json(name = "GBP")
    val gBP: GBP?,
    @Json(name = "GEL")
    val gEL: GEL?,
    @Json(name = "GGP")
    val gGP: GGP?,
    @Json(name = "GHS")
    val gHS: GHS?,
    @Json(name = "GIP")
    val gIP: GIP?,
    @Json(name = "GMD")
    val gMD: GMD?,
    @Json(name = "GNF")
    val gNF: GNF?,
    @Json(name = "GTQ")
    val gTQ: GTQ?,
    @Json(name = "GYD")
    val gYD: GYD?,
    @Json(name = "HKD")
    val hKD: HKD?,
    @Json(name = "HNL")
    val hNL: HNL?,
    @Json(name = "HRK")
    val hRK: HRK?,
    @Json(name = "HTG")
    val hTG: HTG?,
    @Json(name = "HUF")
    val hUF: HUF?,
    @Json(name = "IDR")
    val iDR: IDR?,
    @Json(name = "ILS")
    val iLS: ILS?,
    @Json(name = "IMP")
    val iMP: IMP?,
    @Json(name = "INR")
    val iNR: INR?,
    @Json(name = "IQD")
    val iQD: IQD?,
    @Json(name = "IRR")
    val iRR: IRR?,
    @Json(name = "ISK")
    val iSK: ISK?,
    @Json(name = "JEP")
    val jEP: JEP?,
    @Json(name = "JMD")
    val jMD: JMD?,
    @Json(name = "JOD")
    val jOD: JOD?,
    @Json(name = "JPY")
    val jPY: JPY?,
    @Json(name = "KES")
    val kES: KES?,
    @Json(name = "KGS")
    val kGS: KGS?,
    @Json(name = "KHR")
    val kHR: KHR?,
    @Json(name = "KID")
    val kID: KID?,
    @Json(name = "KMF")
    val kMF: KMF?,
    @Json(name = "KPW")
    val kPW: KPW?,
    @Json(name = "KRW")
    val kRW: KRW?,
    @Json(name = "KWD")
    val kWD: KWD?,
    @Json(name = "KYD")
    val kYD: KYD?,
    @Json(name = "KZT")
    val kZT: KZT?,
    @Json(name = "LAK")
    val lAK: LAK?,
    @Json(name = "LBP")
    val lBP: LBP?,
    @Json(name = "LKR")
    val lKR: LKR?,
    @Json(name = "LRD")
    val lRD: LRD?,
    @Json(name = "LSL")
    val lSL: LSL?,
    @Json(name = "LYD")
    val lYD: LYD?,
    @Json(name = "MAD")
    val mAD: MAD?,
    @Json(name = "MDL")
    val mDL: MDL?,
    @Json(name = "MGA")
    val mGA: MGA?,
    @Json(name = "MKD")
    val mKD: MKD?,
    @Json(name = "MMK")
    val mMK: MMK?,
    @Json(name = "MNT")
    val mNT: MNT?,
    @Json(name = "MOP")
    val mOP: MOP?,
    @Json(name = "MRU")
    val mRU: MRU?,
    @Json(name = "MUR")
    val mUR: MUR?,
    @Json(name = "MVR")
    val mVR: MVR?,
    @Json(name = "MWK")
    val mWK: MWK?,
    @Json(name = "MXN")
    val mXN: MXN?,
    @Json(name = "MYR")
    val mYR: MYR?,
    @Json(name = "MZN")
    val mZN: MZN?,
    @Json(name = "NAD")
    val nAD: NAD?,
    @Json(name = "NGN")
    val nGN: NGN?,
    @Json(name = "NIO")
    val nIO: NIO?,
    @Json(name = "NOK")
    val nOK: NOK?,
    @Json(name = "NPR")
    val nPR: NPR?,
    @Json(name = "NZD")
    val nZD: NZD?,
    @Json(name = "OMR")
    val oMR: OMR?,
    @Json(name = "PAB")
    val pAB: PAB?,
    @Json(name = "PEN")
    val pEN: PEN?,
    @Json(name = "PGK")
    val pGK: PGK?,
    @Json(name = "PHP")
    val pHP: PHP?,
    @Json(name = "PKR")
    val pKR: PKR?,
    @Json(name = "PLN")
    val pLN: PLN?,
    @Json(name = "PYG")
    val pYG: PYG?,
    @Json(name = "QAR")
    val qAR: QAR?,
    @Json(name = "RON")
    val rON: RON?,
    @Json(name = "RSD")
    val rSD: RSD?,
    @Json(name = "RUB")
    val rUB: RUB?,
    @Json(name = "RWF")
    val rWF: RWF?,
    @Json(name = "SAR")
    val sAR: SAR?,
    @Json(name = "SBD")
    val sBD: SBD?,
    @Json(name = "SCR")
    val sCR: SCR?,
    @Json(name = "SDG")
    val sDG: SDG?,
    @Json(name = "SEK")
    val sEK: SEK?,
    @Json(name = "SGD")
    val sGD: SGD?,
    @Json(name = "SHP")
    val sHP: SHP?,
    @Json(name = "SLL")
    val sLL: SLL?,
    @Json(name = "SOS")
    val sOS: SOS?,
    @Json(name = "SRD")
    val sRD: SRD?,
    @Json(name = "SSP")
    val sSP: SSP?,
    @Json(name = "STN")
    val sTN: STN?,
    @Json(name = "SYP")
    val sYP: SYP?,
    @Json(name = "SZL")
    val sZL: SZL?,
    @Json(name = "THB")
    val tHB: THB?,
    @Json(name = "TJS")
    val tJS: TJS?,
    @Json(name = "TMT")
    val tMT: TMT?,
    @Json(name = "TND")
    val tND: TND?,
    @Json(name = "TOP")
    val tOP: TOP?,
    @Json(name = "TRY")
    val tRY: TRY?,
    @Json(name = "TTD")
    val tTD: TTD?,
    @Json(name = "TVD")
    val tVD: TVD?,
    @Json(name = "TWD")
    val tWD: TWD?,
    @Json(name = "TZS")
    val tZS: TZS?,
    @Json(name = "UAH")
    val uAH: UAH?,
    @Json(name = "UGX")
    val uGX: UGX?,
    @Json(name = "USD")
    val uSD: USD?,
    @Json(name = "UYU")
    val uYU: UYU?,
    @Json(name = "UZS")
    val uZS: UZS?,
    @Json(name = "VES")
    val vES: VES?,
    @Json(name = "VND")
    val vND: VND?,
    @Json(name = "VUV")
    val vUV: VUV?,
    @Json(name = "WST")
    val wST: WST?,
    @Json(name = "XAF")
    val xAF: XAF?,
    @Json(name = "XCD")
    val xCD: XCD?,
    @Json(name = "XOF")
    val xOF: XOF?,
    @Json(name = "XPF")
    val xPF: XPF?,
    @Json(name = "YER")
    val yER: YER?,
    @Json(name = "ZAR")
    val zAR: ZAR?,
    @Json(name = "ZMW")
    val zMW: ZMW?,
    @Json(name = "ZWL")
    val zWL: ZWL?
)

fun toListLang2(languages: Languages?): List<String> {
    val languageList = mutableListOf<String>()
    val properties = Languages::class.memberProperties
    for (language in properties) {
        //extracts the value of each property using the get function and casts it to a String
        val lang = languages?.let { language.get(it) } as String?
        if (lang != null) {
            languageList.add(lang)
        }
    }
    return languageList
}


@JsonClass(generateAdapter = true)
data class CurrencyDetail(
    @Json(name = "name")
    val name: String?,
    @Json(name = "symbol")
    val symbol: String?
)
/**
 * filter non-null values and transform the result to List<Pair<String, Any?>, then transform it into a Map
 */
fun getCurrencyProp(currencies: Currencies): Map<String, CurrencyDetail?> {

    val nonNullCurrencies = currencies.let {
        val nonNullProperties: List<Pair<String, CurrencyDetail>> = Currencies::class.memberProperties
            .filter { prop -> prop.get(it) != null }
            .map { propFiltered -> propFiltered.name to propFiltered.get(it) as CurrencyDetail }
        nonNullProperties.toMap()
    }
    return nonNullCurrencies
}


//the get func is kinda interesting , receiver:Nothing

//    val currMap = mutableMapOf<String, String>()
//    val properties = Currencies::class.memberProperties
//
//    for (curr in properties) {
//        val currNonNull = curr.get(currencies) as Map<*, *>?
//        if (currNonNull?.keys != null) {
//            currMap[currNonNull.keys.toString()] = currNonNull.values.toString()
//        }
//    }