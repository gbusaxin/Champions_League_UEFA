package com.example.championsleagueuefa.data.database.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
class NewsDbModel(

    @ColumnInfo(name = "n_image")
    val image: String,

    @ColumnInfo(name = "n_title")
    @PrimaryKey
    val title: String,

    @ColumnInfo(name = "n_sDesc")
    val sDesc: String,

    @ColumnInfo(name = "n_date")
    val date: String,

    @ColumnInfo(name = "n_description")
    val description: String

)