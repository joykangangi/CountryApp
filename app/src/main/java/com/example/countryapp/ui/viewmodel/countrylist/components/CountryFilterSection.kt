package com.example.countryapp.ui.viewmodel.countrylist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.countryapp.R

@Composable
fun CountryFilterSection(modifier: Modifier) {

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Card(
            modifier = modifier
                .padding(3.dp)
                .size(width = 73.dp, height = 40.dp)
                .clickable { },
            shape = RoundedCornerShape(4.dp),
            elevation = 1.dp
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(3.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.globe),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(text = "EN")
            }
        }

        Card(
            modifier = modifier
                .padding(1.dp)
                .size(width = 73.dp, height = 40.dp)
                .clickable {},
            shape = RoundedCornerShape(4.dp),
            elevation = 1.dp
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(3.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(text = "Filter")
            }
        }
    }
}