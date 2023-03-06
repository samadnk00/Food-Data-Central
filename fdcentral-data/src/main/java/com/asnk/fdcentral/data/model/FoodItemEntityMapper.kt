package com.asnk.fdcentral.data.model

import com.asnk.fdcentral.data.base.EntityMapper
import com.asnk.fdcentral.data.model.response.FoodItemResponse
import com.asnk.fdcentral.domain.model.FoodItemEntity
import javax.inject.Inject

class FoodItemEntityMapper @Inject constructor(): EntityMapper<FoodItemResponse, FoodItemEntity> {

    override fun mapToEntity(model: FoodItemResponse): FoodItemEntity = FoodItemEntity(
        fdcId = model.fdcId,
        description = model.description,
        dataType = model.dataType,
        publicationDate = model.publicationDate,
        image = model.image
    )

    fun mapToList(list: List<FoodItemResponse>): List<FoodItemEntity> = list.map {
            mapToEntity(it)
        }
}