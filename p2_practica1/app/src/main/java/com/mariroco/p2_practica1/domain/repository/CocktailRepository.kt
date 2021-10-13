package com.mariroco.p2_practica1.domain.repository

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.data.dto.CocktailsResponse

interface CocktailRepository {
    fun getCocktailByName(name:String): Either<Failure, CocktailsResponse>
}