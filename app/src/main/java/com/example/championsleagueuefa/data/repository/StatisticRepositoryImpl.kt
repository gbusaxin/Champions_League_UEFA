package com.example.championsleagueuefa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.StatisticMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.domain.pojo.StatisticItem
import com.example.championsleagueuefa.domain.repos.StatisticRepository

class StatisticRepositoryImpl constructor(
    private val dao: DbDao,
    private val apiService: ApiService,
    private val mapper: StatisticMapper,
) : StatisticRepository {

    override fun getStatistic(): LiveData<List<StatisticItem>> {
        return Transformations.map(dao.getStatistic()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadStatistic() {
        try {
            val dto = apiService.loadStatistic()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            dao.insertStatistic(dbModel)
        } catch (e: Exception) {

        }
    }
}