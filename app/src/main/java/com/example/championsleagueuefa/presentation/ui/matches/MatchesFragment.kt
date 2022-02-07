package com.example.championsleagueuefa.presentation.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.championsleagueuefa.databinding.MatchesFragmentBinding
import com.example.championsleagueuefa.presentation.adapters.matches.MatchViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MatchesFragment : Fragment() {

    private var _binding: MatchesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MatchesFragmentBinding.inflate(inflater, container, false)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val fragmentList = listOf(
            ResultsFragment(),
            FixturesFragment()
        )

        val adapter = MatchViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = fragmentList[position].tag

        }.attach()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}