package com.example.countryapp.ui.viewmodel.countrydetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.countryapp.R
import com.example.countryapp.domain.model.Country

@Composable
fun CountryDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CountryDetailViewModel = hiltViewModel(),
    onSetTitle: (String) -> Unit
) {
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        state.country?.name?.let { onSetTitle(it) }
    }

    Box(modifier = modifier.fillMaxWidth()) {
        state.country?.let { countryDetail: Country ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
            ) {

                Divider()
                DetailsText(title = "Population", details = countryDetail.population)
                DetailsText(title = "Region", details = countryDetail.region)
                DetailsText(title = "Capital", details = countryDetail.capital)
                DetailsText(title = "IsLandLocked", details = countryDetail.landlocked)
                Spacer(modifier = Modifier.height(10.dp))
                DetailsText(title = "Official Language", details = countryDetail.languages ?: "N/A")
                DetailsText(title = "Area", details = countryDetail.area ?: "N/A")
                DetailsText(title = "Car Side", details = countryDetail.carSide ?: "N/A")
                DetailsText(title = "Currency", details = countryDetail.currencies ?: "N/A")
                Spacer(modifier = Modifier.height(10.dp))
                DetailsText(title = "Landlocked", details = countryDetail.landlocked)
                DetailsText(title = "Time Zone", details = countryDetail.timezones)
                DetailsText(title = "Dialing Code", details = countryDetail.idd)
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
fun ImagesSection(countryDetail: Country) {
    AsyncImage(
        model = countryDetail.coatOfArms,
        contentDescription = null,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(width = 380.dp, height = 200.dp)
            .padding(bottom = 16.dp)

    )
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(countryDetail.flags)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(width = 380.dp, height = 200.dp)
            .padding(bottom = 16.dp)
    )
}


@Composable
fun DetailsText(
    title: String,
    details: Any,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    detailStyle: TextStyle = MaterialTheme.typography.body1
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = title, style = titleStyle)
        Text(text = details.toString(), style = detailStyle)
    }
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