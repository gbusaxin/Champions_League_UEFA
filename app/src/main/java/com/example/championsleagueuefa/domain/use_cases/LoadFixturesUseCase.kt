package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.MatchesRepository

class LoadFixturesUseCase(private val repository: MatchesRepository) {
    suspend operator fun invoke() = repository.loadFixtures()
}