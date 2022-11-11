package com.example.countryapp.domain.use_cases

import com.example.countryapp.data.remote.dto.countrydetaildto.toCountryDetail
import com.example.countryapp.domain.model.CountryDetail
import com.example.countryapp.domain.repository.CountryRepository
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Constants.IOERRORMESSAGE
import com.example.countryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCountrySubRegion(private val repository: CountryRepository) {
    operator fun invoke(subRegion: String): Flow<Resource<List<CountryDetail>>> = flow {
        try {
            emit(Resource.Loading())
            val countryInSubRegion = repository.getCountryBySubRegion(subRegion).map { it.toCountryDetail() }
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