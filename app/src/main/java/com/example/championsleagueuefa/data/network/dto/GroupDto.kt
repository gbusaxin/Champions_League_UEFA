package com.example.championsleagueuefa.data.network.dto

import com.example.championsleagueuefa.domain.pojo.GameItem
import com.example.championsleagueuefa.domain.pojo.TeamItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class GroupDto(
    @SerializedName("group")
    @Expose
    val group: String? = null,

    @SerializedName("teams")
    @Expose
    val teams: List<TeamItem>? = null,

    @SerializedName("matches")
    @Expose
    val matches: List<GameItem>? = null
)