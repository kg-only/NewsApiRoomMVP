package com.example.newsapi.interactor

import com.example.newsapi.main.model.ArticlesParcelable
import com.example.newsapi.repository.NewsLocalRepository
import com.example.newsapi.repository.NewsRemoteRepository
import kotlinx.coroutines.flow.Flow

class InteractorNewsClass(
    private val newsLocalRepository: NewsLocalRepository,
    private val newsRemoteRepository: NewsRemoteRepository,
) {
    suspend fun getHeroesFromInteractor(): Flow<List<ArticlesParcelable>> {
        return newsLocalRepository.getListNewsRoomLocalRepos()
    }

    suspend fun loadHeroesFromInteractor(text:String): List<ArticlesParcelable> {
        val news = newsRemoteRepository.loadNewsFromRemoteRepos(text)
        newsLocalRepository.insertListNewsLocalRepos(news)
        return news
    }
}
//override suspend fun getPhotoList(text: String): PhotosSearchResponse =
//    withContext(Dispatchers.IO) {
//        return@withContext api.getPhotoList(text)
//    }