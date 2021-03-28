package com.example.finalproject.presentation.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentQuoteBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TodayQuoteFragment : BaseFragment<TodayQuoteState, TodayQuoteViewModel, FragmentQuoteBinding>() {

    override val viewModelClass: Class<TodayQuoteViewModel> = TodayQuoteViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentQuoteBinding = FragmentQuoteBinding::inflate

    lateinit var myViewModel: TodayQuoteViewModel

    companion object {
        const val CODE_ALL_RIGHT = 1000
    }


    override fun setupView(viewModel: TodayQuoteViewModel) {
        myViewModel = viewModel

        setupButton()
    }

    private fun setupButton() {
        binding.seeMoreButton.setOnClickListener {
            findNavController().navigate(TodayQuoteFragmentDirections.actionTodayQuoteFragmentToHomeUserFragment())
        }
        binding.saveQuoteButton.setOnClickListener {
            myViewModel.onActionSaveQuote()
        }
        binding.seeSavedButton.setOnClickListener {
            findNavController().navigate(TodayQuoteFragmentDirections.actionTodayQuoteFragmentToSavedQuoteFragment())
        }
    }

    override fun onNormal(data: TodayQuoteState) {
        binding.quoteFragmentViewPager.adapter = QuoteViewPagerAdapter(this, data)
        TabLayoutMediator(binding.quoteFragmentTabLayout, binding.quoteFragmentViewPager) { tab, position ->
            tab.text = when(position){
                0 -> "Quote of the Day"
                1 -> "Random Quote"
                else -> ""
            }
        }.attach()

    }

    override fun onLoading(dataLoading: BaseExtraData?) {
        dataLoading?.let {
            when (it.type) {
                CODE_ALL_RIGHT ->
                    Toast.makeText(context, "Cita del dia almacenada", Toast.LENGTH_LONG).show()
                else -> {
                }
            }
        }
    }

    override fun onError(dataError: Throwable) {

    }
}