package com.example.countryapp.ui.viewmodel.countrylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.countryapp.R
import com.example.countryapp.domain.model.Country
import com.example.countryapp.ui.navigation.Screen
import com.example.countryapp.ui.theme.ElsieFont
import com.example.countryapp.ui.viewmodel.CountryListEvents
import com.example.countryapp.ui.viewmodel.countrylist.components.CountryFilterSection
import com.example.countryapp.ui.viewmodel.countrylist.components.CountryListItem
import com.example.countryapp.ui.viewmodel.countrylist.components.SearchViewBar

@Composable
fun CountryListScreen(
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBarExplore()

        SearchViewBar(searchQuery = state.searchQuery) { query ->
            viewModel.getEvent(CountryListEvents.OnSearchQueryChange(query))
        }

        CountryFilterSection(modifier = Modifier.padding(10.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                state.countries?.forEach { (initial, countries) ->
                    item {
                        Text(
                            text = initial.toString(),
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .padding(
                                    start = 4.dp,
                                    bottom = 4.dp
                                ),
                            color = MaterialTheme.colors.onPrimary
                        )
                    }

                    items(countries) { country: Country ->
                        CountryListItem(country = country) {
                            viewModel.setSelectedCountry(country)
                            navController.navigate(Screen.CountryDetailScreen.route + "/${it.name}")
                        }
                    }
                }
            }

            //if there is an error message
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun TopAppBarExplore() {
    TopAppBar(
        title = {
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(fontFamily = ElsieFont)
                ) {
                    append(stringResource(id = R.string.explore))
                }

                withStyle(
                    style = SpanStyle(fontSize = 3.sp, baselineShift = BaselineShift.Subscript)
                ) {
                    append("🟠")
                }
            }
            )
        }
    )
}


