package com.example.championsleagueuefa.data.network.retrofit

import com.example.championsleagueuefa.data.network.dto.FixturesDto
import com.example.championsleagueuefa.data.network.dto.GroupDto
import com.example.championsleagueuefa.data.network.dto.NewsDto
import com.example.championsleagueuefa.data.network.dto.ResultDto
import retrofit2.http.GET

interface ApiService {

    @GET("uefa_news.json")
    suspend fun loadNews():List<NewsDto>

    @GET("uefa_fixtures.json")
    suspend fun loadFixtures():List<FixturesDto>

    @GET("uefa_results.json")
    suspend fun loadResults():List<ResultDto>

    @GET("uefa_groups.json")
    suspend fun loadGroups():List<GroupDto>
}