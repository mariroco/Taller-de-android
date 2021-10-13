package com.mariroco.p2_practica1.presentation.cocktails

import com.mariroco.p2_practica1.core.presentation.BaseViewState
import com.mariroco.p2_practica1.domain.model.Cocktail

class CocktailViewState {
    data class CocktailsReceived(val cocktails: List<Cocktail>): BaseViewState()
}