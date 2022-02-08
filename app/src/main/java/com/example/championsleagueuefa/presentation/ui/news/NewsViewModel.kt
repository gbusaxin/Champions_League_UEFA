package com.example.championsleagueuefa.presentation.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.NewsRepositoryImpl
import com.example.championsleagueuefa.domain.pojo.NewsItem
import com.example.championsleagueuefa.domain.use_cases.GetNewsUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
     repository: NewsRepositoryImpl
):ViewModel(){

    private val getNewsUseCase = GetNewsUseCase(repository)
    private val loadNewsUseCase = LoadNewsUseCase(repository)
    private var _selectedNews = MutableLiveData<NewsItem>()
    val selectedNews:LiveData<NewsItem> get() = _selectedNews

    val getNews = getNewsUseCase()

    fun selectNews(news:NewsItem){
        _selectedNews.value = news
    }

    init {
        viewModelScope.launch {
            loadNewsUseCase()
        }
    }

}

