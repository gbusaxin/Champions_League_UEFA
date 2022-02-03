package com.example.championsleagueuefa.data.mapper

import com.example.championsleagueuefa.data.database.db_model.NewsDbModel
import com.example.championsleagueuefa.data.network.retrofit.dto.NewsDto
import com.example.championsleagueuefa.domain.pojo.NewsItem
import com.example.championsleagueuefa.utils.EntityMapper
import javax.inject.Inject

class NewsMapper
@Inject
constructor() : EntityMapper<NewsItem, NewsDbModel, NewsDto> {
    override fun mapDtoToDbModel(dto: NewsDto) = NewsDbModel(
        image = dto.image ?: "",
        title = dto.title ?: "",
        sDesc = dto.sDesc ?: "",
        date = dto.date ?: "",
        description = dto.description ?: ""
    )

    override fun mapDbModelToEntity(dbModel: NewsDbModel) = NewsItem(
        image = dbModel.image,
        title = dbModel.title,
        sDesc = dbModel.sDesc,
        date = dbModel.date,
        description = dbModel.description
    )
}