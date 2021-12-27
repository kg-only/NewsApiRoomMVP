package com.example.newsapi.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapi.R
import com.example.newsapi.common.mvp.BaseFragment
import com.example.newsapi.databinding.FragmentInfoBinding
import com.example.newsapi.main.model.ArticlesParcelable
import com.example.newsapi.responsemodel.Articles
import com.squareup.picasso.Picasso

private lateinit var binding: FragmentInfoBinding
private lateinit var dataResult: ArticlesParcelable

class InfoFragment : BaseFragment(R.layout.fragment_info) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        dataResult = requireArguments().getParcelable("photos")!!
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            Picasso.get().load(dataResult.urlToImage).resize(800, 400).centerCrop().into(infoImage)
            title.text = dataResult.title
            source.text = "Источник " + dataResult.source
            description.text = dataResult.description
            val test = dataResult.publishedAt!!.length
            author.text = "Дата " + dataResult.publishedAt!!.substring(0,test/2)  + "    Автор: " + dataResult.author
            url.text = dataResult.url
            Linkify.addLinks(url, Linkify.WEB_URLS)

        }

    }
}
