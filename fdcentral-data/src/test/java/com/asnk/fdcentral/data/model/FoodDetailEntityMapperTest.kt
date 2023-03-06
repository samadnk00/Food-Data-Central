package com.asnk.fdcentral.data.model

import com.asnk.fdcentral.getDummyFoodDetailResponse
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FoodDetailEntityMapperTest {
    private lateinit var itemEntityMapper: FoodDetailEntityMapper

    @Before
    fun setup() {
        itemEntityMapper = FoodDetailEntityMapper()
    }

    @Test
    fun mapFoodsResponseToDomainTest() {
        val foodItemResponse = getDummyFoodDetailResponse()
        val foodDetail = itemEntityMapper.mapToEntity(foodItemResponse)
        assertEquals(foodDetail.fdcId, foodItemResponse.fdcId)
        assertEquals(foodDetail.description, foodItemResponse.description)
        assertEquals(foodDetail.publicationDate, foodItemResponse.publicationDate)
        assertEquals(foodDetail.dataType, foodItemResponse.dataType)
        assertEquals(foodDetail.foodClass, foodItemResponse.foodClass)
        assertEquals(foodDetail.abstract, foodItemResponse.abstract)
        assertEquals(foodDetail.title, foodItemResponse.title)
        assertEquals(foodDetail.doiNumber, foodItemResponse.doiNumber)
        assertEquals(foodDetail.studyDesign, foodItemResponse.studyDesign)
        assertEquals(foodDetail.results, foodItemResponse.results)
    }
}