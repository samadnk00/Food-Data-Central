package com.asnk.fdcentral.data.model

import com.asnk.fdcentral.data.base.EntityMapper
import com.asnk.fdcentral.data.model.response.FoodDetailResponse
import com.asnk.fdcentral.domain.model.FoodDetailEntity
import javax.inject.Inject

class FoodDetailEntityMapper @Inject constructor() : EntityMapper<FoodDetailResponse, FoodDetailEntity> {

    override fun mapToEntity(model: FoodDetailResponse): FoodDetailEntity = FoodDetailEntity(
        fdcId = model.fdcId,
        description = model.description,
        publicationDate = model.publicationDate,
        dataType = model.dataType,
        foodClass = model.foodClass,
        abstract = model.abstract,
        title = model.title,
        doiNumber = model.doiNumber,
        studyDesign = model.studyDesign,
        results = model.results
    )
}