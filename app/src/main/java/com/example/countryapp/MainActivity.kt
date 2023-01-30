package com.example.countryapp

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countryapp.ui.navigation.Screen
import com.example.countryapp.ui.theme.CountryAppTheme
import com.example.countryapp.ui.viewmodel.countrydetail.CountryDetailScreen
import com.example.countryapp.ui.viewmodel.countrylist.CountryListScreen
import com.example.countryapp.ui.viewmodel.countrylist.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var application: CountryApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CountryAppTheme(darkTheme = application.isDark.value) {
                Log.i("Main Activity1", "isDarkTheme = ${application.isDark.value}")
                Surface(color = MaterialTheme.colors.background) {
                    CountryApp(
                        isDark = application.isDark.value,
                        toggleTheme = { application.toggleLightTheme() }
                    )
                }
            }
        }
    }
}

@Composable
fun CountryApp(isDark: Boolean, toggleTheme: () -> Unit) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CountryListScreen.route
    ) {
        composable(Screen.CountryListScreen.route) {
            CountryListScreen(navController, toggleTheme = toggleTheme, isDarkTheme = isDark)
        }

        composable(Screen.CountryDetailScreen.route + "/{name}") {
            CountryDetailScreen(
                modifier = Modifier.padding(2.dp),
                navController = navController
            )
        }
    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DefaultPreview() {
    CountryAppTheme(darkTheme = false) {

    }
}