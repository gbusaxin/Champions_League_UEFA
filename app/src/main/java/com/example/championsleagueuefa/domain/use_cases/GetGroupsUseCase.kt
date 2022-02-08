package com.example.championsleagueuefa.domain.use_cases

import com.example.championsleagueuefa.domain.repos.GroupsRepository

class GetGroupsUseCase(private val repository: GroupsRepository) {
    operator fun invoke() = repository.getGroups()
}