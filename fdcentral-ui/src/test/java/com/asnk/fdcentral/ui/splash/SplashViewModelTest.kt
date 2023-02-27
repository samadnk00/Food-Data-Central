package com.asnk.fdcentral.ui.splash

import com.asnk.fdcentral.domain.model.Output
import com.asnk.fdcentral.ui.base.BaseViewModelTest
import com.asnk.fdcentral.ui.base.runBlockingMainTest
import com.asnk.fdcentral.ui.observeForTesting
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SplashViewModelTest : BaseViewModelTest(){

    private lateinit var splashViewModel: SplashViewModel

    @Before
    fun setUp() {
        splashViewModel = SplashViewModel()
    }

    @Test
    fun `Given output When load returns Success`() = runBlockingMainTest {
        //WHEN
        splashViewModel.load()

        //THEN
        splashViewModel.isOk.observeForTesting {
            assert(splashViewModel.isOk.value?.status == Output.Status.LOADING)
        }
    }
}