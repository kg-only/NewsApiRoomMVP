package com.example.newsapi.main.db.convertors

import com.example.newsapi.main.db.dbmodels.ArticlesEntity
import com.example.newsapi.main.model.ArticlesParcelable

object NewsConvertor {
    fun toDatabase(news: ArticlesParcelable): ArticlesEntity =
        ArticlesEntity(
            source = news.source,
            author = news.author,
            title = news.title,
            description = news.description,
            url = news.url,
            urlToImage = news.urlToImage,
            publishedAt = news.publishedAt
        )

    fun fromDatabase(entity: ArticlesEntity): ArticlesParcelable =
        ArticlesParcelable(
            source = entity.source!!,
            author = entity.author,
            title = entity.title,
            description = entity.description,
            url = entity.url,
            urlToImage = entity.urlToImage,
            publishedAt = entity.publishedAt
        )
}