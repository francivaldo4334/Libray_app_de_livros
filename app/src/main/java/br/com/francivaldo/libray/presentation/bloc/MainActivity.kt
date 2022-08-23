package br.com.francivaldo.libray.presentation.bloc

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.Screen
import br.com.francivaldo.libray.presentation.pages.layout_library
import br.com.francivaldo.libray.presentation.pages.layout_search
import br.com.francivaldo.libray.presentation.pages.layout_search_result
import br.com.francivaldo.libray.presentation.pages.layout_settings
import br.com.francivaldo.libray.presentation.ui.theme.LibrayTheme
import br.com.francivaldo.libray.presentation.viewmodel.MyViewModel
import br.com.francivaldo.libray.presentation.model.UserSettings
import br.com.francivaldo.libray.presentation.widget.BottomNavigationBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Common.setMyViewModel(MyViewModel(this.application))
//        Common.getMyViewModel().getAppSettings()
        setContent {
            LibrayTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(MaterialTheme.colors.background,MaterialTheme.colors.isLight)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Box(
                        contentAlignment = Alignment.BottomCenter
                    ){
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = Screen.Search().route)
                        {
                            composable(Screen.Search().route){
                                layout_search()
                            }
                            composable(Screen.SearchRes().route){
                                layout_search_result()
                            }
                            composable(Screen.Settings().route){
                                layout_settings()
                            }
                            composable(Screen.Library().route){
                                layout_library()
                            }
                        }
                        BottomNavigationBar(navController = navController)
                    }
                }
            }
        }
//        Common.setAppSettings(UserSettings())
//        loadSharedPreferences()
    }
//    fun loadSharedPreferences() {
//        val sharedPreferences: SharedPreferences =
//            getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE)
//        val theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME)
//        Common.getAppSettings().customTheme = theme
//    }
}