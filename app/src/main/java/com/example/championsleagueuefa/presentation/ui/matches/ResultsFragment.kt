package com.example.championsleagueuefa.presentation.ui.matches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {

    private var _binding:FragmentResultsBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val FRAGMENT_TITLE = "Результаты"
    }

}