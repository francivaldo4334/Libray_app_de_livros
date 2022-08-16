package br.com.francivaldo.libray.data.request

import br.com.francivaldo.libray.data.endpoint.GoogleLibray
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ObjectRetrofit {
    val BASE_URL = "https://www.googleapis.com/books/v1/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .client(OkHttpClient.Builder().build())
        .build()
    fun invoke():GoogleLibray{
        return retrofit.create(GoogleLibray::class.java)
    }
}