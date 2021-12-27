package com.example.newsapi.interactor

import com.example.newsapi.responsemodel.ResponseApi

interface InteractorNews {
    suspend fun getNewsList(text:String): ResponseApi
}