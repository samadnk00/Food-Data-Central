package com.asnk.fdcentral.ui.foods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.ui.base.BaseFragment
import com.asnk.fdcentral.ui.databinding.FragmentFoodDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : BaseFragment<FragmentFoodDetailBinding>(
    FragmentFoodDetailBinding::inflate) {

    private val foodDetailViewModel: FoodDetailViewModel by viewModels()
    private val foodItem by lazy { Args.fromBundle(arguments) }

    override fun subscribeUi() {

        binding?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        foodDetailViewModel.fetchFoodDetail(foodItem.id)

        foodDetailViewModel.foodDetail.observe(viewLifecycleOwner){
            result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let{
                        binding?.item = result.data
                        binding?.loading?.isVisible = false
                    }
                    false
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it){
                            foodDetailViewModel.fetchFoodDetail(foodItem.id)
                            binding?.loading?.isVisible = false
                        }
                    }
                    false
                }
                Output.Status.LOADING -> true
            }
        }
    }

    class Args(val id: Int) {

        companion object {
            private const val ARG_ITEM = "FdCid"

             fun fromBundle(bundle: Bundle?): Args {
                if (bundle == null)
                    throw IllegalStateException("Arguments must be passed to fragment")
                val id = bundle.getInt(ARG_ITEM)
                return Args(id)
            }
        }

        fun toBundle() = bundleOf(ARG_ITEM to id)
    }
}