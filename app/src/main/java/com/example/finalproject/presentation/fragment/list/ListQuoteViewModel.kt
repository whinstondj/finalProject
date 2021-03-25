package com.example.finalproject.presentation.fragment.list

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.data.QuoteRepository

class ListQuoteViewModel: BaseViewModel<ListQuoteState>() {
    override val defaultState: ListQuoteState = ListQuoteState()

    override fun onStartFirstTime() {
        requestInformation()
    }

    private fun requestInformation() {
        updateToLoadingState()

        checkDataState { state ->
            executeCoroutines({
                val response = QuoteRepository().getFiftyQuotes()
                updateToNormalState(state.copy(quoteList = response))
            }, {error ->
                updateToErrorState(error)
            })
        }
    }
}
