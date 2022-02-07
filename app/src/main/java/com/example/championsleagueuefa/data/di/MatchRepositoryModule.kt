package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.FixturesMapper
import com.example.championsleagueuefa.data.mapper.ResultMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.MatchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MatchRepositoryModule {

    @Singleton
    @Provides
    fun provideMatchesRepository(
        dao: DbDao,
        apiService: ApiService,
        resultMapper: ResultMapper,
        fixturesMapper: FixturesMapper
    ): MatchRepositoryImpl {
        return MatchRepositoryImpl(dao, apiService,resultMapper, fixturesMapper )
    }
}