package com.mariroco.mealapp.core.di

import com.mariroco.mealapp.core.platform.NetworkHandler
import com.mariroco.mealapp.data.api.MealApi
import com.mariroco.mealapp.data.source.MealRepositoryImplementation
import com.mariroco.mealapp.domain.repository.MealRepository
import com.mariroco.mealapp.framework.api.ApiProvider
import com.mariroco.mealapp.framework.db.MealDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMealRepository(
        apiProvider: ApiProvider,
        mealDb: MealDb,
        networkHandler: NetworkHandler
    ): MealRepository =
        MealRepositoryImplementation(apiProvider.getEndpoint(MealApi::class.java), networkHandler = networkHandler, mealDao = mealDb.mealDao())

}