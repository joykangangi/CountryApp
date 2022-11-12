package com.example.countryapp.ui.viewmodel.countrydetail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.countryapp.data.repository.model.Country

@Composable
fun CountryListItem(
    country: Country,
    onItemClick: (Country) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(country) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = country.flagEmoji,
            contentDescription = null
        )
        Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = country.name, style = MaterialTheme.typography.subtitle1)
            for (capital in country.capital) {
                Text(text = "$capital,", style = MaterialTheme.typography.body1)
            }

        }
    }
}