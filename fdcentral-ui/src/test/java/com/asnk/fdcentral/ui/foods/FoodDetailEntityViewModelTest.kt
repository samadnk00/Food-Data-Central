package com.asnk.fdcentral.ui.foods

import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.usecase.FoodDetailUseCase
import com.asnk.fdcentral.ui.base.BaseViewModelTest
import com.asnk.fdcentral.ui.base.runBlockingMainTest
import com.asnk.fdcentral.ui.getDummyFoodDetail
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class FoodDetailEntityViewModelTest : BaseViewModelTest(){

    @Mock
    private lateinit var foodDetailUseCase: FoodDetailUseCase
    private lateinit var foodDetailsViewModel: FoodDetailViewModel

    @Before
    fun setUp() {
        foodDetailsViewModel = FoodDetailViewModel(foodDetailUseCase)
    }

    @Test
    fun `Given FoodDetail when fetchFoodDetail should return Success`() = runBlockingMainTest {

        //GIVEN
        val flowQuestions = flowOf(Output.success(getDummyFoodDetail()))

        //WHEN
        Mockito.doReturn(flowQuestions).`when`(foodDetailUseCase).execute(1)
        foodDetailsViewModel.fetchFoodDetail(1)

        //THEN
        assert(foodDetailsViewModel.foodDetail.value?.data != null)
    }
}