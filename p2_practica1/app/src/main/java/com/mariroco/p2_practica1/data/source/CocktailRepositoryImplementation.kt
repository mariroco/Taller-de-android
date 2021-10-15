package com.mariroco.p2_practica1.data.source

import androidx.lifecycle.MutableLiveData
import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.core.platform.NetworkHandler
import com.mariroco.p2_practica1.core.presentation.BaseViewState
import com.mariroco.p2_practica1.data.api.CocktailApi
import com.mariroco.p2_practica1.data.dao.CocktailDao
import com.mariroco.p2_practica1.data.dto.CocktailsResponse
import com.mariroco.p2_practica1.domain.model.Cocktail
import com.mariroco.p2_practica1.domain.repository.CocktailRepository
import com.mariroco.p2_practica1.framework.api.ApiRequest
import com.mariroco.p2_practica1.presentation.cocktails.CocktailViewModel
import com.mariroco.p2_practica1.presentation.cocktails.CocktailViewState
import javax.inject.Inject

class CocktailRepositoryImplementation @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val cocktailDao: CocktailDao,
    private val networkHandler: NetworkHandler
) :
    CocktailRepository, ApiRequest {

    override fun getCocktailByName(name: String) : Either<Failure, CocktailsResponse> {
        val result = makeRequest(networkHandler, cocktailApi.getCocktailsByName(name), { it }, CocktailsResponse(emptyList()))

        //si el resultado es left (tiene errores/no hay conexión)
        return if (result.isLeft) {
            //consulta bd local
            val localResult = cocktailDao.getCocktailsByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(CocktailsResponse(localResult))

        } else {
            /*result.fold(::handleFailure){
                cocktailDao.saveCocktails(it.drinks!!)
            }*/
            result
        }

    }

    //AQUÍ VA LA LÓGICA DE LA BD
    override fun saveCocktail(cocktails: List<Cocktail>): Either<Failure, Boolean> {
        val result = cocktailDao.saveCocktails(cocktails)
        return if(result.size==cocktails.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateCocktail(cocktail: Cocktail): Either<Failure, Boolean> {
        TODO("Not yet implemented")
    }

    /*override fun deleteCocktail(cocktails: Cocktail): Either<Failure, Boolean> {
    }*/
/*
    var state: MutableLiveData<BaseViewState> = MutableLiveData()
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
        state.value = BaseViewState.HideLoading
    }
*/
}



