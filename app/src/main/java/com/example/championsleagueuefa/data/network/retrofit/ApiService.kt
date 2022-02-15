package com.example.championsleagueuefa.data.network.retrofit

import com.example.championsleagueuefa.data.network.dto.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("uefa_news.json")
    suspend fun loadNews(): List<NewsDto>

    @GET("uefa_fixtures.json")
    suspend fun loadFixtures(): List<FixturesDto>

    @GET("uefa_results.json")
    suspend fun loadResults(): List<ResultDto>

    @GET("uefa_groups.json")
    suspend fun loadGroups(): List<GroupDto>

    @GET("uefa_statistic.json")
    suspend fun loadStatistic(): List<StatisticDto>

    @POST("splash.php")
    suspend fun sendLocale(@Body locale: RequestDto): ResponseDto

}