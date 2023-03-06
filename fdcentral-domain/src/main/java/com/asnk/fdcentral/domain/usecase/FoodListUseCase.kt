package com.asnk.fdcentral.domain.usecase

import com.asnk.fdcentral.domain.model.FoodItemEntity
import com.asnk.fdcentral.domain.model.Output
import kotlinx.coroutines.flow.Flow


/**
 * Interface of FoodList UseCase to expose to ui module
 */
interface FoodListUseCase {
    /**
     * UseCase Method to fetch the foods from Data Layer
     */
    suspend fun execute(): Flow<Output<List<FoodItemEntity>>>
}