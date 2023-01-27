
package com.example.countryapp.ui.viewmodel.countrylist.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.countryapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)
@Composable
fun LanguageFilter(modifier: Modifier) {

    //save state when it is closed
    val langSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.Expanded }
    )

    val coroutineScope = rememberCoroutineScope()

    //handling presses of the system back button
    BackHandler(langSheetState.isVisible) {
        coroutineScope.launch { langSheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = langSheetState,
        sheetContent = {
            LanguageBottomSheet(
                state = langSheetState,
                coroutineScope = coroutineScope
            )
        },
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    ) {
        Row {

            //Language Filter
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (langSheetState.isVisible) langSheetState.hide()
                        else langSheetState.show()
                    }
                },
                modifier = modifier
                    .size(height = 40.dp, width = 100.dp)
                    .padding(3.dp)
                    .shadow(elevation = 1.dp, shape = RoundedCornerShape(4.dp))
                    .background(color = MaterialTheme.colors.primary)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.globe),
                    contentDescription = stringResource(
                        id = R.string.globe
                    ),
                    modifier = modifier.size(30.dp)
                )

                Text(text = "EN")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LanguageBottomSheet(state: ModalBottomSheetState, coroutineScope: CoroutineScope) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Languages", style = MaterialTheme.typography.subtitle1)
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        coroutineScope.launch { state.hide() }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        LanguageFilterSection()

    }
}


@Composable
fun LanguageFilterSection() {
    val languageOptions = listOf("Bahasa", "Deutsch", "English", "Espanol", "Francaise",
        "Italiano", "Portugues", "Pycckuu", "Svenska", "Turkce")

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(languageOptions[2]) }

    Column(Modifier.fillMaxWidth()) {
        languageOptions.forEach { language->
            Column(Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .selectable(
                    selected = (language == selectedOption),
                    onClick = { onOptionSelected(language) }
                ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = language, style = MaterialTheme.typography.body1)
                RadioButton(
                    selected = (language == selectedOption),
                    onClick = { onOptionSelected(language) })
            }
        }

    }
    }
}
