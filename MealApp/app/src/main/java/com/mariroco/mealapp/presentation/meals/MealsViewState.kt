package com.mariroco.mealapp.presentation.meals

import com.mariroco.mealapp.core.presentation.BaseViewState
import com.mariroco.mealapp.domain.model.Meal

class MealsViewState {
    data class MealsReceived(val meals: List<Meal>) : BaseViewState()
}