package com.example.championsleagueuefa.data.database.converters

import androidx.room.TypeConverter
import com.example.championsleagueuefa.domain.pojo.GameItem
import com.example.championsleagueuefa.domain.pojo.TeamItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class GroupConverter {
    @TypeConverter
    fun toListTeamsFromJson(team: String): List<TeamItem> {
        if (team == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<TeamItem>>() {}.type
        return Gson().fromJson(team, type)
    }

    @TypeConverter
    fun fromJsonToListTeams(team: List<TeamItem>): String {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun toListGamesFromJson(game: String): List<GameItem> {
        if (game == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<GameItem>>() {}.type
        return Gson().fromJson(game, type)
    }

    @TypeConverter
    fun fromJsonToListGames(game: List<GameItem>): String {
        return Gson().toJson(game)
    }
}