package com.example.championsleagueuefa.presentation.adapters.matches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ItemFixturesBinding
import com.example.championsleagueuefa.domain.pojo.FixtureItem
import com.squareup.picasso.Picasso

class FixturesAdapter :
    ListAdapter<FixtureItem, FixturesAdapter.FixtureViewHolder>(FixturesDiffCallback()) {

    inner class FixtureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFixturesBinding.bind(view)
        val name1 = binding.textViewFixturesName1
        val image1 = binding.circleImageFixturesImage1
        val name2 = binding.textViewFixturesName2
        val image2 = binding.circleImageFixturesImage2
        val time = binding.textViewFixturesTime
        val date = binding.textViewFixturesDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        return FixtureViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fixtures, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            Picasso.get().load(item.image1).into(image1)
            name1.text = item.team1
            Picasso.get().load(item.image2).into(image2)
            name2.text = item.team2
            time.text = item.time
            date.text = item.date
        }
    }
}