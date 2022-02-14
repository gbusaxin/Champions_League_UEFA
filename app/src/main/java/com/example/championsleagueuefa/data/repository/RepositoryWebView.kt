package com.example.championsleagueuefa.data.repository

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.core.os.ConfigurationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.championsleagueuefa.data.network.dto.RequestDto
import com.example.championsleagueuefa.data.network.dto.ResponseDto
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class RepositoryWebView constructor(
    private val apiService: ApiService
) {

    private val _isResponseNegative = MutableLiveData<Boolean>()
    val isResponseNegative: LiveData<Boolean>
        get() = _isResponseNegative

    private fun getLocale(): RequestDto {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
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

    fun callToServer(webView: WebView) {
        try {
            apiService.sendLocale(getLocale()).enqueue(object : Callback<ResponseDto> {
                override fun onResponse(p0: Call<ResponseDto>, p1: Response<ResponseDto>) {
                    if (p1.body()?.response == "no") {
                        _isResponseNegative.value = true
                        Log.d("CHECK_CHECK", "true")
                    } else {
                        _isResponseNegative.value =
                            true //false to correct work, true for only test
                        webView.loadUrl(
                            p1.body()?.response ?: ""
                        )
                    }
                }

                override fun onFailure(p0: Call<ResponseDto>, p1: Throwable) {
                    Log.d("RESPONSE_CHROME", "fail in view model", p1)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}