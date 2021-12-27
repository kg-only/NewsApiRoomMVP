package com.example.newsapi.main.ui

import com.example.newsapi.common.mvp.MvpPresenter
import com.example.newsapi.common.mvp.MvpView
import com.example.newsapi.main.model.ArticlesParcelable
import com.example.newsapi.responsemodel.Articles

interface NewsContract {
    interface View : MvpView {
         fun getResultList(item: List<ArticlesParcelable>)

    }

    interface Presenter : MvpPresenter<View> {
         fun getDataFromApi(text: String)
         fun loadDataFromApi()

    }
}