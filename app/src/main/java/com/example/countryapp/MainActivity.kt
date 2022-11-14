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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    var canPop by remember { mutableStateOf(false) }
    var showThemeMenu by remember { mutableStateOf(false) }
    var filterMenuExpanded by remember { mutableStateOf(false) }

    var appTitle by remember { mutableStateOf("") }

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            null
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(appTitle) },
                navigationIcon = navigationIcon,
                actions = {
                    if (showThemeMenu) { // set from the screens by onThemeMenu event
                    }

                    // menu must be inside the IconButton to dock in proper position

                }

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
                        onSetTitle = { appTitle = it },
                        onShowThemeMenu = { showThemeMenu = it })
                }
                composable(Screen.CountryListScreen.route + "/{name}") { backStackEntry ->
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