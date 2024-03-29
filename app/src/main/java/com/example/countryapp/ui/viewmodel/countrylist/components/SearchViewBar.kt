package com.example.countryapp.ui.viewmodel.countrylist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchViewBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {

    OutlinedTextField(
        value = searchQuery,
        onValueChange = {
            onSearchQueryChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            cursorColor = MaterialTheme.colors.onSecondary
        ),
        placeholder = { Text(text = "Search Country") },
        textStyle = MaterialTheme.typography.subtitle2,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(color = MaterialTheme.colors.background, shape = RectangleShape)
            .border(width = 1.dp, color = MaterialTheme.colors.onPrimary)

    )
}

@Preview
@Composable
fun SearchPreview() {
    SearchViewBar(searchQuery = "", onSearchQueryChange = {})
}
