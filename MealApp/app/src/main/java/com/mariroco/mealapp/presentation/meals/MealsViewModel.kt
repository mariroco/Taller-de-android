package com.mariroco.mealapp.presentation.meals

import com.mariroco.mealapp.core.presentation.BaseViewModel
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.usecase.GetCategories
import com.mariroco.mealapp.domain.usecase.GetMealsByName
import com.mariroco.mealapp.domain.usecase.SaveCategories
import com.mariroco.mealapp.domain.usecase.SaveMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsByName: GetMealsByName,
    private val getCategories: GetCategories,
    private val saveMeals: SaveMeals,
    private val saveCategories: SaveCategories
): BaseViewModel() {
    fun doGetMealsByName(name: String){
        getMealsByName(name){
            it.fold(::handleFailure){
                state.value = MealsViewState.MealsReceived(it.meals ?: listOf())
                saveMeals(it.meals ?: listOf())
                true
            }
        }
    }

    fun doGetCategoriesByName(x: Boolean){
        getCategories(x){
            it.fold(::handleFailure){
                state.value = MealsViewState.CategoriesReceived(it.categories ?: listOf())
                saveCategories(it.categories ?: listOf())
                true
            }
        }
    }

    private fun saveMeals(meals:List<Meal>){
        saveMeals(meals){
            it.fold(::handleFailure){
                it
            }
        }
    }

    private fun saveCategories(categories:List<Category>){
        saveCategories(categories){
            it.fold(::handleFailure){
                it
            }
        }
    }
}