package com.juan.aplicacion_bbdd.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.aplicacion_bbdd.data.database.entities.QuoteEntity
import com.juan.aplicacion_bbdd.data.domain.GetQuotesUseCase
import com.juan.aplicacion_bbdd.data.domain.GetRandomQuoteUseCase
import com.juan.aplicacion_bbdd.data.domain.model.Quote
import com.juan.aplicacion_bbdd.data.model.QuoteModel
import com.juan.aplicacion_bbdd.data.model.QuoteProvider
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<Quote?>()
    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

}