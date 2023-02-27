package com.asnk.fdcentral.ui.foods

import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.usecase.FoodListUseCase
import com.asnk.fdcentral.ui.base.BaseViewModelTest
import com.asnk.fdcentral.ui.base.runBlockingMainTest
import com.asnk.fdcentral.ui.getDummyFoods
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FoodsViewModelTest : BaseViewModelTest(){

    @Mock
    private lateinit var foodsUseCase: FoodListUseCase
    private lateinit var foodsViewModel: FoodsViewModel

    @Before
    fun setUp() {
        foodsViewModel = FoodsViewModel(foodsUseCase)
    }

    @Test
    fun `Given Foods when fetchFoods should return Success`() = runBlockingMainTest {
        //GIVEN
        val flowQuestions = flowOf(Output.success(getDummyFoods()))

        //WHEN
        Mockito.doReturn(flowQuestions).`when`(foodsUseCase).execute()
        foodsViewModel.fetchFoods()

        //THEN
        assert(1 == foodsViewModel.foodsList.value?.data?.size)
    }
}