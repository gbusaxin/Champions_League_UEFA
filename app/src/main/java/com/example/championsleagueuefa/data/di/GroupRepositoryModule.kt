package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.GroupMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.GroupsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GroupRepositoryModule {

    @Singleton
    @Provides
    fun provideGroupRepository(
        dao: DbDao,
        apiService: ApiService,
        mapper: GroupMapper
    ): GroupsRepositoryImpl {
        return GroupsRepositoryImpl(dao, apiService, mapper)
    }
}