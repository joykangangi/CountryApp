package com.example.countryapp.di

import com.example.countryapp.data.remote.CountryApi
import com.example.countryapp.data.repository.CountryRepositoryImp
import com.example.countryapp.domain.repository.CountryRepository
import com.example.countryapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


/**
 * DI-makes the dependencies replaceable e.g API instance
 * it contains functions that create dependencies
 */

@Module
@InstallIn(Singleton::class) //all dependencies in the module live as long as the Application
object AppModule {
    @Provides
    @Singleton
    fun providesCountryAPI(): CountryApi {
        val logging = HttpLoggingInterceptor() //track request and responses
            .setLevel(HttpLoggingInterceptor.Level.BODY) //see response body
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build()
                .create(CountryApi::class.java)
        }


    //after creating the API above dagger will pass it as a parameter below
    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryApi): CountryRepository {
        return CountryRepositoryImp(api = api)
    }
}