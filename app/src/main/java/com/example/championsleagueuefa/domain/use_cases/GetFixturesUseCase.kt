package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.MatchesRepository

class GetFixturesUseCase(private val repository: MatchesRepository) {
    operator fun invoke() = repository.getFixtures()
}