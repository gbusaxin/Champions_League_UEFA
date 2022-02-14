package com.example.championsleagueuefa.presentation.adapters.groups

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ItemGameBinding
import com.example.championsleagueuefa.domain.pojo.GameItem
import com.squareup.picasso.Picasso

class GroupChildHorizontalAdapter(
    private val list: List<GameItem>
) : RecyclerView.Adapter<GroupChildHorizontalAdapter.GroupChildHorizontalViewHolder>() {

    inner class GroupChildHorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemGameBinding.bind(itemView)
        val gameImage1 = binding.circleImageGameTeam1
        val gameImage2 = binding.circleImageGameTeam2
        val gameTeam1 = binding.textViewGameTeam1
        val gameTeam2 = binding.textViewGameTeam2
        val gameResult = binding.textViewGameResult
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupChildHorizontalViewHolder {
        return GroupChildHorizontalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_game,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GroupChildHorizontalViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            Picasso.get().load(item.image1).into(gameImage1)
            Picasso.get().load(item.image2).into(gameImage2)
            when (item.whoWin) {
                1 -> {
                    gameTeam1.setTextColor(Color.GREEN)
                    gameTeam2.setTextColor(Color.RED)
                }
                2 -> {
                    gameTeam1.setTextColor(Color.RED)
                    gameTeam2.setTextColor(Color.GREEN)
                }
                else -> {
                    gameTeam1.setTextColor(Color.YELLOW)
                    gameTeam2.setTextColor(Color.YELLOW)
                }
            }
            gameTeam2.text = item.team2
            gameTeam1.text = item.team1
            gameResult.text = item.result
        }
    }

    override fun getItemCount() = list.size
}