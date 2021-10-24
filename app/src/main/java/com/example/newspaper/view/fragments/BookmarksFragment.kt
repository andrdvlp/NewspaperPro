package com.example.newspaper.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newspaper.data.entity.Article
import com.example.newspaper.databinding.FragmentBookmarksBinding
import com.example.newspaper.view.MainActivity
import com.example.newspaper.view.rv_adapters.NewsListRecyclerAdapter
import com.example.newspaper.view.rv_adapters.TopSpacingItemDecoration

class BookmarksFragment : Fragment() {

    private lateinit var binding: FragmentBookmarksBinding
    private lateinit var newsAdapter: NewsListRecyclerAdapter

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

        val markedList: List<Article> = emptyList()

        binding.bookmarksRecycler.apply {
            newsAdapter = NewsListRecyclerAdapter(object : NewsListRecyclerAdapter.OnItemClickListener {
                override fun click(article: Article) {
                    (requireActivity() as MainActivity).launchDetailsFragment(article)
                }
            })

            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        newsAdapter.addItems(markedList)
    }
}