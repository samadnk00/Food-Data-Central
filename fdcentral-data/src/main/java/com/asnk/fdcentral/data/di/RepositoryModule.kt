package com.asnk.fdcentral.data.di

import com.asnk.fdcentral.data.repository.FoodDataCentralRepositoryImpl
import com.asnk.fdcentral.domain.repository.FoodDataCentralRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindFoodDataCentralRepository(repository: FoodDataCentralRepositoryImpl): FoodDataCentralRepository
}