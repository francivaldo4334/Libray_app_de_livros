package br.com.francivaldo.libray.data.repository

import android.util.Log
import br.com.francivaldo.libray.data.model.GoogleResult
import br.com.francivaldo.libray.data.model.Item
import br.com.francivaldo.libray.data.request.ObjectRetrofit

class GoogleSearchRepository:GoogleSearchRepositoryInpl{
    override suspend fun search(query: String): GoogleResult {
        return try {
            ObjectRetrofit.invoke().search(query)
        }catch (e :Exception){
            GoogleResult(
                items = listOf<Item>(),
                kind = "books#volumes",
                totalItems = 0
            )
        }
    }

}
interface GoogleSearchRepositoryInpl{
    suspend fun search(query:String):GoogleResult
}