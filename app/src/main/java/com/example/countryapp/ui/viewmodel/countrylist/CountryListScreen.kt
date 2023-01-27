package com.example.countryapp.ui.viewmodel.countrylist

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import com.example.countryapp.ui.theme.GreyText
import com.example.countryapp.ui.theme.OrangeButton
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

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 12.dp, top = 8.dp, end = 12.dp)) {

        TopAppBarExplore(viewModel)

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
                                    start = 8.dp,
                                    bottom = 4.dp
                                ),
                            color = GreyText
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
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colors.onSecondary)
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

        }
    }
}

@Composable
fun TopAppBarExplore(viewModel: CountryListViewModel) {
    val isDarkTheme = viewModel.state.value.darkTheme

    TopAppBar(
        title = {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontFamily = ElsieFont, fontSize = 26.sp)
                    ) {
                        append(stringResource(id = R.string.explore))
                    }

                    withStyle(
                        style = SpanStyle(fontSize = 26.sp, color = OrangeButton)
                    ) {
                        append(".")
                    }
                }
            )
        },

        //manage dark theme as state, default is light theme
        actions = {
            IconButton(
                onClick = {
                   viewModel.updateTheme()
                }
            ) {
                Icon(
                    painter = (if (isDarkTheme) painterResource(id = R.drawable.ic_dark_theme) else painterResource(
                        id = R.drawable.ic_light_theme
                    )),
                    contentDescription = "Light / Dark Mode Switch",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    )
}


