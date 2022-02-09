package com.example.championsleagueuefa.presentation.adapters.groups

import androidx.recyclerview.widget.DiffUtil
import com.example.championsleagueuefa.domain.pojo.TeamItem

class ChildDiffCallback : DiffUtil.ItemCallback<TeamItem>() {
    override fun areItemsTheSame(oldItem: TeamItem, newItem: TeamItem): Boolean {
        return oldItem.team == newItem.team
    }

    override fun areContentsTheSame(oldItem: TeamItem, newItem: TeamItem): Boolean {
        return oldItem == newItem
    }
}