package br.com.francivaldo.libray.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.francivaldo.libray.domain.controller.toUiModel
import br.com.francivaldo.libray.domain.repository.UserCase
import br.com.francivaldo.libray.presentation.model.UiModel
import kotlinx.coroutines.launch
import retrofit2.http.Query

class MyViewModel:ViewModel() {
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
}