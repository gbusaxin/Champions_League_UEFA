package com.example.championsleagueuefa.data.network.retrofit

import com.example.championsleagueuefa.data.network.retrofit.dto.NewsDto
import retrofit2.http.GET

interface ApiService {

    @GET("uefa_news.json")
    suspend fun loadNews():List<NewsDto>
}