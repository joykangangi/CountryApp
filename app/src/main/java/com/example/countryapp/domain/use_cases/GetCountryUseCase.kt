package com.example.countryapp.domain.use_cases

import com.example.countryapp.data.remote.dto.countrydetaildto.toCountryDetail
import com.example.countryapp.data.remote.dto.countrydto.toCountry
import com.example.countryapp.domain.model.Country
import com.example.countryapp.domain.model.CountryDetail
import com.example.countryapp.domain.repository.CountryRepository
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Constants.IOERRORMESSAGE
import com.example.countryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * To retrieve ONE country
 * no need to use map since the returned obj isn't a list
 * we emit objects of the form defined in the custom data classes not api response
 */


class GetCountryUseCase(private val repository: CountryRepository) {

    operator fun invoke(name: String): Flow<Resource<CountryDetail>> = flow{
        try {
            emit(Resource.Loading())
            repository.getCountries()
            val country = repository.getCountryByName(name = name).toCountryDetail()
            emit(Resource.Success(country))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: HTTPERRORMESSAGE))
        }
        catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: IOERRORMESSAGE))
        }
    }
}