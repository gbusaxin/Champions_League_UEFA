package com.example.championsleagueuefa.presentation.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.NewsFragmentBinding
import com.example.championsleagueuefa.presentation.adapters.news.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding:NewsFragmentBinding?=null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter()
        viewModel.getNews.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.recyclerViewNews.adapter = adapter
        }
        adapter.onNewsClick = {
            viewModel.selectNews(it)
            findNavController().navigate(R.id.action_nav_news_to_newsDetailFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}