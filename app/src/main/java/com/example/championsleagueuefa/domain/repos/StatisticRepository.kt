package com.example.championsleagueuefa.domain.repos

import androidx.lifecycle.LiveData
import com.example.championsleagueuefa.domain.pojo.StatisticItem

interface StatisticRepository {
    fun getStatistic(): LiveData<List<StatisticItem>>
    suspend fun loadStatistic()
}