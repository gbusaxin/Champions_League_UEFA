package com.example.championsleagueuefa.presentation.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.championsleagueuefa.databinding.FragmentFixturesBinding
import com.example.championsleagueuefa.presentation.adapters.matches.FixturesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MatchesViewModel by activityViewModels()
    private lateinit var adapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFixtures = binding.recyclerViewFixtures
        adapter = FixturesAdapter()
        viewModel.getFixtures.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            rvFixtures.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        viewModel.deleteAllFixtures()
        _binding = null
    }

}