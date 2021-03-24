package com.example.finalproject.presentation.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentTodayQuoteBinding

class TodayQuoteFragment : BaseFragment<TodayQuoteState, TodayQuoteViewModel, FragmentTodayQuoteBinding>() {

    override val viewModelClass: Class<TodayQuoteViewModel> = TodayQuoteViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTodayQuoteBinding = FragmentTodayQuoteBinding::inflate

    lateinit var myViewModel: TodayQuoteViewModel

    override fun setupView(viewModel: TodayQuoteViewModel) {

    }

    override fun onNormal(data: TodayQuoteState) {
        binding.todayQuote.text = data.quote.firstOrNull()?.a ?: "Autor Desconocido"
    }

    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}