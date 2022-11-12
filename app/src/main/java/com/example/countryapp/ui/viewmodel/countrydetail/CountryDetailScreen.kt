package com.example.countryapp.ui.viewmodel.countrydetail

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.countryapp.R
import com.example.countryapp.data.remote.dto.countrydto.Spa
import com.example.countryapp.data.repository.model.CountryDetail

@Composable
fun CountryDetailScreen(
    viewModel: CountryDetailViewModel = hiltViewModel(),
    onSetTitle: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val appTitle = stringResource(id = R.string.explore)
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        state.country?.name?.let { onSetTitle(it) }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        state.country?.let { countryDetail: CountryDetail ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = countryDetail.flags,
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp)

                )
                Divider()
                DetailsText(title = "Population", details = countryDetail.population)
                DetailsText(title = "Region", details = countryDetail.region)
                DetailsText(title = "Capital", details = countryDetail.capital)
                DetailsText(title = "IsLandLocked", details = countryDetail.landlocked)
                Spacer(modifier = Modifier.height(10.dp))
                DetailsText(title = "Official Language", details = countryDetail.languages)
                DetailsText(title = "Area", details = countryDetail.area)
                DetailsText(title = "Car Side", details = countryDetail.carSide)
                DetailsText(title = "Currency", details = countryDetail.currencies)
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