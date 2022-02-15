package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep

@Keep
data class ResultItem(

    val team1: String,

    val image1: String,

    val team2: String,

    val image2: String,

    val result: String,

    val date: String,

    val group: String,

    val info: String
)