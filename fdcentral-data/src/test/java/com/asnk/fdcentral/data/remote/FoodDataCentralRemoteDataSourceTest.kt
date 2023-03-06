package com.asnk.fdcentral.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asnk.fdcentral.data.services.ApiService
import com.asnk.fdcentral.getDummyFoodDetailResponse
import com.asnk.fdcentral.getDummyFoods
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.exceptions.base.MockitoException
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import retrofit2.Retrofit


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FoodDataCentralRemoteDataSourceTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var retrofit: Retrofit

    @Mock
    lateinit var profService: ApiService

    private lateinit var foodsRemoteDataSource: FoodDataCentralRemoteDataSource

    @Before
    fun setUp() {
        foodsRemoteDataSource = FoodDataCentralRemoteDataSource(profService, retrofit)
    }

    @Test
    fun `Given Foods When fetchFoods returns Success`() = runBlocking {

        //GIVEN
        val givenFoods = getDummyFoods()
        Mockito.`when`(profService.getFoods()).thenReturn(Response.success(givenFoods))

        //WHEN
        val fetchedFoods = foodsRemoteDataSource.fetchFoods()

        //THEN
        assert(fetchedFoods.data?.size == givenFoods.size)
    }

    @Test
    fun `Given Foods When fetchFoods returns Error`() = runBlocking {

        //GIVEN
        val mockitoException = MockitoException("Unknown Error")
        Mockito.`when`(profService.getFoods()).thenThrow(mockitoException)

        //WHEN
        val fetchedFoods = foodsRemoteDataSource.fetchFoods()

        //THEN
        assert(fetchedFoods.message == "Unknown Error")
    }

    @Test
    fun `Given Foods When fetchFoods returns Server Error`() = runBlocking {

        //GIVEN
        Mockito.`when`(profService.getFoods())
            .thenReturn(Response.error(500, "".toResponseBody()))

        //WHEN
        val fetchedFoods =foodsRemoteDataSource.fetchFoods()

        //THEN
        assert(fetchedFoods.message == "Unknown Error")
    }


    @Test
    fun `Given FoodDetail When fetchFoodDetail returns Success`() = runBlocking {

        //GIVEN
        val givenFoodDetail = getDummyFoodDetailResponse()
        Mockito.`when`(profService.getFoodDetail(1)).thenReturn(Response.success(givenFoodDetail))

        //WHEN
        val fetchedFoodDetail = foodsRemoteDataSource.fetchFoodDetail(1)

        //THEN
        assert(fetchedFoodDetail.data == givenFoodDetail)
    }

    @Test
    fun `Given FoodDetail When fetchFoodDetail returns Error`() = runBlocking {

        //GIVEN
        val mockitoException = MockitoException("Unknown Error")
        Mockito.`when`(profService.getFoodDetail(1)).thenThrow(mockitoException)

        //WHEN
        val fetchedFoodDetail = foodsRemoteDataSource.fetchFoodDetail(1)

        //THEN
        assert(fetchedFoodDetail.message == "Unknown Error")
    }

    @Test
    fun `Given FoodDetail When fetchFoodDetail returns Server Error`() = runBlocking {

        //GIVEN
        Mockito.`when`(profService.getFoodDetail(1))
            .thenReturn(Response.error(500, "".toResponseBody()))

        //WHEN
        val fetchedFoodDetail =foodsRemoteDataSource.fetchFoodDetail(1)

        //THEN
        assert(fetchedFoodDetail.message == "Unknown Error")
    }
}
