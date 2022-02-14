package com.example.championsleagueuefa.data.di

import com.example.championsleagueuefa.data.network.retrofit.ApiService
import com.example.championsleagueuefa.data.repository.RepositoryWebView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryWebViewModule {

    @Singleton
    @Provides
    fun provideRepositoryWebView(
        apiService: ApiService
    ): RepositoryWebView {
        return RepositoryWebView(apiService)
    }

}