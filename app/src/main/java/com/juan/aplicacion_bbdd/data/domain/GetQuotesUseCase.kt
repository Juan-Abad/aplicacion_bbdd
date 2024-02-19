package com.juan.aplicacion_bbdd.data.domain

import com.juan.aplicacion_bbdd.data.QuoteRepository
import com.juan.aplicacion_bbdd.data.database.entities.toDatabase
import com.juan.aplicacion_bbdd.data.domain.model.Quote
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository){
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{ //Si falla la llamada a la API, se cargan las citas desde la base de datos
            repository.getAllQuotesFromDatabase()
        }
    }

}