package br.com.francivaldo.libray.presentation.model

import br.com.francivaldo.libray.domain.controller.AppSettingsCtrl

data class AppSettingsUi (
    val language: String,
    val isDark: Boolean
)
fun AppSettingsUi.toCtrl() = AppSettingsCtrl(
    language = this.language,
    isDark = this.isDark
)