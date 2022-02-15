package com.example.championsleagueuefa.presentation.ui

import android.util.Log
import android.webkit.WebSettings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.network.dto.ResponseDto
import com.example.championsleagueuefa.data.repository.WebViewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(
    private val repository: WebViewRepository
) : ViewModel() {

    private val _res = MutableLiveData<ResponseDto>()

    val res: LiveData<ResponseDto>
        get() = _res

    fun setSettings(settings: WebSettings) = repository.setWebViewSettings(settings)

    init {
        sendLocale()
    }

    private fun sendLocale() = viewModelScope.launch {
        repository.sendLocale().let {
            _res.value = it
            Log.d("CHECK_POST_VALUE", it.response ?: "NULL")
        }
    }
}