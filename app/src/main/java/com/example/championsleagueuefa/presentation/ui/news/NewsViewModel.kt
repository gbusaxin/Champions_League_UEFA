package com.example.championsleagueuefa.presentation.ui.news

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.NewsRepositoryImpl
import com.example.championsleagueuefa.domain.use_cases.GetNewsUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
):ViewModel(){

    private val getNewsUseCase = GetNewsUseCase(repository)
    private val loadNewsUseCase = LoadNewsUseCase(repository)

    val getNews = getNewsUseCase()

    init {
        viewModelScope.launch {
            loadNewsUseCase()
        }
    }

}

