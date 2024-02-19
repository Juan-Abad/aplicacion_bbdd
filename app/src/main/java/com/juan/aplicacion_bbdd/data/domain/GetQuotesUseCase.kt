package com.juan.aplicacion_bbdd.data.domain

import com.juan.aplicacion_bbdd.data.QuoteRepository
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository){
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}