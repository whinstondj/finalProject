package com.example.finalproject.domain.repository

import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.domain.model.QuoteDomainModel

interface QuoteRepository {
    suspend fun getFiftyQuotes(): List<ResponseQuoteDataModelItem>
    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem>
    suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem>
    suspend fun getAllSavedQuotes(): List<QuoteDomainModel>
    suspend fun insertNewQuote(quote: QuoteDomainModel)
    suspend fun deleteSavedQuote(quote: QuoteDomainModel)
}