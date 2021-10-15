package com.example.newspaper.data

import com.example.newspaper.data.Entity.Article
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


//    val source = Source("2", "New York Times")
//    val newsDataBase = listOf(
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//        Article("19:22", source,"This should be a description, This should be a description, This should be a description",
//            "https://peakon.com/wp-content/uploads/2018/08/twiglet-1120x720.jpg"),
//    )
}