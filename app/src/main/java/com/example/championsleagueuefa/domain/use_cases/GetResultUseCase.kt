package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.MatchesRepository

class GetResultUseCase(private val repository: MatchesRepository) {
    operator fun invoke() = repository.getResults()
}