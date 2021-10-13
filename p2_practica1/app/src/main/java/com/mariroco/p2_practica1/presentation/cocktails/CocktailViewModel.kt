package com.mariroco.p2_practica1.presentation.cocktails

import androidx.lifecycle.ViewModel
import com.mariroco.p2_practica1.core.presentation.BaseViewModel
import com.mariroco.p2_practica1.domain.usecase.GetCocktailsByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class CocktailViewModel @Inject constructor(private val getCocktailsByName: GetCocktailsByName) :
    BaseViewModel() {

    fun doGetCocktailsByName(name: String) {
        getCocktailsByName(name) {
            it.fold(::handleFailure) {
                state.value = CocktailViewState.CocktailsReceived(it.drinks ?: listOf())

                true
            }
        }
    }
}