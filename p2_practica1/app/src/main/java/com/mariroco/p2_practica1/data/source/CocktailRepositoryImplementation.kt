package com.mariroco.p2_practica1.data.source

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.core.platform.NetworkHandler
import com.mariroco.p2_practica1.data.api.CocktailApi
import com.mariroco.p2_practica1.data.dto.CocktailsResponse
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import com.mariroco.p2_practica1.framework.ApiRequest
import javax.inject.Inject

class CocktailRepositoryImplementation @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val networkHandler: NetworkHandler
) :
    CocktailRepository, ApiRequest {

    override fun getCocktailByName(name: String) = makeRequest(
        // Obtiene cocktail que contiene string name en su nombre
        networkHandler, cocktailApi.getCocktailsByName(name), { it }, CocktailsResponse(
        emptyList()
        )
    )


}