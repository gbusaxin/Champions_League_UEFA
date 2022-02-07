package com.example.championsleagueuefa.presentation.adapters.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.domain.pojo.NewsItem
import com.squareup.picasso.Picasso

class NewsAdapter : ListAdapter<NewsItem, NewsViewHolder>(NewsDiffCallBack()) {

    var onNewsClick:((NewsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        Picasso.get().load(item.image).into(holder.image)
        holder.title.text = item.title
        holder.itemView.setOnClickListener {
            onNewsClick?.invoke(item)
        }
    }
}