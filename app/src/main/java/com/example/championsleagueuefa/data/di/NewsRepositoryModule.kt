package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.database.DbDao
import com.example.championsleagueuefa.data.mapper.NewsMapper
import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsRepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        dao: DbDao,
        apiService: ApiService,
        newsMapper: NewsMapper
    ): NewsRepositoryImpl {
        return NewsRepositoryImpl(dao, apiService, newsMapper)
    }
}