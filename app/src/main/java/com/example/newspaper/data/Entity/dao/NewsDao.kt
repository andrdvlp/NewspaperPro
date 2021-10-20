package com.example.newspaper.data.Entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.data.Entity.ArticleBookmarks

@Dao
interface NewsDao {
    @Query("SELECT*FROM cashed_news")
    fun getCashedNews(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Article>)

    @Query("SELECT*FROM cashed_news")
    fun getMarkedNews(): List<ArticleBookmarks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMarked(list: List<ArticleBookmarks>)
}