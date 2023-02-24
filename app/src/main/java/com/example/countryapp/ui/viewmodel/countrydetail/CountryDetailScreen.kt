package com.example.countryapp.ui.viewmodel.countrydetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.countryapp.data.remote.dto.countrydto.toListLang
import com.example.countryapp.data.remote.dto.countrydto.toStringIdd
import com.example.countryapp.domain.model.Country
import com.example.countryapp.ui.navigation.Screen
import com.example.countryapp.ui.util.CountryCodeConverter.iso3ToIso2Code
import com.example.countryapp.ui.util.cleanList
import com.example.countryapp.ui.util.firstCapital
import com.example.countryapp.ui.util.formatCommaSeparator


@Composable
fun CountryDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CountryDetailViewModel = hiltViewModel()
) {
    val detailState = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        detailState.country?.let { countryDetail: Country ->
            TopAppBarCountry(country = countryDetail, navController = navController)

            CountryImagePaging(countryDetail = countryDetail, modifier = modifier.padding(3.dp))

            Box(modifier = modifier.fillMaxSize()) {
                Column(
                    modifier = modifier.padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailsText(
                        title = "Population",
                        details = countryDetail.population.formatCommaSeparator()
                    )
                    DetailsText(title = "Region", details = countryDetail.region)
                    DetailsText(title = "Sub-Region", details = countryDetail.subregion)
                    DetailsText(title = "Capital", details = countryDetail.capital.first())

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailsText(
                        title = "Official Language(s)",
                        details = cleanList(toListLang(countryDetail.languages))
                    )
                    DetailsText(title = "Area", details = countryDetail.area ?: "N/A")
                    DetailsText(title = "Currency Name", details = countryDetail.currencyName)
                    DetailsText(
                        title = "Currency Symbol",
                        details = countryDetail.currencySymbol
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailsText(
                        title = "Landlocked",
                        details = countryDetail.landlocked.toString().firstCapital()
                    )
                    DetailsText(
                        title = "Time Zone",
                        details = cleanList(countryDetail.timezones)
                    )
                    DetailsText(
                        title = "Dialing Code",
                        details = toStringIdd(countryDetail.idd)
                    )
                    DetailsText(
                        title = "Car Side",
                        details = countryDetail.carSide.toString().firstCapital()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailsText(
                        title = "Un Member",
                        details = if (countryDetail.unMember == true) "Yes" else "No"
                    )
                    DetailsText(title = "Demonyms", details = countryDetail.demonyms)
                    DetailsText(
                        title = "Start of Week",
                        details = countryDetail.startOfWeek.firstCapital()
                    )
                    DetailsText(
                        title = "Borders",
                        details = iso3ToIso2Code(countryDetail.borders)
                    )
                    Spacer(modifier = modifier.height(3.dp))
                }

                //if there is an error message
                if (detailState.error.isNotBlank()) {
                    Text(
                        text = detailState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }

                if (detailState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    }
}

@Composable
fun DetailsText(
    title: String,
    details: Any,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    detailStyle: TextStyle = MaterialTheme.typography.body1
) {
    Row {
        Text(text = "$title: ", style = titleStyle)
        Text(text = details.toString(), style = detailStyle)
    }
}


@Composable
fun TopAppBarCountry(country: Country, navController: NavController) {
    TopAppBar(
        title = {
            Text(country.name, style = MaterialTheme.typography.h6)
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.CountryListScreen.route)
            }) {
                Icon(Icons.Default.ArrowBack, null)
            }
        }
    )
}

/*
@Composable
fun ImageDetail(images: List<String> ) {
    Box(modifier = Modifier.fillMaxWidth()) {
        for (image in images) {
            AsyncImage(model = image, contentDescription = null)
        }
    }

 */