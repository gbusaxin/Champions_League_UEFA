package com.example.championsleagueuefa.data.mapper

import com.example.championsleagueuefa.data.database.db_model.GroupDbModel
import com.example.championsleagueuefa.data.network.dto.GroupDto
import com.example.championsleagueuefa.domain.pojo.GroupItem
import com.example.championsleagueuefa.utils.EntityMapper
import java.util.*
import javax.inject.Inject

class GroupMapper @Inject constructor() : EntityMapper<GroupItem, GroupDbModel, GroupDto> {
    override fun mapDtoToDbModel(dto: GroupDto) = GroupDbModel(
        group = dto.group ?: "",
        teams = dto.teams ?: Collections.emptyList(),
        matches = dto.matches ?: Collections.emptyList(),
    )

    override fun mapDbModelToEntity(dbModel: GroupDbModel) = GroupItem(
        group = dbModel.group,
        teams = dbModel.teams,
        matches = dbModel.matches,
    )
}