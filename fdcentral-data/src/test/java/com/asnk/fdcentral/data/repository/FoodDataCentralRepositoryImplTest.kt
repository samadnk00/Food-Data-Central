package com.asnk.fdcentral.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asnk.fdcentral.data.remote.FoodDataCentralRemoteDataSource
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import com.asnk.fdcentral.getDummyFoodDetail
import com.asnk.fdcentral.getDummyFoods
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FoodDataCentralRepositoryImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var foodsRepository: FoodDataCentralRepository

    @Mock
    lateinit var foodsRemoteDataSource: FoodDataCentralRemoteDataSource


    @Before
    fun setUp() {
        foodsRepository = FoodDataCentralRepositoryImpl(foodsRemoteDataSource)
    }

    @Test
    fun `Given Foods When fetchFoods returns Success`() = runBlocking {
        //GIVEN
        val givenFoods = getDummyFoods()
        val givenFoodsOutput = Output.success(givenFoods)
        val inputFlow = listOf(Output.loading(), Output.success(givenFoodsOutput))
        Mockito.`when`(foodsRemoteDataSource.fetchFoods()).thenReturn(givenFoodsOutput)

        //WHEN
        val outputFlow = foodsRepository.fetchFoods().toList()

        //THEN
        assert(outputFlow.size == 2)
        assert(inputFlow[0] == outputFlow[0])
        assert(inputFlow[1] == outputFlow[1])
    }

    @Test
    fun `Given FoodDetail When fetchFoodDetail returns Success`() = runBlocking {
        //GIVEN
        val givenFoodDetail = getDummyFoodDetail()
        val givenFoodDetailOutput = Output.success(givenFoodDetail)
        val inputFlow = listOf(Output.loading(), Output.success(givenFoodDetailOutput))
        Mockito.`when`(foodsRemoteDataSource.fetchFoodDetail(1)).thenReturn(givenFoodDetailOutput)

        //WHEN
        val outputFlow = foodsRepository.fetchFoodDetail(1)

        //THEN
        assert(inputFlow == outputFlow)
    }

}