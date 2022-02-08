package com.example.championsleagueuefa.domain.repos

import androidx.lifecycle.LiveData
import com.example.championsleagueuefa.domain.pojo.GroupItem

interface GroupsRepository {
    fun getGroups(): LiveData<List<GroupItem>>

    suspend fun loadGroups()
}