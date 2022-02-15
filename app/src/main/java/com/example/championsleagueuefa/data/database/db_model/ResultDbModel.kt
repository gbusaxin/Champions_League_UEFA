package com.example.championsleagueuefa.data.database.db_model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "results_table")
data class ResultDbModel(

    @ColumnInfo(name = "r_team1")
    val team1: String,

    @ColumnInfo(name = "r_image1")
    val image1: String,

    @ColumnInfo(name = "r_team2")
    val team2: String,

    @ColumnInfo(name = "r_image2")
    val image2: String,

    @ColumnInfo(name = "r_result")
    val result: String,

    @ColumnInfo(name = "r_date")
    val date: String,

    @ColumnInfo(name = "r_group")
    val group: String,

    @PrimaryKey
    @ColumnInfo(name = "r_info")
    val info: String

)