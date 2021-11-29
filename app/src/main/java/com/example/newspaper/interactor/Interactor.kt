package com.example.newspaper.interactor

import android.content.SharedPreferences
import com.example.newspaper.data.ApiConstants
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.NewsData
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.NewsApi
import com.example.newspaper.data.PreferenceProvider
import com.example.newspaper.viewmodel.HomeFragmentViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: NewsApi, private val preferences: PreferenceProvider) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getNewsFromApi() {
        retrofitService.getNews(getDefaultCategoryFromPreferences(), ApiConstants.KEY).enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                val list = response.body()?.articles

                Completable.fromSingle<List<Article>> {
                    if (list != null) {
                        repo.putToDb(list)
                    }
                }
                    .subscribeOn(Schedulers.io())
                    .subscribe()
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                println("VVV onFailure")
                //В случае провала вызываем другой метод коллбека
            }
        })
    }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun insertToBookmarks(articleBookmark: ArticleBookmark) {
        repo.putToBookmarks(articleBookmark)
    }

    fun getNewsFromDB(): Observable<List<Article>> = repo.getAllFromDB()
    fun deleteNewsFromBookmarks(articleBookmark: ArticleBookmark) = repo.deleteBookmark(articleBookmark.title)
    fun getNewsFromBookmarks(): Observable<List<ArticleBookmark>> = repo.getAllFromBookmarks()
}