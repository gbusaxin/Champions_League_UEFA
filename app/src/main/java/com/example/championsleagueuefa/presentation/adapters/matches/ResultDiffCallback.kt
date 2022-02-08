package com.example.championsleagueuefa.presentation.adapters.matches

import androidx.recyclerview.widget.DiffUtil
import com.example.championsleagueuefa.domain.pojo.ResultItem

class ResultDiffCallback:DiffUtil.ItemCallback<ResultItem>() {
    override fun areItemsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem.info == newItem.info
    }

    override fun areContentsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
        return oldItem == newItem
    }
}