package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep

@Keep
data class FixtureItem(
    val team1: String,

    val image1: String,

    val team2: String,

    val image2: String,

    val time: String,

    val date: String,
)