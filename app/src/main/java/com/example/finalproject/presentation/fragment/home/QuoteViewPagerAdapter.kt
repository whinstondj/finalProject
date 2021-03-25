package com.example.finalproject.presentation.fragment.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject.presentation.fragment.quote.QuoteFragment

class QuoteViewPagerAdapter(fragment: Fragment, private val todayQuote: TodayQuoteState) :  FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> QuoteFragment(todayQuote.quote)
            1 -> QuoteFragment(todayQuote.quoteRandom)
            else -> Fragment()
        }
    }
}