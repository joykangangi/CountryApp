package com.example.countryapp.domain.use_cases

import com.example.countryapp.domain.repository.CountryRepository

/**
 * This class has only one public function,i.e to execute that use case function
 * The operator fun invoke is used to execute a function without specifying the function name
 * It is useful within a class having a single method
 * Specifying an invoke operator on a class allows it to be called on any instances of the class without a method name.
 *
 */

class GetCountriesUseCase(private val repository: CountryRepository) {

    operator fun invoke() {

    }

}