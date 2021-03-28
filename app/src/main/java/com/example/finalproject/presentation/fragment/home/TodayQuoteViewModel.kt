package com.example.finalproject.presentation.fragment.home

import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseViewModel
import com.example.finalproject.domain.model.QuoteDomainModel
import com.example.finalproject.domain.repository.QuoteRepository
import com.example.finalproject.presentation.fragment.home.TodayQuoteFragment.Companion.CODE_ALL_RIGHT
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

    fun onActionSaveQuote(todayQuote: Boolean) {
        updateToLoadingState()

        checkDataState { state ->
            if (state.author != "Nulo") {

                executeCoroutines({
                        if (todayQuote) {
                            repository.insertNewQuote(
                                QuoteDomainModel(
                                    quote = state.quote[0].q,
                                    author = state.quote[0].a
                                )
                            )
                            updateToLoadingState(BaseExtraData(CODE_ALL_RIGHT))
                        }
                }, {

        })

            }
        }
    }

}
