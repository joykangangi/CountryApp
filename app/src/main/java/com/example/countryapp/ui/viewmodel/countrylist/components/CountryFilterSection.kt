package com.example.countryapp.ui.viewmodel.countrylist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.countryapp.R

@Composable
fun CountryFilterSection() {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(width = 73.dp, height = 40.dp)
                .shadow(
                    shape = RoundedCornerShape(4.dp),
                    elevation = 1.dp
                )
                .clickable { }
        ) {
            Row(Modifier.padding(3.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.globe),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )

                Text(text = "EN")
            }
        }

        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(width = 73.dp, height = 40.dp)
                .shadow(
                    shape = RoundedCornerShape(4.dp),
                    elevation = 1.dp
                )
                .clickable { }
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Filter")
            }

        }
    }
}