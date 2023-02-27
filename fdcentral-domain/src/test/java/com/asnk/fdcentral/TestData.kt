package com.asnk.fdcentral

import com.asnk.fdcentral.domain.model.FoodDetailEntry
import com.asnk.fdcentral.domain.model.FoodEntry

fun getDummyFoods() = listOf(
    FoodEntry(
        fdcId = 1,
        description = "1",
        dataType = "1",
        publicationDate = "1",
        image = "1"
    )
)

fun getDummyFoodDetail() = FoodDetailEntry(
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