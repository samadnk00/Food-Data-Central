package com.asnk.fdcentral.domain.usecase

import com.asnk.fdcentral.domain.model.FoodDetailEntity
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
* Implementation of Food DETAIL UseCase
* @param foodDataCentralRepository the foods repository object
*/
internal class FoodDetailUseCaseImpl @Inject constructor(
    private val foodDataCentralRepository: FoodDataCentralRepository) : FoodDetailUseCase {

    override suspend fun execute(foodId: Int): Flow<Output<FoodDetailEntity>> {
        return foodDataCentralRepository.fetchFoodDetail(foodId = foodId)
    }
}