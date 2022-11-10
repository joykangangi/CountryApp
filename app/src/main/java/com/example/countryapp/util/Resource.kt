package com.example.countryapp.util

/**
 * A generic class of type T, to wrap the network responses
 * It will communicate between use_cases and viewmodel
 * data = body of response/ actual data
 * message = error or successful message
 */

sealed class Resource<T>(val data: T? = null, val message: String?=null) {
    class Success<T>(data: T): Resource<T>(data = data)
    class Error<T>(message: String, data:T? = null): Resource<T>(data = data, message = message)
    class Loading<T>(data: T? = null): Resource<T>(data = data)
}

// class Loading1<T>: Resource<T>()