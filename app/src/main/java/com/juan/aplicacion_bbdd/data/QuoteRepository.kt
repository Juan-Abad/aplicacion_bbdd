package com.juan.aplicacion_bbdd.data

import com.juan.aplicacion_bbdd.data.model.QuoteModel
import com.juan.aplicacion_bbdd.data.model.QuoteProvider
import com.juan.aplicacion_bbdd.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteProvider: QuoteProvider
){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}
