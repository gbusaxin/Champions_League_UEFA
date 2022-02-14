package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.StatisticRepository

class GetStatisticUseCase(private val repository:StatisticRepository) {
    operator fun invoke() = repository.getStatistic()
}