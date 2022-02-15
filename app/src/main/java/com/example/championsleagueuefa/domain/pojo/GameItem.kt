package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class GameItem(
    @SerializedName("team1")
    @Expose
    val team1: String,

    @SerializedName("image1")
    @Expose
    val image1: String,

    @SerializedName("team2")
    @Expose
    val team2: String,

    @SerializedName("image2")
    @Expose
    val image2: String,

    @SerializedName("result")
    @Expose
    val result: String,

    @SerializedName("whoWhin")
    @Expose
    val whoWin: Int
)