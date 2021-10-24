package com.example.newspaper.interactor

import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.data.entity.NewsData
import com.example.newspaper.data.MainRepository
import com.example.newspaper.data.NewsApi
import com.example.newspaper.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: NewsApi) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getNewsFromApi(callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getNews().enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                val list = response.body()?.articles
                list?.forEach {
                    repo.putToDb(list)
                }
                if (list != null) {
                    callback.onSuccess(list)
                }
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                println("VVV onFailure")
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }

    fun insertToBookmarks(articleBookmark: ArticleBookmark) {
        repo.putToBookmarks(articleBookmark)
    }

    fun getNewsFromDB(): List<Article> = repo.getAllFromDB()

    fun getNewsFromBookmarks(): List<ArticleBookmark> = repo.getAllFromBookmarks()
}