package com.example.newsapi.main.ui

import androidx.room.Room
import com.example.newsapi.interactor.InteractorNewsClass
import com.example.newsapi.main.db.database.NewsDataBase
import com.example.newsapi.repository.NewsDataBaseRepository
import com.example.newsapi.repository.NewsLocalRepository
import com.example.newsapi.repository.NewsRemoteRepository
import com.example.newsapi.repository.NewsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule {
    fun create(): Module = module {
        factory { NewsPresenter(get()) }
        factory { InteractorNewsClass(get(), get()) }

        single {
            Room.databaseBuilder(get(), NewsDataBase::class.java, "resultDao")
                .build()
        }
        single { get<NewsDataBase>().resultDao() }
        single<NewsLocalRepository> { NewsDataBaseRepository(get()) }
        single<NewsRemoteRepository> { NewsRepository(get()) }
    }
}