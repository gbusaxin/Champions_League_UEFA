package com.example.championsleagueuefa.data.mapper

import com.example.championsleagueuefa.data.database.db_model.StatisticDbModel
import com.example.championsleagueuefa.data.network.dto.StatisticDto
import com.example.championsleagueuefa.domain.pojo.StatisticItem
import com.example.championsleagueuefa.utils.EntityMapper
import java.util.*
import javax.inject.Inject

class StatisticMapper @Inject
constructor() : EntityMapper<StatisticItem, StatisticDbModel, StatisticDto> {

    override fun mapDtoToDbModel(dto: StatisticDto) = StatisticDbModel(
        category = dto.category ?: "",
        players = dto.players ?: Collections.emptyList()
    )

    override fun mapDbModelToEntity(dbModel: StatisticDbModel) = StatisticItem(
        category = dbModel.category,
        players = dbModel.players
    )

}