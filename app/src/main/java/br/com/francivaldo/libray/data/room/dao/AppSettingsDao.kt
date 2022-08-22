package br.com.francivaldo.libray.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.francivaldo.libray.data.room.entity.AppSettingsEntity
@Dao
interface AppSettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setAppSettings(appSettings: AppSettingsEntity)
    @Query("SELECT * FROM settings")
    suspend fun getAppSettings():AppSettingsEntity
}