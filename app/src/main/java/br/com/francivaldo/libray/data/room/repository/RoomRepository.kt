package br.com.francivaldo.libray.data.room.repository

import br.com.francivaldo.libray.data.room.dao.AppSettingsDao
import br.com.francivaldo.libray.data.room.entity.toData
import br.com.francivaldo.libray.data.room.model.AppSettingsData
import br.com.francivaldo.libray.data.room.model.toEntity

class RoomRepository(
    private val appSettingsDao: AppSettingsDao
) : RoomRepositoryInterface{
    override suspend fun getAppSettings(): AppSettingsData {
        return appSettingsDao.getAppSettings().toData()
    }

    override suspend fun setAppSettings(appsettings: AppSettingsData) {
        appSettingsDao.setAppSettings(appSettings = appsettings.toEntity())
    }

}
interface RoomRepositoryInterface{
    suspend fun getAppSettings():AppSettingsData
    suspend fun setAppSettings(appsettings:AppSettingsData)
}