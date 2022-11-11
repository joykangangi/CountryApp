package com.example.countryapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Give Dagger-Hilt info about the Application and have access to AppContentext
 */

@HiltAndroidApp
class CountryApplication: Application() {
}