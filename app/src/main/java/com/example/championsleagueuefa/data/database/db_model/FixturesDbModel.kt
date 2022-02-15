package com.example.championsleagueuefa.data.database.db_model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Keep
@Entity(tableName = "fixtures_table")
data class FixturesDbModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fake_pk")
    val id:Int,

    @ColumnInfo(name = "f_team1")
    val team1: String,

    @ColumnInfo(name = "f_image1")
    val image1: String,

    @ColumnInfo(name = "f_team2")
    val team2: String,

    @ColumnInfo(name = "f_image2")
    val image2: String,

    @ColumnInfo(name = "f_time")
    val time: String,

    @ColumnInfo(name = "f_date")
    val date: String

    )
