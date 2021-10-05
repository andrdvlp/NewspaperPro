package com.example.newspaper.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.data.Article
import com.example.newspaper.databinding.NewsItemBinding
import kotlinx.android.synthetic.main.news_item.view.*

class NewsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){

    private val title = itemView.title
    private val description = itemView.description
    private val photo = itemView.photo

    fun bind(article: Article) {

        title.text = article.title
        description.text = article.description
        photo.setImageResource(article.poster)
    }
}