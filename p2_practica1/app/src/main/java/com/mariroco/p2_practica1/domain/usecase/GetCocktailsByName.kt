package com.mariroco.p2_practica1.domain.usecase

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.core.interactor.UseCase
import com.mariroco.p2_practica1.data.dto.CocktailsResponse
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import javax.inject.Inject

class GetCocktailsByName @Inject constructor(private val cocktailRepository: CocktailRepository) :
    UseCase<CocktailsResponse,String>(){

    override suspend fun run(params: String): Either<Failure, CocktailsResponse> {
        return cocktailRepository.getCocktailByName(params)
    }

    //override suspend fun run(params: String) = return cocktailRepository.getCocktailByName(params)
}