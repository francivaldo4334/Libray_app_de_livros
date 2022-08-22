package br.com.francivaldo.libray.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.francivaldo.libray.presentation.viewmodel.MyViewModel

class Common {
    companion object{
        val myViewModel:MyViewModel = MyViewModel()
        var isDark by mutableStateOf(false)
    }
}
sealed class Screen(val route:String){
    class Search():Screen("Search")
    class SearchRes():Screen("SearcheResult")
    class Settings():Screen("Settings")
    class Library():Screen("Library")
}