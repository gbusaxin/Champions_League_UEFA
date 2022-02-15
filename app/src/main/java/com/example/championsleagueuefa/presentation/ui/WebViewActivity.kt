package com.example.championsleagueuefa.presentation.ui

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.databinding.ActivityWebViewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    private var _binding:ActivityWebViewBinding?=null
    private val binding get() = _binding!!

    private val viewModel by viewModels<WebViewViewModel>()

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webView = binding.webView
        progressBar = binding.progressBar
        swipeRefreshLayout = binding.swipeRefreshLayout

        viewModel.res.observe(this){
            Log.d("CHECH_ACT",it.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}