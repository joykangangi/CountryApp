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
import com.example.countryapp.data.remote.dto.countrydto.toListIdd
import com.example.countryapp.data.remote.dto.countrydto.toListLang
import com.example.countryapp.domain.model.Country
import com.example.countryapp.ui.navigation.Screen

@Composable
fun CountryDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CountryDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        state.country?.let { countryDetail: Country ->
            TopAppBarCountry(country = countryDetail, navController = navController)

            CountryImagePaging(countryDetail = countryDetail, modifier = modifier.padding(3.dp))

            Box(modifier = modifier.fillMaxWidth()) {
                Column(
                    modifier = modifier.padding(5.dp)
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    DetailsText(title = "Population", details = countryDetail.population)
                    DetailsText(title = "Region", details = countryDetail.region)
                    DetailsText(title = "Sub-Region", details = countryDetail.subregion)
                    DetailsText(title = "Capital", details = countryDetail.capital.first())
                    Spacer(modifier = Modifier.height(10.dp))
                    DetailsText(
                        title = "Official Language",
                        details = toListLang(countryDetail.languages).toString().removeSurrounding(
                            '['.toString(),
                            ']'.toString()
                        )
                    )
                    DetailsText(title = "Area", details = countryDetail.area ?: "N/A")
                    DetailsText(title = "Car Side", details = countryDetail.carSide ?: "N/A")
                    DetailsText(
                        title = "Currency Name",
                        details = "${countryDetail.currencyName}, ${countryDetail.currencySymbol}"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DetailsText(title = "Landlocked", details = countryDetail.landlocked ?: false)
                    DetailsText(
                        title = "Time Zone",
                        details = countryDetail.timezones.toString()
                            .removeSurrounding('['.toString(), ']'.toString())
                    )
                    DetailsText(
                        title = "Dialing Code",
                        details = toListIdd(countryDetail.idd).replace("[", "").replace("]", "")
                    )
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
                        .align(Alignment.CenterHorizontally)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
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