package com.asnk.fdcentral.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asnk.fdcentral.data.model.FoodDetailEntityMapper
import com.asnk.fdcentral.data.model.FoodItemEntityMapper
import com.asnk.fdcentral.data.remote.FoodDataCentralRemoteDataSource
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import com.asnk.fdcentral.getDummyFoodDetailResponse
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
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FoodDataCentralRepositoryImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var foodsRepository: FoodDataCentralRepository
    private lateinit var foodItemMapper: FoodItemEntityMapper
    private lateinit var foodDetailMapper: FoodDetailEntityMapper

    @Mock
    lateinit var foodsRemoteDataSource: FoodDataCentralRemoteDataSource



    @Before
    fun setUp() {
        foodItemMapper = FoodItemEntityMapper()
        foodDetailMapper = FoodDetailEntityMapper()
        foodsRepository = FoodDataCentralRepositoryImpl(foodsRemoteDataSource, foodItemMapper, foodDetailMapper)
    }

    @Test
    fun `Given Foods When fetchFoods returns Success`() = runBlocking {

        //GIVEN
        val givenFoods = getDummyFoods()
        val givenFoodsOutput = Output.success(givenFoods)
        val inputFlow = listOf(Output.loading(), Output.success(givenFoods))
        val mappedInputFlow = inputFlow[1].data?.let { foodItemMapper.mapToList(it) }
        Mockito.`when`(foodsRemoteDataSource.fetchFoods()).thenReturn(givenFoodsOutput)

        //WHEN
        val outputFlow = foodsRepository.fetchFoods().toList()
        val mappedOutputFlow = outputFlow[1].data

        //THEN
        assert(outputFlow.size == 2)
        assert(inputFlow[0] == outputFlow[0])
        assert(mappedInputFlow == mappedOutputFlow)
    }

    @Test
    fun `Given FoodDetail When fetchFoodDetail returns Success`() = runBlocking {

        //GIVEN
        val givenFoodDetail = getDummyFoodDetailResponse()
        val givenFoodDetailOutput = Output.success(givenFoodDetail)
        val inputFlow = listOf(Output.loading(), Output.success(givenFoodDetail))
        val mappedInputFlow = inputFlow[1].data?.let { foodDetailMapper.mapToEntity(it) }
        Mockito.`when`(foodsRemoteDataSource.fetchFoodDetail(1)).thenReturn(givenFoodDetailOutput)

        //WHEN
        val mappedOutputFlow = foodsRepository.fetchFoodDetail(1).toList()[1].data

        //THEN
        assert(mappedInputFlow == mappedOutputFlow)
    }

}