package com.example.countryapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countryapp.ui.navigation.Screen
import com.example.countryapp.ui.theme.CountryAppTheme
import com.example.countryapp.ui.viewmodel.countrydetail.CountryDetailScreen
import com.example.countryapp.ui.viewmodel.countrylist.CountryListScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CountryApp()
                }

            }

        }
    }
}


@Composable
fun CountryApp() {

    val navController = rememberNavController()
    var appTitle by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(appTitle) }
            )
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = Screen.CountryListScreen.route
            ) {
                composable(Screen.CountryListScreen.route) {
                    CountryListScreen(
                        navController,
                        onSetTitle = { appTitle = it }
                    )
                }
                composable(Screen.CountryDetailScreen.route + "/{name}") { backStack->
                    CountryDetailScreen(
                        onSetTitle = { appTitle = it },
                        modifier = Modifier.padding(paddingValues = it)
                    )
                }
            }
        }
    )
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DefaultPreview() {
    CountryAppTheme {

    }
}