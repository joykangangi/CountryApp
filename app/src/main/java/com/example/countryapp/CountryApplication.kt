package com.example.countryapp

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp


/**
 * Give Dagger-Hilt info about the Application and have access to AppContentext
 */

@HiltAndroidApp
class CountryApplication: Application() {

    //should be saved in data store or cache for persistence
    val isDark = mutableStateOf(false)

    fun toggleLightTheme() {
        isDark.value = !isDark.value

    }

}