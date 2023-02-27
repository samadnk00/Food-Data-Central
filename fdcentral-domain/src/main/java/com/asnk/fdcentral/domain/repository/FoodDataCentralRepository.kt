package com.asnk.fdcentral.domain.repository

import com.asnk.fdcentral.domain.model.FoodDetailEntry
import com.asnk.fdcentral.domain.model.FoodEntry
import com.asnk.fdcentral.domain.model.Output
import kotlinx.coroutines.flow.Flow

/**
 * Interface of foods Repository to expose to other module
 */
interface FoodDataCentralRepository {

    /**
     * Method to fetch the Food list from Repository
     * @return Flow of Outputs with food list
     */
    suspend fun fetchFoods(): Flow<Output<List<FoodEntry>>>

    /**
     * Method to fetch the Food list from Repository
     * @return Flow of Outputs with food list
     */
    suspend fun fetchFoodDetail(foodId: Int): Flow<Output<FoodDetailEntry>>
}