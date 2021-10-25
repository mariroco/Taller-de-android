package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.data.dto.MealsResponse
import com.mariroco.mealapp.data.dto.RandomMealResponse
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.repository.MealRepository
import javax.inject.Inject

class GetRandomMeal @Inject constructor(private val mealRepository: MealRepository):
    UseCase<MealsResponse,Boolean>(){
    override suspend fun run(params: Boolean): Either<Failure, MealsResponse> {
        //hasta aquí también funcion
        return mealRepository.getRandomMeal()
    }

}