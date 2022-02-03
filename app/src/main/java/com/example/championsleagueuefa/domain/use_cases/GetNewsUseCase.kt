package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.NewsRepository

class GetNewsUseCase(private val repository: NewsRepository) {
    operator fun invoke() = repository.getNews()
}