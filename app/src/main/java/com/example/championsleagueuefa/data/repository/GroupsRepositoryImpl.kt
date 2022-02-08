package com.example.championsleagueuefa.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.GroupMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.domain.pojo.GroupItem
import com.example.championsleagueuefa.domain.repos.GroupsRepository

class GroupsRepositoryImpl constructor(
    private val dao: DbDao,
    private val apiService: ApiService,
    private val mapper: GroupMapper,
) : GroupsRepository {

    override fun getGroups(): LiveData<List<GroupItem>> {
        return Transformations.map(dao.getGroups()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadGroups() {
        try {
            val dto = apiService.loadGroups()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            dao.insertGroups(dbModel)
        } catch (e: Exception) {

        }
    }

}