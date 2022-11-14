package com.example.countryapp.data.repository.use_cases


import com.example.countryapp.data.remote.dto.countrydto.toCountry
import com.example.countryapp.data.repository.model.Country
import com.example.countryapp.domain.repository.CountryRepository
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Constants.IOERRORMESSAGE
import com.example.countryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountryCapital @Inject constructor(private val repository: CountryRepository) {
    operator fun invoke(capital:List<String>): Flow<Resource<Country>> = flow {
        try {
            emit(Resource.Loading())
            val countryWithCapital = repository.getCountryByCapital(capital).toCountry()
            emit(Resource.Success(countryWithCapital))
        }
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:HTTPERRORMESSAGE))
        }
        catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: IOERRORMESSAGE))
        }
    }
}