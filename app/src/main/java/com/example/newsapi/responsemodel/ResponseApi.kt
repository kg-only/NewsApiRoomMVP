package com.example.newsapi.responsemodel

import com.google.gson.annotations.SerializedName

data class ResponseApi(
//    @SerializedName("status") var status: String? = null,
//    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: ArrayList<Articles> = arrayListOf(),
    )