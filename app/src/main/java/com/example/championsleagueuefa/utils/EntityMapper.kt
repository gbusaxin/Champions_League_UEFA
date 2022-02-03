package com.example.championsleagueuefa.utils

interface EntityMapper<Entity, DbModel, Dto> {

    fun mapDtoToDbModel(dto: Dto): DbModel

    fun mapDbModelToEntity(dbModel: DbModel): Entity

}