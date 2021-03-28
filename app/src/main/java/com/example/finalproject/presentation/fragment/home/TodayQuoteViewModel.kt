package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TodayQuoteViewModel @Inject constructor(private val repository: QuoteRepository): BaseViewModel<TodayQuoteState>(){

    override val defaultState: TodayQuoteState = TodayQuoteState()

    override fun onStartFirstTime() {
        requestInformation()
    }

    private fun requestInformation() {
        updateToLoadingState()
            checkDataState { state ->
            executeCoroutines({
                updateToNormalState(state.copy(quote = repository.getTodayQuote(), quoteRandom = repository.getRandomQuote()))
            }, {error ->

                updateToErrorState(error)

            })
            }
    }
}
