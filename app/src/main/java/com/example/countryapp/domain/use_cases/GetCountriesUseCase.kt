package com.example.countryapp.domain.use_cases

import com.example.countryapp.data.remote.dto.countrydto.toCountry
import com.example.countryapp.domain.model.Country
import com.example.countryapp.domain.repository.CountryRepository
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Constants.IOERRORMESSAGE
import com.example.countryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * This class has only one public function,i.e to execute the use case function
 * It is useful within a class having a single method
 * Specifying an invoke operator on a class allows it to be called/executed on any instances of the class without a method name.
 * Flow -> emit multiple values over a period time, i.e wrapped in the Resource(Success/Error/Loading)
 * e.g -if an error occurs, it will be emitted here,
 *     -if a success occurs, attach the data fetched(ArrayList of Countries) and emit it
 * HttpException- what to do in case of error/ Http codes except those starting with 2 (successes)
 * IOException - what to do if the api can't connect to the remote server e.g when device isn't connected to the internet
 */


class GetCountriesUseCase(private val repository: CountryRepository) {

    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())

            //CountryResponseItem.toCountry()
            val countries = repository.getCountries().map { it.toCountry() }
            emit(Resource.Success(data = countries))
        }
        catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: HTTPERRORMESSAGE))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: IOERRORMESSAGE))
        }

    }

}