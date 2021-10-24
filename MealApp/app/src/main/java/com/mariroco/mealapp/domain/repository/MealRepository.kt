package com.mariroco.mealapp.domain.repository

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.data.dto.CategoriesResponse
import com.mariroco.mealapp.data.dto.MealsResponse
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.Meal

interface MealRepository {
    fun getMealByName(name:String):Either<Failure, MealsResponse>
    fun getCategories():Either<Failure, CategoriesResponse>
    fun saveMeals(meals: List<Meal>):Either<Failure, Boolean>
    fun saveCategories(categories: List<Category>):Either<Failure,Boolean>

}