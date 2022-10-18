package com.example.samplelistingapp.feature.listing.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.samplelistingapp.data.Content
import com.example.samplelistingapp.databinding.ItemCardLytBinding

class CardItemViewHolder(private val itemBind: ItemCardLytBinding) :
    RecyclerView.ViewHolder(itemBind.root) {
    fun bind(dataModel: Content) {
        itemBind.apply {
            itemModel = dataModel
            executePendingBindings()
        }
    }
}