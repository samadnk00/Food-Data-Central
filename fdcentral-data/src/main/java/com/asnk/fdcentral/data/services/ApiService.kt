package com.asnk.fdcentral.data.services


import com.asnk.fdcentral.data.Config.API_KEY
import com.asnk.fdcentral.domain.model.FoodDetailEntry
import com.asnk.fdcentral.domain.model.FoodEntry
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API Service
 */
interface ApiService {

    @GET("/fdc/v1/foods/list$API_KEY")
    suspend fun getFoods(): Response<List<FoodEntry>>

    @GET("/fdc/v1/food/{id}$API_KEY")
    suspend fun getFoodDetail(@Path("id") foodId: Int): Response<FoodDetailEntry>

}