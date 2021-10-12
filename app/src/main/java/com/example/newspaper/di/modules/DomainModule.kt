package com.example.newspaper.di.modules

import android.content.Context
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.NewsApi
import com.example.newspaper.interactor.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideInteractor(repository: MainRepository, newsApi: NewsApi) = Interactor(repo = repository, retrofitService = newsApi)
}