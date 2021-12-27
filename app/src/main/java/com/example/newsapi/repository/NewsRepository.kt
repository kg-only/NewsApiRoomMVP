package com.example.newsapi.repository

import com.example.newsapi.main.api.RetrofitService
import com.example.newsapi.main.model.ArticlesParcelable

class NewsRepository(private val api: RetrofitService) : NewsRemoteRepository {

    override suspend fun loadNewsFromRemoteRepos(text: String): List<ArticlesParcelable> {
        val data = api.getNewsList(text)
        return data.articles.map { news ->
            ArticlesParcelable(
                source = news.source?.name!!,
                author = news.author,
                title = news.title,
                description = news.description,
                url = news.url,
                urlToImage = news.urlToImage,
                publishedAt = news.publishedAt
            )
        }
    }
}