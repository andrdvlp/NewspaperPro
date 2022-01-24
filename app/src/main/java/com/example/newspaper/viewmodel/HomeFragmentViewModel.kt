package com.example.newspaper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newspaper.App
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.interactor.Interactor
import com.example.newspaper.util.toBookmarks
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Executors
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {

    val newsListData: Observable<List<Article>>

    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        newsListData = interactor.getNewsFromDB()
        getNews()
    }

    fun getNews() {
        interactor.getNewsFromApi()
    }

    interface ApiCallback {
        fun onSuccess(article: List<Article>)
        fun onFailure()
    }

    fun setCategoryProperty(category: String) {
        //Сохраняем в настройки
        interactor.setCategory(category)
    }
}