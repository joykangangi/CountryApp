package com.example.countryapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.countryapp.data.repository.use_cases.GetCountriesUseCase
import com.example.countryapp.domain.model.CountryListState
import com.example.countryapp.util.Constants.DELAY
import com.example.countryapp.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach

class CountryViewModel(private val getCountriesUseCase: GetCountriesUseCase) {
    //backing property
     private var _state by mutableStateOf(CountryListState())
     val state = _state

    //to help in delay during the search, delay will be done in a coroutine to avoid ui lagging
    private var searchJob: Job? = null


    //the copy will get the current screen state e.g searching and only modify the changed variable in
    private fun getEvent(event: CountryListEvents) {
        when(event) {
            is CountryListEvents.OnSearchQueryChange -> {
                _state = _state.copy(searchQuery = event.query)
                searchJob?.cancel() //if it a job already exits we cancel the job
                searchJob =
                suspend {
                    delay(DELAY)

                }

            }
            is CountryListEvents.OnSelectFilter -> {
                //Todo
            }
        }
    }

    private fun getCountries() {
        getCountriesUseCase().onEach { result->
            when(result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }
    }

}

class CountryViewModelProviderFactory(private val country: HealthRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HealthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HealthViewModel(healthRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }