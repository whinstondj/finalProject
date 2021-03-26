package com.example.finalproject.presentation.fragment.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.databinding.ItemFiftyQuoteBinding


class QuoteListAdapter(private var dataSet: List<ResponseQuoteDataModelItem>, private val context: Context) : RecyclerView.Adapter<QuoteListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemFiftyQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFiftyQuoteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]

        viewHolder.binding.apply {
            itemAuthorTextTitle.text = (position+1).toString() + " " + item.a

            itemQuoteText.text = item.q
        }

    }

    override fun getItemCount() = dataSet.size

    fun updateList(newList: List<ResponseQuoteDataModelItem>){
        dataSet = newList
        notifyDataSetChanged()
    }
}