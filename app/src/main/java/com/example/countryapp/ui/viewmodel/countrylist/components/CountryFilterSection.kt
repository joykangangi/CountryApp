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
import androidx.compose.ui.unit.sp
import com.example.countryapp.R

@Composable
fun CountryFilterSection(modifier: Modifier) {

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = modifier
                .size(width = 73.dp, height = 40.dp)
                .shadow(
                    shape = RoundedCornerShape(4.dp),
                    elevation = 1.dp
                )
                .clickable { }
        ) {
            Row(modifier.padding(3.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.globe),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )

                Text(text = "EN", fontSize = 10.sp)
            }
        }

        Box(
            modifier = modifier
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
                    modifier = Modifier.size(20.dp)
                )
                Text(text = "Filter")
            }

        }
    }
}