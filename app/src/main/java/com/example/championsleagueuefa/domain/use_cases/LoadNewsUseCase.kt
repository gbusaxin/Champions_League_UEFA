package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.NewsRepository

class LoadNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke() = repository.loadNews()
}