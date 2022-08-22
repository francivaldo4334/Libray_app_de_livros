package br.com.francivaldo.libray.domain.controller

import br.com.francivaldo.libray.data.room.model.AppSettingsData

data class AppSettingsCtrl(
    val language: String,
    val isDark:Boolean
)
fun AppSettingsCtrl.toData() = AppSettingsData(
    language = this.language,
    isDark = this.isDark
)