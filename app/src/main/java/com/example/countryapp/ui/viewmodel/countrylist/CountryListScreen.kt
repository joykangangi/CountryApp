package com.example.countryapp.ui.viewmodel.countrylist

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.countryapp.R
import com.example.countryapp.data.repository.model.Country
import com.example.countryapp.ui.navigation.Screen
import com.example.countryapp.ui.viewmodel.CountryListEvents
import com.example.countryapp.ui.viewmodel.countrydetail.components.CountryListItem

@Composable
fun CountryListScreen(
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel(),
    onSetTitle: (String) -> Unit,
    onShowThemeMenu: (Boolean) -> Unit
) {
    val appTitle = stringResource(id = R.string.explore)
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        onSetTitle(appTitle)
        onShowThemeMenu(true)
    }
    Column {
        SearchViewBar(countryDetailViewModel = viewModel)
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .border(
                        1.dp,
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(1)
                    )
                    .clickable { }
            ) {
                Text(text = "EN")
            }

            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .border(
                        1.dp,
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(1)
                    )
                    .clickable { }
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Filter")
                }

            }
        }

    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.countries.sortedBy { (it.name) }) { country: Country ->
                //  for (letter in 'A'..'Z')
                CountryListItem(
                    country = country,
                    onItemClick = {
                        navController.navigate(Screen.CountryDetailScreen.route + "/${country.name}")
                    }
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
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun SearchViewBar(countryDetailViewModel: CountryListViewModel, searchQuery: String = "") {
    // var searchQuery by rememberSaveable { mutableStateOf("") }

    var query = searchQuery
    var showClearIcon by rememberSaveable {
        mutableStateOf(searchQuery.isNotEmpty())
    }


    TextField(
        value = query,
        onValueChange = {
            countryDetailViewModel.getEvent(CountryListEvents.OnSearchQueryChange(it))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colors.onBackground,
                contentDescription = "search Icon",
            )
        },
        trailingIcon = {
            if (showClearIcon) {
                IconButton(onClick = { query = "" }) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        tint = MaterialTheme.colors.onBackground,
                        contentDescription = "Cancel search"
                    )
                }
            }
        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        placeholder = { Text(text = "Search Disease") },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background, shape = RectangleShape)
    )
}
