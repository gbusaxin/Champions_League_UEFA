package com.example.championsleagueuefa.presentation.adapters.matches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ItemResultBinding
import com.example.championsleagueuefa.domain.pojo.ResultItem
import com.squareup.picasso.Picasso

class ResultAdapter :
    ListAdapter<ResultItem, ResultAdapter.ResultViewHolder>(ResultDiffCallback()) {
    inner class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultBinding.bind(view)
        val image1 = binding.circleImageResultImage1
        val team1 = binding.textViewResultTeam1
        val image2 = binding.circleImageResultImage2
        val team2 = binding.textViewResultTeam2
        val result = binding.textViewResultResult
        val date = binding.textViewResultDate
        val info = binding.textViewResultInfo
        val group = binding.textViewResultGroup
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_result,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            Picasso.get().load(item.image1).into(image1)
            team1.text = item.team1
            Picasso.get().load(item.image2).into(image2)
            team2.text = item.team2
            result.text = item.result
            info.text = item.info
            group.text = item.group
            date.text = item.date
        }
    }
}