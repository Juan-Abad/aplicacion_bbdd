package com.juan.aplicacion_bbdd.data

import com.juan.aplicacion_bbdd.data.database.entities.QuoteEntity
import com.juan.aplicacion_bbdd.data.domain.model.Quote
import com.juan.aplicacion_bbdd.data.domain.model.toDomain
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import com.juan.aplicacion_bbdd.data.model.QuoteProvider
import com.juan.aplicacion_bbdd.data.network.QuoteDao
import com.juan.aplicacion_bbdd.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao
){

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}
