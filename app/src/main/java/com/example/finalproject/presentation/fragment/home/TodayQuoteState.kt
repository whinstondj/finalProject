package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewState
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.domain.model.QuoteDomainModel

data class TodayQuoteState(
    val quote: List<ResponseQuoteDataModelItem> = listOf(),
    val quoteRandom: List<ResponseQuoteDataModelItem> = listOf(),
    val author: String = "",
    val quoteText: String = "",
    val savedQuote: QuoteDomainModel? = null
): BaseViewState()