//package br.com.francivaldo.libray.data.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import br.com.francivaldo.libray.data.room.dao.AppSettingsDao
//import br.com.francivaldo.libray.data.room.entity.AppSettingsEntity
//
//@Database(entities = [(AppSettingsEntity::class)], version = 1)
//abstract class AppRoomDatabase : RoomDatabase() {
//    abstract fun getAppSettings():AppSettingsDao
//
//    companion object {
//
//        private var INSTANCE: AppRoomDatabase? = null
//
//        fun getInstance(context: Context): AppRoomDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        AppRoomDatabase::class.java,
//                        "product_database"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}