package com.example.newspaper.data

import com.example.newspaper.data.Entity.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything?q=Apple&from=2021-10-13&sortBy=popularity&apiKey=c17983dc3961448588a71f963734ff32")
    @Query("")
    fun getNews(): Call<NewsData>
}