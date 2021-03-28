package com.example.finalproject.presentation.fragment.list

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListQuoteViewModel @Inject constructor(private val repository: QuoteRepository): BaseViewModel<ListQuoteState>() {
    override val defaultState: ListQuoteState = ListQuoteState()

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
