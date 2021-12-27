package com.example.newsapi.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Paging(
    private val layoutManager: LinearLayoutManager,
    private val loadNextPage: (Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var isLoading = false
    private var total = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (totalItemCount == visibleItemCount) return

        if (isLoading && totalItemCount > total) {
            isLoading = false
            total = totalItemCount
        }

        if (!isLoading && totalItemCount - visibleItemCount <= firstVisibleItem + 10) {
            loadNextPage(totalItemCount)
            isLoading = true
        }
    }
}
//////////////////////////////////////////////////////////////////////Example///////////////////////////////////////////////////
//with(binding.historyRecyclerView) {
//    val linearLayoutManager = LinearLayoutManager(requireContext())
//    layoutManager = linearLayoutManager
//    attachAdapter(historyAdapter)
//
//    val scrollListener = EndlessScrollListener(linearLayoutManager) {
//        presenter.fetchNextPage()
//    }
//
//    clearOnScrollListeners()
//    addOnScrollListener(scrollListener)
