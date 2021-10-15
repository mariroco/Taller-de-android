package com.mariroco.p2_practica1.domain.usecase

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.core.interactor.UseCase
import com.mariroco.p2_practica1.data.dao.CocktailDao
import com.mariroco.p2_practica1.domain.model.Cocktail
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import com.mariroco.p2_practica1.framework.db.CocktailDb
import javax.inject.Inject

class SaveCocktails @Inject constructor(private val cocktailRepository: CocktailRepository, private val cocktailDb: CocktailDb) :
    UseCase<Boolean,List<Cocktail>>(){

    override suspend fun run(params: List<Cocktail>): Either<Failure, Boolean> {
        cocktailDb.cocktailDao().saveCocktails(params)
        return cocktailRepository.saveCocktail(params)
    }
}