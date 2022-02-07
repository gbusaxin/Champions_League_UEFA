package com.example.championsleagueuefa.data.mapper

import com.example.championsleagueuefa.data.database.db_model.FixturesDbModel
import com.example.championsleagueuefa.data.network.dto.FixturesDto
import com.example.championsleagueuefa.domain.pojo.FixtureItem
import com.example.championsleagueuefa.utils.EntityMapper
import javax.inject.Inject

class FixturesMapper @Inject constructor():EntityMapper<FixtureItem,FixturesDbModel,FixturesDto> {
    override fun mapDtoToDbModel(dto: FixturesDto) = FixturesDbModel(
        team1 = dto.team1?:"",
        image1 = dto.image1?:"",
        team2 = dto.team2?:"",
        image2 = dto.image2?:"",
        time = dto.time?:"",
        date = dto.date?:""
    )

    override fun mapDbModelToEntity(dbModel: FixturesDbModel) = FixtureItem (
        team1 = dbModel.team1,
        image1 = dbModel.image1,
        team2 = dbModel.team2,
        image2 = dbModel.image2,
        time = dbModel.time,
        date = dbModel.date
            )
}