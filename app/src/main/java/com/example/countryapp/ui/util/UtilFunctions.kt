package com.example.countryapp.ui.util

fun cleanList(details: List<Any>): String {
    return details.toString().removeSurrounding('['.toString(), ']'.toString())
}

fun Int.formatCommaSeparator(): String {
    return this.toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}

fun String.firstCapital(): String {
    return this.substring(0,1).uppercase() + this.substring(1)
}