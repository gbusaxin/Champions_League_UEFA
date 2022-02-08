package com.example.championsleagueuefa.presentation.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.championsleagueuefa.databinding.FragmentResultsBinding
import com.example.championsleagueuefa.presentation.adapters.matches.ResultAdapter


class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MatchesViewModel by activityViewModels()
    private lateinit var adapter: ResultAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvResult = binding.recyclerViewResults
        adapter = ResultAdapter()
        viewModel.getResult.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            rvResult.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val FRAGMENT_TITLE = "Результаты"
    }

}