package com.example.finalproject.data.quote.repository.network

import com.example.finalproject.data.quote.model.ResponseQuoteDataModel
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import retrofit2.http.GET

interface QuoteService {

    @GET("api/quotes")
    suspend fun getFiftyQuotes(): ResponseQuoteDataModel

    @GET("api/random")
    suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem>

    @GET("api/today")
    suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem>

}