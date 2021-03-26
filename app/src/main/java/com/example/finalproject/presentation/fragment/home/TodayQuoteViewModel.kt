package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.repository.QuoteRepository
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class TodayQuoteViewModel: BaseViewModel<TodayQuoteState>(), KoinComponent {

    private val repository by inject<QuoteRepository>()

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
