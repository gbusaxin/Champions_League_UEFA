package com.example.championsleagueuefa.presentation.ui.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.PlayersFragmentBinding
import com.example.championsleagueuefa.presentation.adapters.players.StatisticParentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayersFragment : Fragment() {

    private var _binding: PlayersFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PlayersFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[PlayersViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvStatistic = binding.recyclerViewPlayers
        viewModel.getStatistic.observe(viewLifecycleOwner){
            rvStatistic.apply {
                adapter = StatisticParentAdapter(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}