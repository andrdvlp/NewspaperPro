package com.example.newspaper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newspaper.App
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.interactor.Interactor
import com.example.newspaper.util.toBookmarks
import java.util.concurrent.Executors
import javax.inject.Inject


class BookmarksFragmentViewModel : ViewModel() {
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
    }

    fun insertToBookmarks (article: Article) {
        interactor.insertToBookmarks(article.toBookmarks())
    }

    interface ApiCallback {
        fun onSuccess(article: List<Article>)
        fun onFailure()
    }
}