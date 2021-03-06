package com.example.newspaper.di.modules

import android.content.Context
import androidx.room.Room
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.db_first.dao.NewsDao
import com.example.newspaper.data.db_first.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "news_db"
        ).build().newsDao()


    @Provides
    @Singleton
    fun provideRepository(newsDao: NewsDao) = MainRepository(newsDao)
}