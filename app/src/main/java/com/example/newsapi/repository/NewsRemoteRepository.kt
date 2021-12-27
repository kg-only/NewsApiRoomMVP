package com.example.newsapi.repository

import com.example.newsapi.main.model.ArticlesParcelable

interface NewsRemoteRepository {
    suspend fun loadNewsFromRemoteRepos(text:String): List<ArticlesParcelable>
}