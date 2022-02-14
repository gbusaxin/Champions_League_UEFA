package com.example.championsleagueuefa.presentation.ui.groups

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.GroupsFragmentBinding
import com.example.championsleagueuefa.presentation.adapters.groups.GroupParentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupsFragment : Fragment() {

    private var _binding: GroupsFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GroupsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GroupsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvParent = binding.groupRecyclerView
        viewModel.getGroups.observe(viewLifecycleOwner){
            rvParent.apply {
                adapter = GroupParentAdapter(it)
            }
        }
    }

}