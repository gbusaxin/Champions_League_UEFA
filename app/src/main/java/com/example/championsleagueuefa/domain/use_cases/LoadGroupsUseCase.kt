package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.GroupsRepository

class LoadGroupsUseCase(private val repository: GroupsRepository) {
    suspend operator fun invoke() = repository.loadGroups()
}