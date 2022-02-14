package com.example.championsleagueuefa.presentation.adapters.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.GroupChildItemBinding
import com.example.championsleagueuefa.domain.pojo.TeamItem
import com.squareup.picasso.Picasso

class GroupChildAdapter(private val childList: List<TeamItem>) :
    RecyclerView.Adapter<GroupChildAdapter.GroupChildViewHolder>() {

    inner class GroupChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GroupChildItemBinding.bind(itemView)
        val childImage = binding.circleImageGroupChildImage
        val childTeam = binding.textViewGroupChildTeam
        val childWins = binding.textViewGroupChildWins
        val childFails = binding.textViewGroupChildFails
        val childDraws = binding.textViewGroupChildDraws
        val childScores = binding.textViewGroupChildScores
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupChildViewHolder {
        return GroupChildViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.group_child_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GroupChildViewHolder, position: Int) {
        val item = childList[position]
        with(holder) {
            setIsRecyclable(false)
            Picasso.get().load(item.image).into(childImage)
            childTeam.text = item.team
            childWins.text = item.wins
            childFails.text = item.fails
            childDraws.text = item.draws
            childScores.text = item.scores
        }
    }

    override fun getItemCount() = childList.size
}