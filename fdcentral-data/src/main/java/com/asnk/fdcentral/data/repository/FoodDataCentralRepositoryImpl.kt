package com.asnk.fdcentral.data.repository

import com.asnk.fdcentral.data.remote.FoodDataCentralRemoteDataSource
import com.asnk.fdcentral.domain.model.FoodDetailEntry
import com.asnk.fdcentral.domain.model.FoodEntry
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of FoodDataCentralRepository
 * @param foodDataCentralRemoteDataSource the object of remote data source
 */
internal class FoodDataCentralRepositoryImpl @Inject constructor(
    private val foodDataCentralRemoteDataSource: FoodDataCentralRemoteDataSource
) : FoodDataCentralRepository {

    override suspend fun fetchFoods(): Flow<Output<List<FoodEntry>>> {
        return flow {
            emit(Output.loading())
            val result = foodDataCentralRemoteDataSource.fetchFoods()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchFoodDetail(foodId : Int): Flow<Output<FoodDetailEntry>> {
        return flow {
            emit(Output.loading())
            val result = foodDataCentralRemoteDataSource.fetchFoodDetail(foodId)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}