package com.example.newsapi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.R
import com.example.newsapi.main.model.ArticlesParcelable
import com.squareup.picasso.Picasso


class MyAdapter(private val onClick: (ArticlesParcelable) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val data = mutableListOf<ArticlesParcelable>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val icon: ImageView = item.findViewById(R.id.ImageView)
        private val title: TextView = item.findViewById(R.id.titleTextView)
        private val source: TextView = item.findViewById(R.id.source)


        @SuppressLint("SetTextI18n")
        fun bind(item: ArticlesParcelable) {

            itemView.setOnClickListener { (onClick.invoke(item)) }
//            Picasso.get().load(data).resize(400, 400)
//                .centerCrop().into(icon)
            Picasso.get().load(item.urlToImage).resize(600, 300).centerCrop().into(icon)
            title.text = item.title
            source.text = "Источник  " + item.source
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<ArticlesParcelable>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()//read about this
    }
}