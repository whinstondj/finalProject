package com.example.finalproject.data.quote.repository.local

import com.example.finalproject.data.quote.model.QuoteEntityDataModel
import javax.inject.Inject

class QuoteLocal @Inject constructor(private val dao: QuoteDAO) {

    suspend fun getAllSavedQuotes(): List<QuoteEntityDataModel> {
        return dao.getAllSavedQuotes()
    }

    suspend fun insertNewQuote(quote: QuoteEntityDataModel) {
        dao.insertNewQuote(quote)
    }

    suspend fun deleteSavedQuote(quote: QuoteEntityDataModel) {
        dao.deleteSavedQuote(quote)
    }
}