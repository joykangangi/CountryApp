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

class GetCountrySubRegion @Inject constructor(private val repository: CountryRepository) {
    operator fun invoke(subRegion: String): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            val countryInSubRegion = repository.getCountryBySubRegion(subRegion).map { it.toCountry() }
            emit(Resource.Success(countryInSubRegion))
        }
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:HTTPERRORMESSAGE))
        }
        catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?: IOERRORMESSAGE))
        }
    }
}