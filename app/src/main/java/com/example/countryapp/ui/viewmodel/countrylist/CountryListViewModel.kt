package com.example.countryapp.ui.viewmodel.countrylist

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapp.data.repository.use_cases.GetCountriesUseCase
import com.example.countryapp.ui.viewmodel.CountryListEvents
import com.example.countryapp.ui.viewmodel.countrylist.CountryListState
import com.example.countryapp.util.Constants.DELAY
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//VM-maintain state

@HiltViewModel
class CountryListViewModel @Inject constructor
    (private val getCountriesUseCase: GetCountriesUseCase): ViewModel() {
    //backing property
     private var _state = mutableStateOf(CountryListState())
     val state: State<CountryListState> = _state


    init {
        getCountries()
    }

    //to help in delay during the search, delay will be done in a coroutine to avoid ui lagging
  //  private var searchJob: Job? = null


    //the copy will get the current screen state e.g searching and only modify the changed variable in
    fun getEvent(event: CountryListEvents) {
        when(event) {
            is CountryListEvents.OnSearchQueryChange -> {
                //_state = _state.value.copy(searchQuery = event.query)
               // searchJob?.cancel() //if it a job already exits we cancel the job
                //searchJob = view
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
                    _state.value = CountryListState(countries = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CountryListState(error = result.message?: HTTPERRORMESSAGE)
                }
                is Resource.Loading -> {
                    _state.value = CountryListState(isLoading = true)
                }
            }
        }.launchIn(scope = viewModelScope ) //since onEach is a flow we launch in a coroutine
    }
}
