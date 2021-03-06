package com.example.finalproject.presentation.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentFiftyQuotesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListQuoteFragment : BaseFragment<ListQuoteState, ListQuoteViewModel, FragmentFiftyQuotesBinding>() {

    override val viewModelClass: Class<ListQuoteViewModel> = ListQuoteViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFiftyQuotesBinding = FragmentFiftyQuotesBinding::inflate

    lateinit var vm: ListQuoteViewModel

    lateinit var mAdapter: QuoteListAdapter

    override fun setupView(viewModel: ListQuoteViewModel) {

        vm = viewModel

        mAdapter = QuoteListAdapter(listOf(), requireActivity())

        binding.fragmentQuoteListRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            itemAnimator = DefaultItemAnimator()
        }

    }

    override fun onNormal(data: ListQuoteState) {
        binding.fiftyQuoteFragmentProgressBar.visibility = View.GONE
        mAdapter.updateList(data.quoteList)
    }

    override fun onLoading(dataLoading: BaseExtraData?) {
        binding.fiftyQuoteFragmentProgressBar.visibility = View.VISIBLE
    }

    override fun onError(dataError: Throwable) {

    }
}