package com.example.finalproject.presentation.fragment.saved

import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.model.QuoteDomainModel
import com.example.finalproject.domain.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SavedQuoteViewModel @Inject constructor(private val repository: QuoteRepository): BaseViewModel<SavedQuoteState>() {
    override val defaultState: SavedQuoteState = SavedQuoteState()

    override fun onStartFirstTime() {
    }

    override fun onResume() {
        executeCoroutines({
            val quotes = repository.getAllSavedQuotes()

            checkDataState { state ->
                updateToNormalState(state.copy(quoteList = quotes))
            }
        }, {

        })
    }

    fun onActionDeleteNote(item: QuoteDomainModel) {
        executeCoroutines({
            repository.deleteSavedQuote(item)
            val quotes = repository.getAllSavedQuotes()

            checkDataState { state ->
                updateToNormalState(state.copy(quoteList = quotes))
            }
        }, {

        })
    }
}
