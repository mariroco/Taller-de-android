package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.data.dto.MealsResponse
import com.mariroco.mealapp.domain.repository.MealRepository
import javax.inject.Inject

class GetMealsByName @Inject constructor(private val mealRepository: MealRepository) :
    UseCase<MealsResponse,String>() {
    override suspend fun run(params: String): Either<Failure, MealsResponse> {
        return mealRepository.getMealByName(params)
    }
}