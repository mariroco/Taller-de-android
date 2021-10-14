package com.mariroco.p2_practica1.domain.repository

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.data.dto.CocktailsResponse
import com.mariroco.p2_practica1.domain.model.Cocktail

interface CocktailRepository {
    fun getCocktailByName(name:String): Either<Failure, CocktailsResponse>

    fun saveCocktail(cocktails: List<Cocktail>): Either<Failure, Boolean>
    fun updateCocktail(cocktail: Cocktail): Either<Failure, Boolean>
    //fun deleteCocktail(cocktails: Cocktail): Either<Failure, Boolean>

}