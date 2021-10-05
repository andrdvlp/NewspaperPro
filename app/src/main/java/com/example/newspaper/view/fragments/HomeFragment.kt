package com.example.newspaper.view.fragments

import androidx.fragment.app.Fragment
import com.example.newspaper.R
import com.example.newspaper.data.Article
import com.example.newspaper.view.rv_adapters.NewsListRecyclerAdapter

class HomeFragment: Fragment() {

    private lateinit var newsAdapter: NewsListRecyclerAdapter

    val newsDataBase = listOf(
        Article("kjhkjh", "kjhkjhkjhk", R.drawable.img19_1920x1200),
        Article("kjhkjh", "kjhkjhkjhk", R.drawable.img19_1920x1200),
        Article("kjhkdsdfjh", "kjhkjsfhkjhk", R.drawable.img19_1920x1200),
        Article("kjhkdsdfjh", "kjhkjsfhkjhk", R.drawable.img19_1920x1200),
        Article("kjhksdfsdjh", "kjhkjhasdkjhk", R.drawable.img19_1920x1200),
        Article("kjhksdfsdjh", "kjhkjhasdkjhk", R.drawable.img19_1920x1200),
        Article("kjhkjh", "kjhkjhkjhksa", R.drawable.img19_1920x1200),
        Article("kjhkjh", "kjhkjhkjhksa", R.drawable.img19_1920x1200),
        Article("kjhfhkjh", "kjhkjhkjhk", R.drawable.img19_1920x1200),
        Article("kjhfhkjh", "kjhkjhkjhk", R.drawable.img19_1920x1200),
        Article("kjhkfghfjh", "kjhkjhfhfgkjhk", R.drawable.img19_1920x1200),
        Article("kjhkfghfjh", "kjhkjhfhfgkjhk", R.drawable.img19_1920x1200)
    )
}