package br.com.francivaldo.libray.presentation

class Constants{
    companion object{
    }
}
class Common {
    companion object{
        var isDark = false
    }
}
sealed class Screen(val route:String){
    class Search():Screen("Search")
    class SearchRes():Screen("SearcheResult")
    class Settings():Screen("Settings")
    class Library():Screen("Library")
}