package com.example.newspaper.data.Entity

data class NewsData(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)