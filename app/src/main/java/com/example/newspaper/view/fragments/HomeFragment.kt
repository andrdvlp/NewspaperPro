package com.example.newspaper.view.fragments

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaper.R
import com.example.newspaper.data.Article
import com.example.newspaper.databinding.FragmentHomeBinding
import com.example.newspaper.view.rv_adapters.NewsListRecyclerAdapter

class HomeFragment: Fragment() {

    private lateinit var newsAdapter: NewsListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyckler()
    }

    private fun initRecyckler() {
        //находим наш RV
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            newsAdapter = NewsListRecyclerAdapter(object : NewsListRecyclerAdapter.OnItemClickListener{

                override fun click(article: Article) {

                }
            })
            //Присваиваем адаптер
            adapter = newsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(10)
            addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        newsAdapter.addItems(newsDataBase)
    }


}
class TopSpacingItemDecoration (private val paddingInDp: Int): RecyclerView.ItemDecoration() {
    private val Int.convertPx: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = paddingInDp.convertPx
        outRect.right = paddingInDp.convertPx
        outRect.left = paddingInDp.convertPx

    }
}