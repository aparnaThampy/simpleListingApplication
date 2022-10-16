package com.example.samplelistingapp.feature.Listing.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplelistingapp.R
import com.example.samplelistingapp.data.Content
import com.example.samplelistingapp.databinding.ItemCardLytBinding
import com.example.samplelistingapp.feature.Listing.viewHolder.CardItemViewHolder


class CourseGVAdapter(var courseModelArrayList: List<Content> = listOf()) :
    RecyclerView.Adapter<CardItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val binding: ItemCardLytBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_card_lyt, parent, false
        )
        return CardItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        val dataModel = courseModelArrayList.get(position)
        holder.bind(dataModel)
    }

    override fun getItemCount(): Int {
        return courseModelArrayList.size
    }

    fun updateList(updatedList: List<Content>) {
        if(courseModelArrayList != updatedList) {
            courseModelArrayList = updatedList
            notifyDataSetChanged()
        }
    }
}
