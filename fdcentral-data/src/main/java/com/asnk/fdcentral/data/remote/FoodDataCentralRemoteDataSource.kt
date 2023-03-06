package com.asnk.fdcentral.data.remote

import com.asnk.fdcentral.data.BaseRemoteDataSource
import com.asnk.fdcentral.data.model.response.FoodDetailResponse
import com.asnk.fdcentral.data.model.FoodItemEntityMapper
import com.asnk.fdcentral.data.model.response.FoodItemResponse
import com.asnk.fdcentral.data.services.ApiService
import com.asnk.fdcentral.domain.model.Output
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * RemoteDataSource of Food list API service
 * @param apiService the object of api service
 */
class FoodDataCentralRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    retrofit: Retrofit) : BaseRemoteDataSource(retrofit) {

    /**
     * Method to fetch the Food list from FDCRemoteDataSource
     * @return Outputs with list of foods
     */
    suspend fun fetchFoods(): Output<List<FoodItemResponse>> {
        return getResponse(
            request = { apiService.getFoods() },
            defaultErrorMessage = "Error fetching foods"
        )
    }

    /**
     * Method to fetch the Food detail from FDCRemoteDataSource
     * @return Outputs with list of foods
     */
    suspend fun fetchFoodDetail(foodId: Int): Output<FoodDetailResponse> {
        return getResponse(
            request = { apiService.getFoodDetail(foodId = foodId) },
            defaultErrorMessage = "Error fetching foods"
        )
    }
}