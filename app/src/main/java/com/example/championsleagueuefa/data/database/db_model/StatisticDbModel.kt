package com.example.championsleagueuefa.data.database.db_model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.championsleagueuefa.data.database.converters.StatisticConverter
import com.example.championsleagueuefa.domain.pojo.PlayerItem
@Keep
@Entity(tableName = "statistic_table")
@TypeConverters(StatisticConverter::class)
data class StatisticDbModel(
    @PrimaryKey
    @ColumnInfo(name = "s_category")
    val category: String,
    @ColumnInfo(name = "s_players")
    val players: List<PlayerItem>
)