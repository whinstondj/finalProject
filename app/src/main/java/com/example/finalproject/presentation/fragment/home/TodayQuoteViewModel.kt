package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.data.QuoteRepository

class TodayQuoteViewModel: BaseViewModel<TodayQuoteState>() {
    override val defaultState: TodayQuoteState = TodayQuoteState()

    override fun onStartFirstTime() {

    }

    fun requestInformation() {
        updateToLoadingState()
            checkDataState { state ->
            executeCoroutines({
                updateToNormalState(state.copy(quote = QuoteRepository().getTodayQuote(), quoteRandom = QuoteRepository().getRandomQuote()))
            }, {error ->

                updateToErrorState(error)

            })
            }
    }
}
