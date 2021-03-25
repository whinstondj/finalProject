package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewState
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem

data class TodayQuoteState(
    val quote: List<ResponseQuoteDataModelItem> = listOf(),
    val quoteRandom: List<ResponseQuoteDataModelItem> = listOf()
): BaseViewState()