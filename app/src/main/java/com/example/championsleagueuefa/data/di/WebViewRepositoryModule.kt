package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.WebViewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WebViewRepositoryModule {

    @Singleton
    @Provides
    fun provideWebViewRepository(apiService: ApiService): WebViewRepository {
        return WebViewRepository(apiService)
    }

}