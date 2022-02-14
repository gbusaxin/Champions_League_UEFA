package com.example.championsleagueuefa.presentation.adapters.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ItemPlayersParentBinding
import com.example.championsleagueuefa.domain.pojo.StatisticItem

class StatisticParentAdapter(private val list: List<StatisticItem>) :
    RecyclerView.Adapter<StatisticParentAdapter.StatisticParentViewHolder>() {
    inner class StatisticParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayersParentBinding.bind(itemView)
        val category = binding.textViewPlayerCategory
        val rvParent = binding.recyclerViewPlayersChild
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticParentViewHolder {
        return StatisticParentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_players_parent,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StatisticParentViewHolder, position: Int) {
        val item = list[position]
        holder.category.text = item.category
        holder.rvParent.apply {
            adapter = StatisticChildAdapter(item.players)
        }
    }

    override fun getItemCount() = list.size
}