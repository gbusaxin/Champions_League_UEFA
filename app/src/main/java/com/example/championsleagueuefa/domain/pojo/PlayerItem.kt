package com.example.championsleagueuefa.domain.pojo

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class PlayerItem(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("club")
    @Expose
    val club: String,
    @SerializedName("score")
    @Expose
    val score: String,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("clubImage")
    @Expose
    val clubImage: String
)