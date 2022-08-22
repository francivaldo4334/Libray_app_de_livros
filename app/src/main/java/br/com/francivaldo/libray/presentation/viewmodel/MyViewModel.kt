package br.com.francivaldo.libray.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.francivaldo.libray.data.room.model.toUi
import br.com.francivaldo.libray.domain.controller.toUiModel
import br.com.francivaldo.libray.domain.repository.UserCase
import br.com.francivaldo.libray.domain.repository.UserCase.roomRepository
import br.com.francivaldo.libray.presentation.model.AppSettingsUi
import br.com.francivaldo.libray.presentation.model.UiModel
import br.com.francivaldo.libray.presentation.model.toCtrl
import kotlinx.coroutines.launch
import retrofit2.http.Query

class MyViewModel(application: Application? = null):ViewModel() {
    init {
        if(application != null)
            UserCase.initInstance(application)
    }
    var isDark by mutableStateOf(false)
    var language by mutableStateOf("portugues")
    var bookList by mutableStateOf(listOf<UiModel>())
    fun search(@Query("search") search:String){
        viewModelScope.launch {
            val list = ArrayList<UiModel>()
            UserCase.search(search).map {
                list.add(it.toUiModel())
            }
            bookList = list
        }
    }
    fun setAppSettings(){
        viewModelScope.launch {
            UserCase.setAppSettings(
                AppSettingsUi(
                    language = this@MyViewModel.language,
                    isDark = this@MyViewModel.isDark
                )
                .toCtrl())
        }
    }
    fun getAppSettings(){
        viewModelScope.launch {
            val appSettings = UserCase.roomRepository!!.getAppSettings().toUi()
            isDark = appSettings.isDark
            language = appSettings.language
        }
    }
}