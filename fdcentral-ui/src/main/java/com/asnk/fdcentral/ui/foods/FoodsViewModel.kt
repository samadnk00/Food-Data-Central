package com.asnk.fdcentral.ui.foods

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.asnk.fdcentral.domain.model.FoodItemEntity
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.domain.usecase.FoodListUseCase
import com.asnk.fdcentral.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodsViewModel @Inject constructor(
    private val foodListUseCase: FoodListUseCase) : BaseViewModel() {

    private val _foodList = MutableLiveData<Output<List<FoodItemEntity>>>()
    val foodsList: LiveData<Output<List<FoodItemEntity>>> = _foodList

    init {
        fetchFoods()
    }

    /**
     * Method to fetch the food data.
     */
    fun fetchFoods() {

        viewModelScope.launch {
            foodListUseCase.execute().collect {
                _foodList.value = it
            }
        }
    }
}