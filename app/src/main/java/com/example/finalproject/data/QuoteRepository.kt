package com.example.finalproject.data

import com.example.finalproject.data.config.network.QuoteNetwork
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem

class QuoteRepository {
    suspend fun getFiftyQuotes(): List<ResponseQuoteDataModelItem> {
        return QuoteNetwork().getFiftyQuotes()
    }

    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem> {
        return QuoteNetwork().getTodayQuote()
    }

}