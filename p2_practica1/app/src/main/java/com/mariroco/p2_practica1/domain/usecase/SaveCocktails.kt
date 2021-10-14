package com.mariroco.p2_practica1.domain.usecase

import com.mariroco.p2_practica1.core.interactor.UseCase
import com.mariroco.p2_practica1.domain.model.Cocktail
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import javax.inject.Inject

class SaveCocktails @Inject constructor(private val cocktailRepository: CocktailRepository) :
    UseCase<Boolean,List<Cocktail>>(){

    override suspend fun run(params: List<Cocktail>) = cocktailRepository.saveCocktail(params)
}