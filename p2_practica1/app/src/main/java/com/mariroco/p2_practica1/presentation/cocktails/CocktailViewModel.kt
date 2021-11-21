package com.mariroco.p2_practica1.presentation.cocktails

import androidx.lifecycle.ViewModel
import com.mariroco.p2_practica1.core.presentation.BaseViewModel
import com.mariroco.p2_practica1.data.dao.CocktailDao
import com.mariroco.p2_practica1.domain.model.Cocktail
import com.mariroco.p2_practica1.domain.usecase.GetCocktailsByName
import com.mariroco.p2_practica1.domain.usecase.SaveCocktails
import com.mariroco.p2_practica1.framework.db.CocktailDb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val getCocktailsByName: GetCocktailsByName,
    private val saveCocktails: SaveCocktails
    ):
    BaseViewModel() {

    fun doGetCocktailsByName(name: String) {
        getCocktailsByName(name) {
            it.fold(::handleFailure) {
                state.value = CocktailViewState.CocktailsReceived(it.drinks ?: listOf())

                saveCocktails(it.drinks ?: listOf())

                true
            }
        }
    }

    private fun saveCocktails(cocktails: List<Cocktail>){
        saveCocktails(cocktails) {

            it.fold(::handleFailure){
                it

            }
        }

    }
}