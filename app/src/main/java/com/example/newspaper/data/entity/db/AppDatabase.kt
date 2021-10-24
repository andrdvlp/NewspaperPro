package com.example.newspaper.data.entity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.dao.NewsDao

@Database(entities = [Article::class, ArticleBookmark::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}