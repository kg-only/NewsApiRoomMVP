package com.example.newsapi

import android.os.Bundle
import com.example.newsapi.common.mvp.BaseActivity
import com.example.newsapi.main.ui.NewsFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(NewsFragment())
    }
}
