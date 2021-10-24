package com.example.newspaper.util

import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.Source

fun Article.toBookmarks() = ArticleBookmark(
    title = title,
    publishedAt = publishedAt,
    source = source,
    urlToImage = urlToImage,
    description = description
)

fun ArticleBookmark.toArticle() = Article(
    title = title,
    publishedAt = publishedAt,
    source = source,
    urlToImage = urlToImage,
    description = description,
    isMarked = true
)