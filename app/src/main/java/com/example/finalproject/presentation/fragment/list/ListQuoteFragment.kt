package com.example.finalproject.presentation.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentHomeUserBinding

class ListQuoteFragment : BaseFragment<ListQuoteState, ListQuoteViewModel, FragmentHomeUserBinding>() {

    override val viewModelClass: Class<ListQuoteViewModel> = ListQuoteViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeUserBinding = FragmentHomeUserBinding::inflate

    override fun setupView(viewModel: ListQuoteViewModel) {

    }

    override fun onNormal(data: ListQuoteState) {
        binding.textExample.text = data.quoteList.toString()
    }

    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}