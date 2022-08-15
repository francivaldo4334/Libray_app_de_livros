package br.com.francivaldo.libray.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Constants{
    companion object{
    }
}
class Common {
    companion object{
        var isDark by mutableStateOf(false)
    }
}
sealed class Screen(val route:String){
    class Search():Screen("Search")
    class SearchRes():Screen("SearcheResult")
    class Settings():Screen("Settings")
    class Library():Screen("Library")
}