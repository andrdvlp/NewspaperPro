package com.example.newspaper.data.Entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.data.Entity.ArticleBookmarks

@Dao
interface NewsDao {
    //Cashed
    @Query("SELECT*FROM cashed_news")
    fun getCashedNews(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Article>)

    //Bookmarks
    @Query("SELECT*FROM marked_news")
    fun getMarkedNews(): List<ArticleBookmarks>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMarked(articleBookmarks: ArticleBookmarks)

    @Query("DELETE FROM marked_news WHERE id = :id")
    fun deleteFavoriteFilm(id: Int)
}