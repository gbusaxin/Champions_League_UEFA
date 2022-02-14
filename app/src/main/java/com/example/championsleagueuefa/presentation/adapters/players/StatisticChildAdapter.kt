package com.example.championsleagueuefa.presentation.adapters.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ItemPlayersChildBinding
import com.example.championsleagueuefa.domain.pojo.PlayerItem
import com.squareup.picasso.Picasso

class StatisticChildAdapter(private val list: List<PlayerItem>) :
    RecyclerView.Adapter<StatisticChildAdapter.StatisticChildViewHolder>() {
    inner class StatisticChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayersChildBinding.bind(itemView)
        val playerImage = binding.circleImagePlayerImage
        val clubImage = binding.circleImagePlayerImageClub
        val playerScore = binding.textViewPlayerScore
        val playerName = binding.textViewPlayerName
        val playerClub = binding.textViewPlayerClub
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticChildViewHolder {
        return StatisticChildViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_players_child,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StatisticChildViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            Picasso.get().load(item.clubImage).into(clubImage)
            Picasso.get().load(item.image).into(playerImage)
            playerName.text = item.name
            playerClub.text = item.club
            playerScore.text = item.score
        }
    }

    override fun getItemCount() = list.size
}