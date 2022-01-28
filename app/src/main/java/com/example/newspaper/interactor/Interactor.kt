package com.example.newspaper.interactor

import com.example.newspaper.data.ApiConstants
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.NewsApi
import com.example.newspaper.data.PreferenceProvider
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers


class Interactor(private val repo: MainRepository, private val retrofitService: NewsApi, private val preferences: PreferenceProvider) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getNewsFromApi() {
        retrofitService.getNews(getDefaultLangFromPreferences(), getCategory(), ApiConstants.KEY)
            .subscribeOn(Schedulers.io())
            .map {
                it.articles
            }
            .subscribeBy(
                onError = {

                },
                onNext = {
                    repo.putToDb(it)
                }
            )
    }

    //Метод для сохранения настроек
    fun saveDefaultLangToPreferences(language: String) {
        preferences.saveDefaultLang(language)
    }
    //Метод для получения настроек
    fun getDefaultLangFromPreferences() = preferences.getDefaultLang()

    fun insertToBookmarks(articleBookmark: ArticleBookmark) {
        repo.putToBookmarks(articleBookmark)
    }

    fun deleteAll() = repo.deleteAll()

    fun getNewsFromDB(): Observable<List<Article>> = repo.getAllFromDB()

    fun deleteNewsFromBookmarks(articleBookmark: ArticleBookmark) = repo.deleteBookmark(articleBookmark.title)

    fun getNewsFromBookmarks(): Observable<List<ArticleBookmark>> = repo.getAllFromBookmarks()

    fun setCategory(category: String) {
        preferences.setCategory(category)
    }

    fun getCategory() = preferences.getCategory()
}