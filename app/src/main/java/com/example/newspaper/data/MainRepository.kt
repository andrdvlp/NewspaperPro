package com.example.newspaper.data

import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.dao.NewsDao
import java.util.concurrent.Executors

class MainRepository(private val newsDao: NewsDao) {

    fun putToDb(article: List<Article>) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertAll(article)
        }
    }

    fun getAllFromDB(): List<Article> {
        return newsDao.getCashedNews()
    }

    fun putToBookmarks(articleBookmark: ArticleBookmark) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertMarked(articleBookmark)
        }
    }

    fun getAllFromBookmarks(): List<ArticleBookmark> = newsDao.getMarkedNews()

    fun deleteBookmark(articleBookmark: ArticleBookmark) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.deleteBookmark(articleBookmark)
        }
    }

}