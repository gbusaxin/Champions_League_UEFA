package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep

@Keep
data class GroupItem(
    val group: String,

    val teams: List<TeamItem>,

    val matches: List<GameItem>
)