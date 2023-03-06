package com.asnk.fdcentral.domain.usecase

import com.asnk.fdcentral.domain.model.FoodDetailEntity
import com.asnk.fdcentral.domain.model.Output
import kotlinx.coroutines.flow.Flow

interface FoodDetailUseCase {

    /**
     * UseCase Method to fetch the food detail from Data Layer
     */
    suspend fun execute(foodId: Int): Flow<Output<FoodDetailEntity>>
}