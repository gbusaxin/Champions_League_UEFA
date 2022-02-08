package com.example.championsleagueuefa.presentation.ui.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.GroupsRepositoryImpl
import com.example.championsleagueuefa.domain.use_cases.GetGroupsUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupsViewModel @Inject constructor(
    repository: GroupsRepositoryImpl
) : ViewModel() {

    val getGroupsUseCase = GetGroupsUseCase(repository)
    val loadGroupsUseCase = LoadGroupsUseCase(repository)

    val getGroups = getGroupsUseCase()

    init {
        viewModelScope.launch {
            loadGroupsUseCase()
        }
    }

}