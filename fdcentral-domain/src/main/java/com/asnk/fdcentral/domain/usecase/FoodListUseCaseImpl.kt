package com.asnk.fdcentral.domain.usecase

import com.asnk.fdcentral.domain.model.FoodEntry
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of Food list UseCase
 * @param foodDataCentralRepository the foods repository object
 */
internal class FoodListUseCaseImpl @Inject constructor(
    private val foodDataCentralRepository: FoodDataCentralRepository) : FoodListUseCase {

    override suspend fun execute(): Flow<Output<List<FoodEntry>>> {
        return foodDataCentralRepository.fetchFoods()
    }
}
