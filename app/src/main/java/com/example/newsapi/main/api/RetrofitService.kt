package com.example.newsapi.main.api

import com.example.newsapi.responsemodel.ResponseApi
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("everything?sortBy=popularity&language=ru&apiKey=77de55c63b364858938b7f74192a5fb5")
   suspend fun getNewsList(@Query ("q") text:String) : ResponseApi
}
//https://newsapi.org/v2/everything?q=tesla&sortBy=popularity&language=ru&apiKey=77de55c63b364858938b7f74192a5fb5