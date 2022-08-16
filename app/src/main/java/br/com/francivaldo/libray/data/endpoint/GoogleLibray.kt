package br.com.francivaldo.libray.data.endpoint

import br.com.francivaldo.libray.data.model.GoogleResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleLibray {
    @GET("volumes")
    suspend fun search(@Query("q") query:String):GoogleResult
}