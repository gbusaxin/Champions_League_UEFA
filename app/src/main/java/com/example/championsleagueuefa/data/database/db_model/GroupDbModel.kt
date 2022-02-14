package com.example.championsleagueuefa.data.database.db_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.championsleagueuefa.data.database.converters.GroupConverter
import com.example.championsleagueuefa.domain.pojo.GameItem
import com.example.championsleagueuefa.domain.pojo.TeamItem

@Entity(tableName = "groups_table")
@TypeConverters(GroupConverter::class)
data class GroupDbModel(
    @PrimaryKey
    @ColumnInfo(name = "g_group")
    val group: String,

    @ColumnInfo(name = "g_teams")
    val teams: List<TeamItem>,

    @ColumnInfo(name = "g_games")
    val matches: List<GameItem>
)