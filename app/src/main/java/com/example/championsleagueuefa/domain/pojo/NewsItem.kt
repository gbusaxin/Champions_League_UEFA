package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep

@Keep
data class NewsItem(
    val image: String,

    val title: String,

    val sDesc: String,

    val date: String,

    val description: String
)