package com.example.championsleagueuefa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.NewsMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.domain.pojo.NewsItem
import com.example.championsleagueuefa.domain.repos.NewsRepository

class NewsRepositoryImpl constructor(
    private val dao: DbDao,
    private val apiService: ApiService,
    private val newsMapper: NewsMapper
) : NewsRepository {

    override fun getNews(): LiveData<List<NewsItem>> {
        return Transformations.map(dao.getNews()) {
            it.map { newsMapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadNews() {
        try {
            val dto = apiService.loadNews()
            val dbModel = dto.map { newsMapper.mapDtoToDbModel(it) }
            dao.insertNews(dbModel)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}