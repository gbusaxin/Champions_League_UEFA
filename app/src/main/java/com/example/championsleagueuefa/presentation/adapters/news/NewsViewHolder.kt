package com.example.championsleagueuefa.presentation.adapters.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.databinding.NewsItemBinding

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = NewsItemBinding.bind(itemView)
    val image = binding.imageViewNewsItem
    val title = binding.textViewTitleNewsItem
}