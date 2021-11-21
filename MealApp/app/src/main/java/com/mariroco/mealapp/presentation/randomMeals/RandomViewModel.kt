package com.mariroco.mealapp.presentation.randomMeals

import androidx.lifecycle.ViewModel
import com.mariroco.mealapp.core.presentation.BaseViewModel
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.usecase.GetRandomMeal
import com.mariroco.mealapp.presentation.meals.MealsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class RandomViewModel @Inject constructor(
    private val getRandomMeal: GetRandomMeal
): BaseViewModel() {

    fun doGetRandomMeal(x:Boolean){
        getRandomMeal(x){
            it.fold(::handleFailure){
                state.value = MealsViewState.MealsReceived(it.meals ?: listOf())
                true
            }
        }
    }

}