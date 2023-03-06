package com.asnk.fdcentral

import com.asnk.fdcentral.data.model.response.FoodDetailResponse
import com.asnk.fdcentral.data.model.response.FoodItemResponse

fun getDummyFoods() = listOf(
    FoodItemResponse(
        fdcId = 1,
        description = "1",
        dataType = "1",
        publicationDate = "1",
        image = "1"
    )
)

fun getDummyFoodDetailResponse() = FoodDetailResponse(
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