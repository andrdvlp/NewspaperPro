package com.example.newspaper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newspaper.App
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.interactor.Interactor
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Executors
import javax.inject.Inject

class BookmarksFragmentViewModel : ViewModel() {

    val newsListData: Observable<List<ArticleBookmark>>
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        getNews()
        newsListData = interactor.getNewsFromBookmarks()
    }

    private fun getNews() {
       interactor.getNewsFromBookmarks()
    }
}