package com.example.newspaper.view.fragments

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.newspaper.R
import com.example.newspaper.data.entity.Article
import com.example.newspaper.data.entity.ArticleBookmark
import com.example.newspaper.databinding.FragmentDetailsBinding
import com.example.newspaper.util.AutoDisposable
import com.example.newspaper.util.toBookmarks
import com.example.newspaper.viewmodel.DetailsFragmentViewModel
import com.example.newspaper.viewmodel.HomeFragmentViewModel
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var article: Article
    private lateinit var articleBookmark: ArticleBookmark
//    private val autoDisposable = AutoDisposable()
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DetailsFragmentViewModel::class.java)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        autoDisposable.bindTo(lifecycle)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNewsDetails()

        binding.detailsFabMarked.setOnClickListener {
            viewModel.insertToBookmarks(article)
            if (!article.isMarked) {
                viewModel.insertToBookmarks(article)
                binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_24)
                article.isMarked = true
            } else {
                binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
                article.isMarked = false
                 viewModel.deleteBookmark(article.toBookmarks())
//                viewModel.removeB(article.id)
            }
        }

        val link = article.url
        binding.sourceFab.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        }

        binding.shareFab.setOnClickListener {
            //create intent
            val intent = Intent()
            //choose action to start
            intent.action = Intent.ACTION_SEND
            //put data to intent
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Look at this: ${article.title} \n\n ${article.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }

    }

    fun setNewsDetails() {
        article = arguments?.get("article") as Article

        binding.detailsToolbar.title = article.title

        Picasso.get()
            .load(article.urlToImage)
//            .centerCrop()
            .into(binding.appBarImage)

//        Glide.with(this)
//            .load(article.urlToImage)
//            .centerCrop()
//            .into(binding.appBarImage)
        binding.detailsDescription.text = article.description

        if (article.isMarked) {
            binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_24)
        } else {
            binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_border_24)

        }
//        binding.detailsFabMarked.setOnClickListener {
//            if (!article.isMarked) {
//                binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_24)
//                article.isMarked = true
//            } else {
//                binding.detailsFabMarked.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
//                article.isMarked = false
//            }
//        }
    }
}