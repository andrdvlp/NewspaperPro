package com.example.newspaper.data

import com.example.newspaper.data.Entity.Article
import com.example.newspaper.data.Entity.ArticleBookmarks
import com.example.newspaper.data.Entity.dao.NewsDao
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

    fun putToBookmarks(articleBookmarks: List<ArticleBookmarks>) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertMarked(articleBookmarks)
        }
    }

    fun getAllFromBookmarks(): List<ArticleBookmarks> {
        return newsDao.getMarkedNews()
    }

}