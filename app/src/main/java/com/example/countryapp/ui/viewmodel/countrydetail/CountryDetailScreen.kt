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
import com.example.countryapp.data.remote.dto.countrydto.getCurrencyProp
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
    Box(modifier = modifier.fillMaxWidth()) {
        state.country?.let { countryDetail: Country ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                TopAppBarCountry(country = countryDetail, navController = navController)

                CountryImagePaging(countryDetail = countryDetail)

                Divider()
                DetailsText(title = "Population", details = countryDetail.population)
                DetailsText(title = "Region", details = countryDetail.region)
                DetailsText(title = "Capital", details = countryDetail.capital.forEach {
                    Row {
                       Text(text = it)
                    }
                })
                DetailsText(title = "IsLandLocked", details = countryDetail.landlocked)
                Spacer(modifier = Modifier.height(10.dp))
                DetailsText(title = "Official Language", details = toListLang(countryDetail.languages).forEach {
                    Row {
                        Text(text = it)
                    }
                })
                DetailsText(title = "Area", details = countryDetail.area ?: "N/A")
                DetailsText(title = "Car Side", details = countryDetail.carSide ?: "N/A")
                getCurrencyProp(countryDetail.currencies).values.first()
                    ?.let { DetailsText(title = "Currency", details = it) }
                Spacer(modifier = Modifier.height(10.dp))
                DetailsText(title = "Landlocked", details = countryDetail.landlocked)
                DetailsText(title = "Time Zone", details = countryDetail.timezones.forEach {
                    Row{
                        Text(text = it)
                    }
                })
                DetailsText(title = "Dialing Code", details = countryDetail.idd.toListIdd(countryDetail.idd))
                DetailsText(title = "Sub-Region", details = countryDetail.subregion)

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


@Composable
fun DetailsText(
    title: String,
    details: Any,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    detailStyle: TextStyle = MaterialTheme.typography.body1
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "$title: ", style = titleStyle)
        Text(text = details.toString(), style = detailStyle)
    }
}



@Composable
fun TopAppBarCountry(country: Country,navController: NavController) {
    TopAppBar(
        title = {
            Text(country.name, style = MaterialTheme.typography.h6)
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.CountryListScreen.route)
            }) {
                Icon(Icons.Default.ArrowBack,null)
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