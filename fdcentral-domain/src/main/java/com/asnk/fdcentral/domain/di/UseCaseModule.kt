package com.asnk.fdcentral.domain.di

import com.asnk.fdcentral.domain.usecase.FoodDetailUseCase
import com.asnk.fdcentral.domain.usecase.FoodDetailUseCaseImpl
import com.asnk.fdcentral.domain.usecase.FoodListUseCase
import com.asnk.fdcentral.domain.usecase.FoodListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindFoodDataCentralUseCase(useCaseImpl: FoodListUseCaseImpl): FoodListUseCase

    @Binds
    @Singleton
    internal abstract fun bindFoodDataCentralDetailUseCase(useCaseImpl: FoodDetailUseCaseImpl): FoodDetailUseCase
}