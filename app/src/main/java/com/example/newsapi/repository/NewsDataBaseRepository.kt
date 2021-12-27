package com.example.newsapi.repository

import com.example.newsapi.main.db.convertors.NewsConvertor
import com.example.newsapi.main.db.dao.Dao
import com.example.newsapi.main.model.ArticlesParcelable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsDataBaseRepository(private val dao: Dao) : NewsLocalRepository {

    override suspend fun insertListNewsLocalRepos(news: List<ArticlesParcelable>) {
        val entities = news.map { NewsConvertor.toDatabase(it) }
        dao.insertAll(entities)
    }

    override suspend fun getListNewsRoomLocalRepos(): Flow<List<ArticlesParcelable>> {
        return dao.getAll().map { list ->
            list.map { NewsConvertor.fromDatabase(it) }
        }
    }
}