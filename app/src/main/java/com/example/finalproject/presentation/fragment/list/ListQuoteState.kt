package com.example.finalproject.presentation.fragment.list

import com.example.finalproject.base.BaseViewState
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem

data class ListQuoteState(
    val quoteList: List<ResponseQuoteDataModelItem> = listOf()
): BaseViewState()