package com.juan.aplicacion_bbdd.data.domain

import com.juan.aplicacion_bbdd.data.QuoteRepository
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import com.juan.aplicacion_bbdd.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository:QuoteRepository,
    private val quoteProvider: QuoteProvider
){

    //Ahora no necesita una corrutina porque lo tenemos almacenado en QuoteProvider
    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null  /*No hace falta incluir else*/
    }
}