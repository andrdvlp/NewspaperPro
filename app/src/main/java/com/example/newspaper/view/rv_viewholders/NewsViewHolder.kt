package com.example.newspaper.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.data.Article
import com.example.newspaper.databinding.NewsItemBinding

class NewsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){

    private val newsItemBinding = NewsItemBinding.bind(itemView)

    private val title = newsItemBinding.title
    private val description = newsItemBinding.description
    private val photo = newsItemBinding.photo

    fun bind(article: Article) {

        title.text = article.title
        description.text = article.description
        photo.setImageResource(article.poster)
    }
}