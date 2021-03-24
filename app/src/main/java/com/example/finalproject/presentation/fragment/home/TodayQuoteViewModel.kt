package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.data.QuoteRepository

class TodayQuoteViewModel: BaseViewModel<TodayQuoteState>() {
    override val defaultState: TodayQuoteState = TodayQuoteState()

    override fun onStartFirstTime() {
        requestInformation()
    }

    private fun requestInformation() {
        updateToLoadingState()
            checkDataState { state ->
            executeCoroutines({

                val response = QuoteRepository().getTodayQuote()
                updateToNormalState(state.copy(quote = response))

            }, {error ->

                updateToErrorState(error)

            })
            }
    }
}
