package com.example.newspaper.data

import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.dao.NewsDao
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Executors

class MainRepository(private val newsDao: NewsDao) {

    fun putToDb(article: List<Article>) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertAll(article)
        }
    }

    fun getAllFromDB(): Observable<List<Article>> {
        return newsDao.getCashedNews()
    }

    fun deleteAll() = newsDao.deleteAll()

    fun putToBookmarks(articleBookmark: ArticleBookmark) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertMarked(articleBookmark)
        }
    }

    fun getAllFromBookmarks(): Observable<List<ArticleBookmark>> = newsDao.getMarkedNews()

    fun deleteBookmark(title: String) {
        Executors.newSingleThreadExecutor().execute {
            newsDao.deleteFromB(title)
        }
    }
}