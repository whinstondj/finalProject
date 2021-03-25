package com.example.finalproject.presentation.fragment.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.databinding.FragmentTodayQuoteBinding

class QuoteFragment(private val quote: List<ResponseQuoteDataModelItem>) : Fragment() {

    lateinit var binding: FragmentTodayQuoteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentTodayQuoteBinding.inflate(inflater, container, false)

        binding.authorTextTitle.text = quote.firstOrNull()?.a ?: "Nulo"
        binding.quoteText.text = quote.firstOrNull()?.q ?: "Nulo"

        return binding.root
    }

}