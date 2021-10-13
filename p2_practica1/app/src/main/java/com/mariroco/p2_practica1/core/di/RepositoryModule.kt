package com.mariroco.p2_practica1.core.di

import com.mariroco.p2_practica1.core.platform.NetworkHandler
import com.mariroco.p2_practica1.data.api.CocktailApi
import com.mariroco.p2_practica1.data.source.CocktailRepositoryImplementation
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import com.mariroco.p2_practica1.framework.ApiProvider
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
    fun provideCocktailRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): CocktailRepository = CocktailRepositoryImplementation(apiProvider.getEndpoint(CocktailApi::class.java),networkHandler)
}