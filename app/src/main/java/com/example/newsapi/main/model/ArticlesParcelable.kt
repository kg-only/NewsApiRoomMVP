package com.example.newsapi.main.model

import android.os.Parcelable
import com.example.newsapi.responsemodel.Source
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesParcelable(
    var source: String,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
//    var content: String? = null,
) : Parcelable