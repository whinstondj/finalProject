package com.example.finalproject.presentation.fragment.saved

import com.example.finalproject.base.BaseViewState
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.domain.model.QuoteDomainModel

data class SavedQuoteState(
    val quoteList: List<QuoteDomainModel> = listOf()
): BaseViewState()