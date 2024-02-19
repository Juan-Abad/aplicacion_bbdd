package com.juan.aplicacion_bbdd.data.network

import com.juan.aplicacion_bbdd.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}
