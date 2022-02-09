package com.example.championsleagueuefa.presentation.adapters.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.GroupChildItemBinding
import com.example.championsleagueuefa.domain.pojo.TeamItem

class GroupChildAdapter : ListAdapter<TeamItem,GroupChildAdapter.GroupChildViewHolder>(ChildDiffCallback()){

    inner class GroupChildViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private val binding = GroupChildItemBinding.bind(itemView)
        val childImage = binding.circleImageGroupChildImage
        val childTeam = binding.textViewGroupChildTeam
        val childWins = binding.textViewGroupChildWins
        val childFails = binding.textViewGroupChildFails
        val childDraws = binding.textViewGroupChildDraws
        val childScores = binding.textViewGroupChildScores
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupChildViewHolder {
        return GroupChildViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.gro))
    }

    override fun onBindViewHolder(holder: GroupChildViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}