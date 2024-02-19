package com.juan.aplicacion_bbdd.data.domain

import com.juan.aplicacion_bbdd.data.QuoteRepository
import com.juan.aplicacion_bbdd.data.domain.model.Quote
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import com.juan.aplicacion_bbdd.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    //Ahora no necesita una corrutina porque lo tenemos almacenado en QuoteProvider
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}