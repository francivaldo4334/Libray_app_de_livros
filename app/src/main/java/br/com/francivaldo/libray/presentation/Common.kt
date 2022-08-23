package br.com.francivaldo.libray.presentation

import br.com.francivaldo.libray.presentation.viewmodel.MyViewModel
import br.com.francivaldo.libray.presentation.model.UserSettings

class Common {
    companion object{
//        private var settings: UserSettings? = null
        private var myViewModel:MyViewModel = MyViewModel()
        fun getMyViewModel():MyViewModel{
            return myViewModel
        }
        fun setMyViewModel(myViewModel:MyViewModel){
            this.myViewModel = myViewModel
        }
//        fun setAppSettings(settings: UserSettings){
//            this.settings = settings
//        }
//        fun getAppSettings(): UserSettings {
//            return settings!!
//        }
    }
}
sealed class Screen(val route:String){
    class Search():Screen("Search")
    class SearchRes():Screen("SearcheResult")
    class Settings():Screen("Settings")
    class Library():Screen("Library")
}