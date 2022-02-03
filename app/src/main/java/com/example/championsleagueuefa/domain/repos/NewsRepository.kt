package com.example.championsleagueuefa.domain.repos

import androidx.lifecycle.LiveData
import com.example.championsleagueuefa.domain.pojo.NewsItem

interface NewsRepository {

    fun getNews(): LiveData<List<NewsItem>>

    suspend fun loadNews()

}