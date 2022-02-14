package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.StatisticRepository

class LoadStatisticUseCase(private val repository: StatisticRepository) {
    suspend operator fun invoke() = repository.loadStatistic()
}