package com.asnk.fdcentral.data.model

import com.asnk.fdcentral.getDummyFoods
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FoodItemEntityMapperTest {

    private lateinit var itemEntityMapper: FoodItemEntityMapper

    @Before
    fun setup() {
        itemEntityMapper = FoodItemEntityMapper()
    }

    @Test
    fun mapFoodsResponseToDomainTest() {
        val foodsResponse = getDummyFoods()
        val listFoods = itemEntityMapper.mapToList(foodsResponse)
        assertEquals(listFoods[0], foodsResponse[0]?.let { itemEntityMapper.mapToEntity(it) })
    }

    @Test
    fun mapFoodItemResponseToDomainTest() {
        val foodItemResponse = getDummyFoods()[0]
        val itemFood = itemEntityMapper.mapToEntity(foodItemResponse)

        assertEquals(itemFood.fdcId, foodItemResponse.fdcId)
        assertEquals(itemFood.description, foodItemResponse.description)
        assertEquals(itemFood.dataType, foodItemResponse.dataType)
        assertEquals(itemFood.description, foodItemResponse.description)
        assertEquals(itemFood.publicationDate, foodItemResponse.publicationDate)
        assertEquals(itemFood.image, foodItemResponse.image)
    }
}