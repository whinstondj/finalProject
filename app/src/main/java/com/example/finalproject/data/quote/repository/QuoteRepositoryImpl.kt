package com.example.finalproject.data.quote.repository

import com.example.finalproject.data.quote.repository.network.QuoteNetwork
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.domain.repository.QuoteRepository

class QuoteRepositoryImpl(private val network: QuoteNetwork): QuoteRepository {

    override suspend fun getFiftyQuotes(): List<ResponseQuoteDataModelItem> {
        return network.getFiftyQuotes()
    }

    override suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem> {
        return network.getTodayQuote()
    }
    override suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem> {
        return network.getRandomQuote()
    }
}