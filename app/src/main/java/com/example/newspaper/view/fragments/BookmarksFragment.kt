package com.example.newspaper.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newspaper.data.entity.Article
import com.example.newspaper.databinding.FragmentBookmarksBinding
import com.example.newspaper.util.toArticle
import com.example.newspaper.view.MainActivity
import com.example.newspaper.view.rv_adapters.NewsListRecyclerAdapter
import com.example.newspaper.view.rv_adapters.TopSpacingItemDecoration
import com.example.newspaper.viewmodel.BookmarksFragmentViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class BookmarksFragment : Fragment() {

    private lateinit var binding: FragmentBookmarksBinding
    private lateinit var newsAdapter: NewsListRecyclerAdapter

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(BookmarksFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyckler()

        viewModel.newsListData
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list ->
                newsAdapter.addItems(list.map { it.toArticle() })
            }
    }
//        viewModel.newsListLiveData.observe(viewLifecycleOwner, Observer<List<ArticleBookmark>> { list ->
////            val articleList = mutableListOf<Article>()
////            it.forEach { item ->
////                articleList.add(item.toArticle())
////            }
////            вызываем map  на каждом элементе спика ArticleBookmark, возвращает новый список состоящий из article
//            newsAdapter.addItems(list.map { it.toArticle()})
//        })
//    }

    // залггитровать то происходит с фрагмиентом
    // понять что с колюэками
    // дифф утилщз
    // научить фрагмент обновлять данные в ресайклер вью

    override fun onResume() {
        super.onResume()
       if(this::newsAdapter.isInitialized) newsAdapter.notifyDataSetChanged()
    }

    fun initRecyckler() {
        //находим наш RV
        binding.bookmarksRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            newsAdapter = NewsListRecyclerAdapter(object : NewsListRecyclerAdapter.OnItemClickListener{

                override fun click(article: Article) {
                    (requireActivity() as MainActivity).launchDetailsFragment(article)
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
    }
}