package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.StatisticMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.StatisticRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StatisticRepositoryModule {

    @Singleton
    @Provides
    fun provideStatisticRepository(
        dao: DbDao,
        apiService: ApiService,
        mapper: StatisticMapper
    ): StatisticRepositoryImpl {
        return StatisticRepositoryImpl(dao, apiService, mapper)
    }

}