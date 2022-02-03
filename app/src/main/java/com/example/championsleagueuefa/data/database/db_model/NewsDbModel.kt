package com.example.championsleagueuefa.data.database.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsDbModel (

    @ColumnInfo(name = "image")
    val image: String,

    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "sDesc")
    val sDesc: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "description")
    val description: String

)