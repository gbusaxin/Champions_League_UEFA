package com.example.championsleagueuefa.data.database.converters

import androidx.room.TypeConverter
import com.example.championsleagueuefa.domain.pojo.PlayerItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class StatisticConverter {
    @TypeConverter
    fun toListPlayersFromJson(player: String): List<PlayerItem> {
        if (player == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<PlayerItem>>() {}.type
        return Gson().fromJson(player, type)
    }

    @TypeConverter
    fun fromJsonToListPlayers(player: List<PlayerItem>): String {
        return Gson().toJson(player)
    }
}