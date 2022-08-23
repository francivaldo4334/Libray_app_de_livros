package br.com.francivaldo.libray.domain.repository

import br.com.francivaldo.libray.data.network.request.ObjectRetrofit
import br.com.francivaldo.libray.domain.controller.SearchResult
import br.com.francivaldo.libray.domain.controller.fromData

object UserCase : UserCaseInterface{
//    var roomRepository:RoomRepository? = null
//    fun initInstance(application: Application){
//        val appRoomDatabase = AppRoomDatabase.getInstance(application)
//        roomRepository = RoomRepository(appRoomDatabase.getAppSettings())
//    }
    override suspend fun search( search: String): List<SearchResult> {
        val list = ArrayList<SearchResult>()
        val responselist = ObjectRetrofit.invoke().search(search)
        responselist.items.map {
            list.add(SearchResult().fromData(it.volumeInfo))
        }
        return list
    }

//    override suspend fun getAppSettings(): AppSettingsCtrl {
//        return roomRepository!!.getAppSettings().toCtrl()
//    }

//    override suspend fun setAppSettings(appsettings: AppSettingsCtrl) {
//        roomRepository!!.setAppSettings(appsettings.toData())
//    }
}
interface UserCaseInterface{
    suspend fun search(query:String):List<SearchResult>
//    suspend fun getAppSettings(): AppSettingsCtrl
//    suspend fun setAppSettings(appsettings: AppSettingsCtrl)
}