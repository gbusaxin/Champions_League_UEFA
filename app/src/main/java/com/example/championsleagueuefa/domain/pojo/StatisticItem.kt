package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep

@Keep
data class StatisticItem(
    val category: String,
    val players: List<PlayerItem>
)