package br.com.francivaldo.libray.data.room.model

import br.com.francivaldo.libray.data.room.entity.AppSettingsEntity
import br.com.francivaldo.libray.domain.controller.AppSettingsCtrl
import br.com.francivaldo.libray.presentation.model.AppSettingsUi

data class AppSettingsData(
    val language: String,
    val isDark: Boolean
)
fun AppSettingsData.toEntity() = AppSettingsEntity(
    language = this.language,
    isDark = this.isDark
)
fun AppSettingsData.toCtrl() = AppSettingsCtrl(
    language = this.language,
    isDark = this.isDark

)
fun AppSettingsData.toUi() = AppSettingsUi(
    language = this.language,
    isDark = this.isDark
)

