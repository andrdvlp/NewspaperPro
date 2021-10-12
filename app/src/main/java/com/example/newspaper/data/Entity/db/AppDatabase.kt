package com.example.newspaper.data.Entity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.data.Entity.dao.NewsDao

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}