package com.example.newsapi.repository

import com.example.newsapi.main.model.ArticlesParcelable
import kotlinx.coroutines.flow.Flow

interface NewsLocalRepository {
    suspend fun insertListNewsLocalRepos(news: List<ArticlesParcelable>)

    suspend fun getListNewsRoomLocalRepos(): Flow<List<ArticlesParcelable>>
}