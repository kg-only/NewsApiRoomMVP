package com.example.newsapi.main.ui

import android.util.Log
import com.example.newsapi.common.mvp.BasePresenter
import com.example.newsapi.interactor.InteractorNewsClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsPresenter(private val interactor: InteractorNewsClass) :
    BasePresenter<NewsContract.View>(),
    NewsContract.Presenter {
    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override  fun getDataFromApi(text: String) {
        presenterScope.launch {
            try {
                interactor.loadHeroesFromInteractor(text)
                Log.e("####", "SUCCESSS")

            } catch (e: Exception) {
                Log.e("###", "Error process in loadFromInteractor() ")
            }
        }
    }

    override fun loadDataFromApi() {
        presenterScope.launch {
            interactor.getHeroesFromInteractor().collect {
                view?.getResultList(it)
            }
        }
    }
}
