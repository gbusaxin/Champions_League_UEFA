package com.example.championsleagueuefa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.FixturesMapper
import com.example.championsleagueuefa.data.mapper.ResultMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.domain.pojo.FixtureItem
import com.example.championsleagueuefa.domain.pojo.ResultItem
import com.example.championsleagueuefa.domain.repos.MatchesRepository

class MatchRepositoryImpl constructor(
    private val dao: DbDao,
    private val apiService: ApiService,
    private val resultMapper: ResultMapper,
    private val fixturesMapper: FixturesMapper
) : MatchesRepository {
    override fun getFixtures(): LiveData<List<FixtureItem>> {
        return Transformations.map(dao.getFixtures()){
            it.map { fixturesMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getResults(): LiveData<List<ResultItem>> {
        return Transformations.map(dao.getResults()){
            it.map { resultMapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadFixtures() {
        try {
            val dto = apiService.loadFixtures()
            val dbModel = dto.map { fixturesMapper.mapDtoToDbModel(it) }
            dao.insertFixtures(dbModel)
        } catch (e: Exception) {

        }
    }

    override suspend fun loadResults() {
        try {
            val dto = apiService.loadResults()
            val dbModel = dto.map { resultMapper.mapDtoToDbModel(it) }
            dao.insertResults(dbModel)
        } catch (e: Exception) {

        }
    }

}