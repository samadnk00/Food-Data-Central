package com.asnk.fdcentral.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import com.asnk.fdcentral.getDummyFoodsResponse
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
class FoodListUseCaseImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var foodsRepository: FoodDataCentralRepository
    private lateinit var foodUseCase: FoodListUseCaseImpl

    @Before
    fun setUp() {
        foodUseCase = FoodListUseCaseImpl(foodsRepository)
    }

    @Test
    fun `Given Foods When UseCase fetchFoods returns Success`() = runBlocking {

        //GIVEN
        val inputFlow = flowOf(Output.success(getDummyFoodsResponse()))
        Mockito.`when`(foodsRepository.fetchFoods()).thenReturn(inputFlow)

        //WHEN
        val output = foodUseCase.execute()

        //THEN
        assert(Output.success(output) == Output.success(inputFlow))
    }

}