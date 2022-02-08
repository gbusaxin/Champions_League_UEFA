package com.example.championsleagueuefa.domain.repos

import androidx.lifecycle.LiveData
import com.example.championsleagueuefa.domain.pojo.FixtureItem
import com.example.championsleagueuefa.domain.pojo.ResultItem

interface MatchesRepository {

    fun getFixtures(): LiveData<List<FixtureItem>>
    fun getResults(): LiveData<List<ResultItem>>

    suspend fun deleteAllFixtures()

    suspend fun loadFixtures()
    suspend fun loadResults()

}