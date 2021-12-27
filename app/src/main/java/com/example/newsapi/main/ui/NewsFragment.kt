package com.example.newsapi.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.R
import com.example.newsapi.adapter.MyAdapter
import com.example.newsapi.adapter.Paging
import com.example.newsapi.common.mvp.BaseFragmentMvp
import com.example.newsapi.databinding.FragmentNewsBinding
import com.example.newsapi.main.model.ArticlesParcelable
import com.example.newsapi.responsemodel.Articles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject

private lateinit var adapter: MyAdapter
private lateinit var binding: FragmentNewsBinding

class NewsFragment : BaseFragmentMvp<NewsContract.View,
        NewsContract.Presenter>(R.layout.fragment_news), NewsContract.View {

    override val presenter: NewsPresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView()
        presenter.loadDataFromApi()
        binding.searchText.setOnClickListener {
            presenter.getDataFromApi(binding.searchText.text.toString())
        }

    }

    private fun recyclerView() {
        adapter = MyAdapter(onClick = { startInfoFragment(it) })
        binding.recyclerNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerNews.adapter = adapter
    }

    private fun recyclerPagingView(text: String) {
        adapter = MyAdapter(onClick = { startInfoFragment(it) })
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerNews.adapter = adapter
        val scrollListener = Paging(linearLayoutManager) {

        }
        presenter.getDataFromApi(text)
        binding.recyclerNews.clearOnScrollListeners()
        binding.recyclerNews.addOnScrollListener(scrollListener)
    }

    override fun getResultList(item: List<ArticlesParcelable>) {
        adapter.setItems(item)
    }

    private fun startInfoFragment(photos: ArticlesParcelable) {
        val data = Bundle()
        data.putParcelable("photos", photos)
        val info = InfoFragment()
        info.arguments = data
        changeFragment(info, R.id.frame_layout)
    }
}