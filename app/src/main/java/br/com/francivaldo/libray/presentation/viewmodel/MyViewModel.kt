package br.com.francivaldo.libray.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.francivaldo.libray.domain.controller.toUiModel
import br.com.francivaldo.libray.domain.repository.UserCase
import br.com.francivaldo.libray.presentation.Common
import br.com.francivaldo.libray.presentation.model.UiModel
import br.com.francivaldo.libray.presentation.model.UserSettings
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language
import retrofit2.http.Query
import java.util.*


class MyViewModel(private val context: Context? = null):ViewModel() {
    var isDark by mutableStateOf(false)
    var language by mutableStateOf(UserSettings.BR_LANGUAGE)
    var bookList by mutableStateOf(listOf<UiModel>())
    fun search(@Query("search") search:String){
        viewModelScope.launch {
            bookList = UserCase.search(search).map {it.toUiModel()}
        }
    }
    init {
        getDarkTheme()
        getLang()
    }
    fun setLang(language: String){
        if(context == null)
            return
        val editor: SharedPreferences.Editor = context.getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit()
        //SET
        editor.putString(UserSettings.CUSTOM_LANGUAGE,
        if(language == UserSettings.US_LANGUAGE)
            UserSettings.US_LANGUAGE
        else
            UserSettings.BR_LANGUAGE
        )
        editor.apply()
        this.language = language
        //traca a linguagem do sistema
        val locale = Locale(
            if(language == UserSettings.US_LANGUAGE)
                "en"
            else
                "pt"
        )
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        context.resources.updateConfiguration(configuration,context.resources.displayMetrics)
    }
    fun getLang(){
        if(context == null)
            return
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(UserSettings.PREFERENCES, ComponentActivity.MODE_PRIVATE)
        //get
        val lang = sharedPreferences.getString(UserSettings.CUSTOM_LANGUAGE, UserSettings.LIGHT_THEME)
        when(lang){
            UserSettings.BR_LANGUAGE ->{
                language = lang
            }
            UserSettings.US_LANGUAGE ->{
                language = lang
            }
        }
        //carregando
        setLang(language)
    }
    fun setDarkTheme(it: Boolean) {
        if(context == null)
            return
        val editor: SharedPreferences.Editor = context.getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit()
        //SET
        editor.putString(UserSettings.CUSTOM_THEME,if(it)UserSettings.DARK_THEME else UserSettings.LIGHT_THEME)
        editor.apply()
        isDark = it
    }
    fun getDarkTheme():Boolean{
        if(context == null)
            return false
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(UserSettings.PREFERENCES, ComponentActivity.MODE_PRIVATE)
        //get
        val theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME)
        when(theme){
            UserSettings.DARK_THEME->
                isDark = true
            else ->
                isDark = false
        }
        return isDark
    }
}