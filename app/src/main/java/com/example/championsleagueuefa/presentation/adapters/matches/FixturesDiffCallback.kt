package com.example.championsleagueuefa.presentation.adapters.matches

import androidx.recyclerview.widget.DiffUtil
import com.example.championsleagueuefa.domain.pojo.FixtureItem

class FixturesDiffCallback : DiffUtil.ItemCallback<FixtureItem>() {
    override fun areItemsTheSame(oldItem: FixtureItem, newItem: FixtureItem): Boolean {
        return oldItem.team1 == newItem.team1
    }

    override fun areContentsTheSame(oldItem: FixtureItem, newItem: FixtureItem): Boolean {
        return oldItem == newItem
    }
}