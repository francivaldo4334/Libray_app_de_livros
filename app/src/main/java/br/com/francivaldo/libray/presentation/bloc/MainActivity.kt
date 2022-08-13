package br.com.francivaldo.libray.presentation.bloc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.francivaldo.libray.presentation.Screen
import br.com.francivaldo.libray.presentation.pages.layout_library
import br.com.francivaldo.libray.presentation.pages.layout_search
import br.com.francivaldo.libray.presentation.pages.layout_search_result
import br.com.francivaldo.libray.presentation.pages.layout_settings
import br.com.francivaldo.libray.presentation.ui.theme.LibrayTheme
import br.com.francivaldo.libray.presentation.widget.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibrayTheme {
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
    }
}