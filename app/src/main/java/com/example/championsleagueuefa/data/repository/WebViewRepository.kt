package com.example.championsleagueuefa.data.repository

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Log
import android.webkit.WebSettings
import androidx.core.os.ConfigurationCompat
import com.example.championsleagueuefa.data.network.dto.RequestDto
import com.example.championsleagueuefa.data.network.retrofit.ApiService


class WebViewRepository constructor(private val apiService: ApiService) {

    suspend fun sendLocale() = apiService.sendLocale(getLocale())

    private fun getLocale(): RequestDto {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        Log.d("CHECK_LOCALE",lang.isO3Language)
        return RequestDto(lang.isO3Language)
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setWebViewSettings(settings: WebSettings) {
        with(settings) {
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            displayZoomControls = false
            allowFileAccess = true
            allowContentAccess = true
            javaScriptEnabled = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            userAgentString = settings.userAgentString.replace("; wv", "")
            javaScriptCanOpenWindowsAutomatically = true
            databaseEnabled = true
        }
    }

}