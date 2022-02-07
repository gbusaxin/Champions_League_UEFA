package com.example.championsleagueuefa.presentation.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.FragmentNewsDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel:NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedNews.observe(viewLifecycleOwner){
            Picasso.get().load(it.image).into(binding.imageViewNewsDetailImage)
            binding.textViewNewsDetailDate.text = it.date
            binding.textViewNewsDetailSDesc.text = it.sDesc
            binding.textViewNewsDetailTitle.text = it.title
            binding.textViewNewsDetaildDescription.text = it.description
        }
    }

}