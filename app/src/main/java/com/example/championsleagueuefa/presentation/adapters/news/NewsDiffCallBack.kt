package com.example.championsleagueuefa.presentation.adapters.news

import androidx.recyclerview.widget.DiffUtil
import com.example.championsleagueuefa.domain.pojo.NewsItem

class NewsDiffCallBack : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.description == newItem.description
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}