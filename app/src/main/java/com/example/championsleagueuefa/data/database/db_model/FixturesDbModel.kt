package com.example.championsleagueuefa.data.database.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "fixtures_table")
class FixturesDbModel(

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
