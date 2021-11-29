package com.example.newspaper.di.modules

import android.content.Context
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.NewsApi
import com.example.newspaper.data.PreferenceProvider
import com.example.newspaper.interactor.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideInteractor(repository: MainRepository, newsApi: NewsApi) = Interactor(repo = repository, retrofitService = newsApi)

    @Provides
    @Singleton
    fun providePreferences(context: Context) = PreferenceProvider(context)
}