package com.example.championsleagueuefa.data.mapper

import com.example.championsleagueuefa.data.database.db_model.ResultDbModel
import com.example.championsleagueuefa.data.network.dto.ResultDto
import com.example.championsleagueuefa.domain.pojo.ResultItem
import com.example.championsleagueuefa.utils.EntityMapper
import javax.inject.Inject

class ResultMapper
@Inject constructor() : EntityMapper<ResultItem, ResultDbModel, ResultDto> {
    override fun mapDtoToDbModel(dto: ResultDto) = ResultDbModel(
        team1 = dto.team1 ?: "",
        team2 = dto.team2 ?: "",
        image1 = dto.image1 ?: "",
        image2 = dto.image2 ?: "",
        result = dto.result ?: "",
        date = dto.date ?: "",
        group = dto.group ?: "",
        info = dto.info ?: ""
    )

    override fun mapDbModelToEntity(dbModel: ResultDbModel) = ResultItem(
        team1 = dbModel.team1,
        team2 = dbModel.team2,
        image1 = dbModel.image1,
        image2 = dbModel.image2,
        result = dbModel.result,
        date = dbModel.date,
        group = dbModel.group,
        info = dbModel.info
    )
}