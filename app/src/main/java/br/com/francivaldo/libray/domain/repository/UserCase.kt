package br.com.francivaldo.libray.domain.repository

import br.com.francivaldo.libray.data.request.ObjectRetrofit
import br.com.francivaldo.libray.domain.controller.SearchResult
import br.com.francivaldo.libray.domain.controller.fromData

object UserCase : UserCaseInterface{
    override suspend fun search( search: String): List<SearchResult> {
        val list = ArrayList<SearchResult>()
        val responselist = ObjectRetrofit.invoke().search(search)
        responselist.items.map {
            list.add(SearchResult().fromData(it.volumeInfo))
        }
        return list
    }
}
interface UserCaseInterface{
    suspend fun search(query:String):List<SearchResult>
}