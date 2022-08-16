package br.com.francivaldo.libray.data.endpoint

import br.com.francivaldo.libray.data.model.GoogleResult
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleLibray {
    @GET("volumes?q={search}")
    suspend fun search(@Path("search") query:String):GoogleResult
}