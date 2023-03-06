package com.asnk.fdcentral.data.repository

import com.asnk.fdcentral.data.model.FoodDetailEntityMapper
import com.asnk.fdcentral.data.model.FoodItemEntityMapper
import com.asnk.fdcentral.data.remote.FoodDataCentralRemoteDataSource
import com.asnk.fdcentral.domain.model.FoodDetailEntity
import com.asnk.fdcentral.domain.model.FoodItemEntity
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
    private val foodDataCentralRemoteDataSource: FoodDataCentralRemoteDataSource,
    private val foodItemMapper: FoodItemEntityMapper,
    private val foodDetailMapper: FoodDetailEntityMapper

) : FoodDataCentralRepository {

    override suspend fun fetchFoods(): Flow<Output<List<FoodItemEntity>>> {
        return flow {
            emit(Output.loading())
            val result = foodDataCentralRemoteDataSource.fetchFoods()
            val data = result.data?.let { foodItemMapper.mapToList(it) }
            emit(Output.success(data))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchFoodDetail(foodId : Int): Flow<Output<FoodDetailEntity>> {
        return flow {
            emit(Output.loading())
            val result = foodDataCentralRemoteDataSource.fetchFoodDetail(foodId)
            val data = result.data?.let { foodDetailMapper.mapToEntity(it) }
            emit(Output.success(data))
        }.flowOn(Dispatchers.IO)

    }
}