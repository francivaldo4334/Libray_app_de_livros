package br.com.francivaldo.libray.data.network.repository

import br.com.francivaldo.libray.data.network.model.GoogleResult
import br.com.francivaldo.libray.data.network.model.Item
import br.com.francivaldo.libray.data.network.request.ObjectRetrofit

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