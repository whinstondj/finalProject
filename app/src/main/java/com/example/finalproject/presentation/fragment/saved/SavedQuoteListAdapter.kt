package com.example.finalproject.presentation.fragment.saved

import android.content.ComponentCallbacks
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.quote.model.ResponseQuoteDataModelItem
import com.example.finalproject.databinding.ItemFiftyQuoteBinding
import com.example.finalproject.databinding.ItemSavedQuoteBinding
import com.example.finalproject.domain.model.QuoteDomainModel


class SavedQuoteListAdapter(private var dataSet: List<QuoteDomainModel>, private val callbacks: MyClickListener) : RecyclerView.Adapter<SavedQuoteListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSavedQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSavedQuoteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]

        viewHolder.binding.apply {
            itemAuthorTextTitle.text = (position+1).toString() + " " + item.quote
            itemQuoteText.text = item.author

            itemQuoteButtonDelete.setOnClickListener {
                callbacks.onDeleteButtonClicked(item)
            }
        }

    }

    override fun getItemCount() = dataSet.size

    fun updateList(newList: List<QuoteDomainModel>){
        dataSet = newList
        notifyDataSetChanged()
    }

    interface MyClickListener {
        fun onDeleteButtonClicked(item: QuoteDomainModel)
    }


}