package com.asnk.fdcentral.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.ui.R
import com.asnk.fdcentral.ui.base.BaseFragment
import com.asnk.fdcentral.ui.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(
    FragmentSplashBinding::inflate) {

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel = splashViewModel
            lifecycleOwner = this@SplashFragment
            root
        }
    }

    override fun subscribeUi() {
        splashViewModel.isOk.observe(viewLifecycleOwner) { result ->
            if (result.status == Output.Status.SUCCESS) {
                binding?.loading?.hide()
                gotoFoodsScreen()
            } else if (result.status == Output.Status.LOADING) {
                binding?.loading?.show()
            }
        }
    }

    /**
     * Method to navigate Fragment to foods Screen.
     */
    private fun gotoFoodsScreen() {
        binding?.let {
            val extras = FragmentNavigatorExtras(
                it.profPic to getString(R.string.app_name)
            )
            findNavController().navigate(R.id.splash_to_foods, null, null, extras)
        }
    }
}