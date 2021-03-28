package com.example.finalproject.data.quote.repository

import com.example.finalproject.data.quote.model.QuoteEntityDataModel
import com.example.finalproject.data.quote.repository.network.QuoteNetwork
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.data.quote.model.toDataModel
import com.example.finalproject.data.quote.model.toDomainModel
import com.example.finalproject.data.quote.repository.local.QuoteLocal
import com.example.finalproject.domain.model.QuoteDomainModel
import com.example.finalproject.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(private val network: QuoteNetwork, private val local: QuoteLocal): QuoteRepository {

    override suspend fun getFiftyQuotes(): List<ResponseQuoteDataModelItem> {
        return network.getFiftyQuotes()
    }

    override suspend fun getTodayQuote(): List<ResponseQuoteDataModelItem> {
        return network.getTodayQuote()
    }
    override suspend fun getRandomQuote(): List<ResponseQuoteDataModelItem> {
        return network.getRandomQuote()
    }

    override suspend fun getAllSavedQuotes(): List<QuoteDomainModel> {
        return local.getAllSavedQuotes().map { it.toDomainModel() }
    }

    override suspend fun insertNewQuote(quote: QuoteDomainModel) {
        local.insertNewQuote(quote.toDataModel())
    }

    override suspend fun deleteSavedQuote(quote: QuoteDomainModel) {
        local.deleteSavedQuote(quote.toDataModel())
    }

}