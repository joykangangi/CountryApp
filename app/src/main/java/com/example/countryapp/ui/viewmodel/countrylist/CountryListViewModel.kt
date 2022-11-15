package com.example.countryapp.ui.viewmodel.countrylist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapp.data.repository.model.Country
import com.example.countryapp.data.repository.use_cases.GetCountriesUseCase
import com.example.countryapp.ui.viewmodel.CountryListEvents
import com.example.countryapp.ui.viewmodel.countrydetail.CountryDetailState
import com.example.countryapp.util.Constants.DELAY
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

//VM-maintain state

@HiltViewModel
class CountryListViewModel @Inject constructor
    (private val getCountriesUseCase: GetCountriesUseCase): ViewModel() {


    //backing property
    private var _state = mutableStateOf(CountryListState())
    val state: State<CountryListState> = _state

    private var _detailState = mutableStateOf(CountryDetailState())
    val detailState: State<CountryDetailState> = _detailState
    private val filteredList = mutableListOf<Country>()


    init {
        getCountries()
    }

    private fun getCountries() {
        getCountriesUseCase().onEach { result->
            when(result) {
                is Resource.Error -> {
                    _state.value = CountryListState(error = HTTPERRORMESSAGE)
                }
                is Resource.Loading -> {
                    _state.value = CountryListState(isLoading = true)
                }
                is Resource.Success -> {
                    val groupedCountries = result.data?.sortedBy { it.name }?.groupBy { it.name[0] }
                    _state.value = CountryListState(countries = groupedCountries )
                    result.data?.let { filteredList.addAll(it.toList()) }
                }
            }
        }.launchIn(viewModelScope)
    }

    //to help in delay during the search, delay will be done in a coroutine to avoid ui lagging
    private var searchJob: Job? = null


    //the copy will get the current screen state e.g searching and only modify the changed variable in the state
    fun getEvent(event: CountryListEvents) {
        when (event) {
            is CountryListEvents.OnSearchQueryChange -> {
                _state.value = _state.value.copy(searchQuery = event.query)
                searchJob?.cancel() //if it a job already exits we cancel the job
                searchJob = viewModelScope.launch {
                    delay(DELAY)
                    getCountrySearch()
                }
            }

            is CountryListEvents.OnSelectFilter -> {
                //Todo
            }
        }
    }

    private fun getCountrySearch(
        query: String = _state.value.searchQuery.lowercase()
    ) {
        viewModelScope.launch {
            val newCountryList: List<Country> =
                filteredList.filter {country ->
                    country.name.lowercase().contains(query)
                }

            _state.value = _state.value.copy(countries = newCountryList.sortedBy {
                it.name }.groupBy { it.name[0] })
        }
    }
    fun setSelectedCountry(country: Country) {
        _detailState.value = CountryDetailState(country = country)
    }

}
