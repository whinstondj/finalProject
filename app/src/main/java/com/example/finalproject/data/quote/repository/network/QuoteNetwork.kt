package com.example.finalproject.data.quote.repository.network


import com.example.finalproject.data.quote.model.ResponseQuoteDataModel
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import javax.inject.Inject


class QuoteNetwork @Inject constructor(private val service: QuoteService) {

    suspend fun getFiftyQuotes(): ResponseQuoteDataModel {
        return service.getFiftyQuotes()
    }

    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem> {
        return service.getTodayQuote()
    }

    suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem> {
        return service.getRandomQuote()
    }
}