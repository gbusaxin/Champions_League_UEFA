package com.example.championsleagueuefa.data.network.dto

import com.example.championsleagueuefa.domain.pojo.PlayerItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class StatisticDto(
    @SerializedName("category")
    @Expose
     val category: String? = null,
    @SerializedName("players")
    @Expose
     val players: List<PlayerItem>? = null
)