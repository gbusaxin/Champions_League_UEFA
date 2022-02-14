package com.example.championsleagueuefa.presentation.adapters.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.GroupParentItemBinding
import com.example.championsleagueuefa.domain.pojo.GroupItem

class GroupParentAdapter(private val parentList: List<GroupItem>) :
    RecyclerView.Adapter<GroupParentAdapter.GroupParentViewHolder>() {

    private val rvPool = RecyclerView.RecycledViewPool()

    inner class GroupParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GroupParentItemBinding.bind(itemView)
        val parentRV = binding.groupsChildRecycler
        val horizontalRV = binding.groupssChildHorizontalRecycler
        val parentGroup = binding.textViewGroupParent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupParentViewHolder {
        return GroupParentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.group_parent_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GroupParentViewHolder, position: Int) {
        val item = parentList[position]
        holder.parentGroup.text = item.group
        holder.parentRV.apply {
            adapter = GroupChildAdapter(item.teams)
            setRecycledViewPool(rvPool)
        }
        holder.horizontalRV.apply {
            layoutManager = LinearLayoutManager(
                holder.horizontalRV.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = GroupChildHorizontalAdapter(item.matches)
        }
    }

    override fun getItemCount() = parentList.size
}