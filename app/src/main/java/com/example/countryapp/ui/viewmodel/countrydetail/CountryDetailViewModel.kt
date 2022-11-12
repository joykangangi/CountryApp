package com.example.countryapp.ui.viewmodel.countrydetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapp.data.repository.use_cases.GetCountryUseCase
import com.example.countryapp.util.Constants.HTTPERRORMESSAGE
import com.example.countryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    //backing property
    private var _state = mutableStateOf(CountryDetailState())
    val state: State<CountryDetailState> = _state

    init {
        savedStateHandle.get<String>("name")?.let { name->
            getCountry(name)
        }
    }

    private fun getCountry(name: String) {
        getCountryUseCase(name).onEach { result->
            when(result) {
                is Resource.Error -> {
                    _state.value = CountryDetailState(error = HTTPERRORMESSAGE)
                }
                is Resource.Loading -> {
                    _state.value = CountryDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CountryDetailState(country = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}