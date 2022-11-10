package com.example.countryapp.data.remote

import retrofit2.http.GET

/**
 * Functions and Routes to be accessed from the API
 * 1. Get All countries
 * 2. Get Country Details given the id.
 * 3. Search Country given the queryString
 */

interface CountryApi {
    @GET("/v3.1/all")
}