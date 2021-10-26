package com.example.newspaper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newspaper.App
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.interactor.Interactor
import java.util.concurrent.Executors
import javax.inject.Inject

class BookmarksFragmentViewModel : ViewModel() {

    val newsListLiveData = MutableLiveData<List<ArticleBookmark>>()
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        getNews()
    }

    private fun getNews() {
        Executors.newSingleThreadExecutor().execute {
            newsListLiveData.postValue(interactor.getNewsFromBookmarks())
        }
    }
}