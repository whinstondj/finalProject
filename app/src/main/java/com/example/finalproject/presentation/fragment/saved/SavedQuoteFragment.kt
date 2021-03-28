package com.example.finalproject.presentation.fragment.saved

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentFiftyQuotesBinding
import com.example.finalproject.databinding.FragmentSavedQuotesBinding
import com.example.finalproject.domain.model.QuoteDomainModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SavedQuoteFragment : BaseFragment<SavedQuoteState, SavedQuoteViewModel, FragmentSavedQuotesBinding>() {

    override val viewModelClass: Class<SavedQuoteViewModel> = SavedQuoteViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSavedQuotesBinding = FragmentSavedQuotesBinding::inflate

    lateinit var vm: SavedQuoteViewModel

    lateinit var mAdapter: SavedQuoteListAdapter

    override fun setupView(viewModel: SavedQuoteViewModel) {

        vm = viewModel

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = SavedQuoteListAdapter(listOf(), object : SavedQuoteListAdapter.MyClickListener{
            override fun onDeleteButtonClicked(item: QuoteDomainModel) {
                vm.onActionDeleteNote(item)
            }
        })
        binding.fragmentQuoteListRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = mAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onNormal(data: SavedQuoteState) {
        mAdapter.updateList(data.quoteList)
    }

    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}