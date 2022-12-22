package com.example.countryapp.ui.viewmodel.countrylist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.countryapp.domain.model.Country

@Composable
fun CountryListItem(
    country: Country,
    modifier: Modifier = Modifier,
    onCountryClicked: (Country) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCountryClicked(country) }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = country.flagEmoji,
               // .crossfade(true) ,
            //placeholder = painterResource(R.drawable.ic_placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(40.dp) .clip(RoundedCornerShape(6.dp),)
               // .padding(bottom = 16.dp).padding(start = 2.dp)
        )

        Column(modifier = Modifier.padding(start = 17.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = country.name, style = MaterialTheme.typography.subtitle2,color = MaterialTheme.colors.onPrimary)
            for (capital in country.capital) {
                Text(text = "$capital,", style = MaterialTheme.typography.body2, color = MaterialTheme.colors.onSecondary)
            }
        }
    }
}