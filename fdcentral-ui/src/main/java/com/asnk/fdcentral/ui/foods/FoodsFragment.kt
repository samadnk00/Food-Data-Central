package com.asnk.fdcentral.ui.foods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.asnk.fdcentral.domain.model.FoodEntry
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.ui.R
import com.asnk.fdcentral.ui.base.BaseFragment
import com.asnk.fdcentral.ui.databinding.FragmentListFoodsBinding
import com.asnk.fdcentral.ui.widgets.applyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodsFragment : BaseFragment() {

    private val foodsViewModel: FoodsViewModel by viewModels()
    private var binding: FragmentListFoodsBinding? = null
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListFoodsBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            headerTitle = getString(R.string.label_foods)
            root
        }
    }

    override fun subscribeUi() {
        binding?.let {
            it.swipeRefresh.applyTheme()
            foodAdapter = FoodAdapter(arrayListOf(), onFoodItemClick)
            it.rvQuestions.adapter = foodAdapter
            it.swipeRefresh.setOnRefreshListener {
                foodsViewModel.fetchFoods()
            }
        }
        foodsViewModel.foodsList.observe(viewLifecycleOwner) { result ->

            binding?.swipeRefresh?.isRefreshing = when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        foodAdapter.update(list)
                    }
                    false
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            foodsViewModel.fetchFoods()
                        }
                    }
                    false
                }
                Output.Status.LOADING -> true
            }
        }
    }

    /**
     * @property onFoodItemClick to handle the Food item click.
     */
    private val onFoodItemClick: (food: FoodEntry, view: View) -> Unit =
        { food, view ->
            val extras = FragmentNavigatorExtras(
                view to food.image
            )
            findNavController().navigate(
                R.id.food_to_details,
                FoodDetailFragment.Args(food.fdcId).toBundle(),
                null,
                extras
            )
        }

}