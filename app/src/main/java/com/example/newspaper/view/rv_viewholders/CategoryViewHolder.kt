package com.example.newspaper.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.databinding.CategoryItemBinding
import com.example.newspaper.databinding.NewsItemBinding

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var categoryItemBinding = CategoryItemBinding.bind(itemView)
    var category = categoryItemBinding.categoryText

    fun bind(string: String) {
        category.text = string
    }
}