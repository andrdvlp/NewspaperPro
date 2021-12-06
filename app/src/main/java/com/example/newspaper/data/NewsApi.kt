package com.example.newspaper.data

import com.example.newspaper.data.entity.NewsData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("v2/top-headlines?country=ru")
    fun getNews(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Observable<NewsData>
}