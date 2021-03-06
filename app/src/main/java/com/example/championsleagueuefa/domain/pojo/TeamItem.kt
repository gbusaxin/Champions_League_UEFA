package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class TeamItem(
    @SerializedName("team")
    @Expose
    val team: String,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("wins")
    @Expose
    val wins: String,

    @SerializedName("fails")
    @Expose
    val fails: String,

    @SerializedName("draws")
    @Expose
    val draws: String,

    @SerializedName("scores")
    @Expose
    val scores: String
)