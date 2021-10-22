package com.example.newspaper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newspaper.App
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.data.Entity.ArticleBookmarks
import com.example.newspaper.interactor.Interactor
import java.util.concurrent.Executors
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {

    val newsListLiveData = MutableLiveData<List<Article>>()
    var bookmarksListData = MutableLiveData<List<ArticleBookmarks>>()
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        getNews()
        bookmarksListData.postValue(interactor.getNewsFromBookmarks())
    }

    fun getNews() {
        interactor.getNewsFromApi(object : ApiCallback {
            override fun onSuccess(article: List<Article>) {
                newsListLiveData.postValue(article)
            }

            override fun onFailure() {
                Executors.newSingleThreadExecutor().execute {
                    newsListLiveData.postValue(interactor.getNewsFromDB())
                }
            }
        })
    }

    fun insertToBookmarks (article: Article) {
        Interactor.insertToBookmarks(article)
    }

    interface ApiCallback {
        fun onSuccess(article: List<Article>)
        fun onFailure()
    }
}