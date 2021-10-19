package com.example.newspaper.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newspaper.R
import com.example.newspaper.data.ApiConstants
import com.example.newspaper.data.Entity.Article
import com.example.newspaper.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var article: Article

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

        }

        binding.detailsFab.setOnClickListener {
        }

    }

    fun setNewsDetails() {
        article = arguments?.get("article") as Article

        binding.detailsToolbar.title = article.title
        Glide.with(this)
            .load(article.urlToImage)
            .centerCrop()
            .into(binding.appBarImage)
        binding.detailsDescription.text = article.description

        binding.detailsFabMarked.setImageResource(
            if (article.isInMarked) R.drawable.ic_baseline_bookmarks_24
            else R.drawable.ic_baseline_bookmarks_24
        )
    }
}