package com.asnk.fdcentral.ui.foods

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.asnk.fdcentral.domain.model.FoodDetailEntity
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.usecase.FoodDetailUseCase
import com.asnk.fdcentral.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val foodDetailUseCase: FoodDetailUseCase) : BaseViewModel() {

    private val _foodDetail = MutableLiveData<Output<FoodDetailEntity>>()
    val foodDetail: LiveData<Output<FoodDetailEntity>> = _foodDetail

    /**
     * Method to fetch the food data.
     */
    fun fetchFoodDetail(foodId: Int) {
        viewModelScope.launch {
            foodDetailUseCase.execute(foodId).collect{
                _foodDetail.value = it
            }
        }

    }

}

