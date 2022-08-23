package br.com.francivaldo.libray.presentation.bloc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.pages.layout_search_result
import br.com.francivaldo.libray.presentation.ui.theme.LibrayTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class SearchResultActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibrayTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    MaterialTheme.colors.background,
                    MaterialTheme.colors.isLight)
               layout_search_result()
            }
        }
    }
}