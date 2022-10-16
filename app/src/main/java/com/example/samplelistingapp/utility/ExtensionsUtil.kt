package com.example.samplelistingapp.utility

import android.content.res.Configuration
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.samplelistingapp.R
import javax.annotation.Nonnull

object ExtensionsUtil {
    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun ImageView.loadImage(@Nonnull imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(this)
    }

    fun RecyclerView.gridManager() {
        val orientation = resources.configuration.orientation
        val mLayoutManager = GridLayoutManager(
            context, if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // In landscape
                7
            } else {
                // In portrait
                3
            }
        )
        layoutManager = mLayoutManager
        itemAnimator = DefaultItemAnimator()
    }
}
