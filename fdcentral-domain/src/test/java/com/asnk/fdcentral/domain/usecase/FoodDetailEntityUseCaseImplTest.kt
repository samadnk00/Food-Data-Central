package com.asnk.fdcentral.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import com.asnk.fdcentral.getDummyFoodDetail
import com.asnk.fdcentral.getDummyFoods
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
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
class FoodDetailEntityUseCaseImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var foodsRepository: FoodDataCentralRepository
    private lateinit var foodUseCase: FoodDetailUseCase

    @Before
    fun setUp() {
        foodUseCase = FoodDetailUseCaseImpl(foodsRepository)
    }

    @Test
    fun `Given Food Details When UseCase fetchFoodDetail returns Success`() = runBlocking {

        //GIVEN
        val inputFlow = flowOf(Output.success(getDummyFoodDetail()))
        Mockito.`when`(foodsRepository.fetchFoodDetail(1)).thenReturn(inputFlow)

        //WHEN
        val outputFlow = foodUseCase.execute(1)

        //THEN
        assert(outputFlow == inputFlow)
    }
}