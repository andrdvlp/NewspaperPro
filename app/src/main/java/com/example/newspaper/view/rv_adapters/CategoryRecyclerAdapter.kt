package com.example.newspaper.view.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.R
import com.example.newspaper.data.entity.Article
import com.example.newspaper.view.rv_viewholders.NewsViewHolder

class CategoryRecyclerAdapter(private val clickListener: NewsListRecyclerAdapter.OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return items.size
    }
}