package com.example.finalproject.domain.repository

import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem

interface QuoteRepository {
    suspend fun getFiftyQuotes(): List<ResponseQuoteDataModelItem>
    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem>
    suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem>
}