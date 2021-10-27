package com.example.newspaper.data.entity.dao

import androidx.room.*
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark

@Dao
interface NewsDao {
    //Cashed
    @Query("SELECT*FROM cashed_news")
    fun getCashedNews(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Article>)

    //Bookmarks
    @Query("SELECT*FROM marked_news")
    fun getMarkedNews(): List<ArticleBookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMarked(articleBookmark: ArticleBookmark)

    @Delete
    fun deleteBookmark(articleBookmark: ArticleBookmark)

    @Query("DELETE FROM marked_news WHERE id = :id")
    fun deleteFromB(id: Int)
}