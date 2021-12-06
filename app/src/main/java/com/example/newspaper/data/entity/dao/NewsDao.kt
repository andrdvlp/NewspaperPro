package com.example.newspaper.data.entity.dao

import androidx.room.*
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import io.reactivex.rxjava3.core.Observable

@Dao
interface NewsDao {
    //Запрос на всю таблицу
    @Query("SELECT*FROM cashed_news")
    fun getCashedNews(): Observable<List<Article>>
    //Заполняем нашу БД
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Article>)

    //Bookmarks
    @Query("SELECT*FROM marked_news")
    fun getMarkedNews(): Observable<List<ArticleBookmark>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMarked(articleBookmark: ArticleBookmark)

    @Query("DELETE FROM marked_news WHERE title = :title")
    fun deleteFromB(title: String)
}