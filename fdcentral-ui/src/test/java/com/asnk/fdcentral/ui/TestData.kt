package com.asnk.fdcentral.ui

import com.asnk.fdcentral.domain.model.FoodDetailEntity
import com.asnk.fdcentral.domain.model.FoodItemEntity

fun getDummyFoods() = listOf(
    FoodItemEntity(
        fdcId = 1,
        description = "1",
        dataType = "1",
        publicationDate = "1",
        image = "1"
    )
)

fun getDummyFoodDetail() = FoodDetailEntity(
    fdcId =  1,
    description =  "1",
    publicationDate =  "1",
    dataType =  "1",
    foodClass =  "1",
    abstract =  "1",
    title =  "1",
    doiNumber =  "1",
    studyDesign =  "1",
    results =  "1",
)