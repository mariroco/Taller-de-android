package com.mariroco.mealapp.data.source

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.platform.NetworkHandler
import com.mariroco.mealapp.data.api.MealApi
import com.mariroco.mealapp.data.dao.MealDao
import com.mariroco.mealapp.data.dto.CategoriesResponse
import com.mariroco.mealapp.data.dto.MealsResponse
import com.mariroco.mealapp.data.dto.RandomMealResponse
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.repository.MealRepository
import com.mariroco.mealapp.framework.api.ApiRequest
import javax.inject.Inject

class MealRepositoryImplementation @Inject constructor(
    private val mealApi: MealApi,
    private val mealDao: MealDao,
    private val networkHandler: NetworkHandler
): MealRepository, ApiRequest {

    override fun getMealByName(name: String): Either<Failure, MealsResponse> {
        var result = makeRequest(networkHandler, mealApi.getMealsByName(name),{it},MealsResponse(
            emptyList()))

        return if(result.isLeft){
            val localResult = mealDao.getMealsByName("%name")
            if (localResult.isEmpty()) result
            else Either.Right(MealsResponse(localResult))
        }else{
            result
        }
    }

    override fun getCategories(): Either<Failure, CategoriesResponse> {
        var result = makeRequest(networkHandler,mealApi.getCategories(),{it}, CategoriesResponse())
        return if(result.isLeft){
            val localResult = mealDao.getCategories()
            if(localResult.isEmpty()) result
            else Either.Right(CategoriesResponse(localResult))

        }else{result}
    }

    //hasta aquí si funciona
    override fun getRandomMeal(): Either<Failure, MealsResponse> {
        var result = makeRequest(networkHandler,mealApi.getRandomMeal(),{it}, MealsResponse(
            emptyList()))
        return result
    }


    override fun saveMeals(meals: List<Meal>): Either<Failure, Boolean> {
        val result = mealDao.saveMeals(meals)
        return if(result.size==meals.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun saveCategories(categories: List<Category>): Either<Failure, Boolean> {
        val result = mealDao.saveCategories(categories)
        return if(result.size == categories.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)

    }
}