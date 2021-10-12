package com.example.newspaper.data

import com.example.newspaper.data.Entity.Article

data class NewsData(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)