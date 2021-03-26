package com.example.finalproject.presentation.fragment.list

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.repository.QuoteRepository
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class ListQuoteViewModel: BaseViewModel<ListQuoteState>(), KoinComponent {
    override val defaultState: ListQuoteState = ListQuoteState()

    private val repository by inject<QuoteRepository>()

    override fun onStartFirstTime() {
        requestInformation()
    }

    private fun requestInformation() {
        updateToLoadingState()

        checkDataState { state ->
            executeCoroutines({
                val response = repository.getFiftyQuotes()
                updateToNormalState(state.copy(quoteList = response))
            }, {error ->
                updateToErrorState(error)
            })
        }
    }
}
