package com.example.championsleagueuefa.domain.pojo


data class GroupItem(
    val group: String,

    val teams: List<TeamItem>,

    val matches: List<GameItem>
)