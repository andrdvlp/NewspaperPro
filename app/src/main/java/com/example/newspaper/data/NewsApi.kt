package com.example.newspaper.data

import com.example.newspaper.data.entity.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    fun getNews(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsData>
}