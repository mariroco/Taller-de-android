package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.domain.model.Meal
import com.mariroco.mealapp.domain.repository.MealRepository
import com.mariroco.mealapp.framework.db.MealDb
import javax.inject.Inject

class SaveMeals @Inject constructor(private val mealRepository: MealRepository, private val mealDb: MealDb): UseCase<Boolean,List<Meal>>() {
    override suspend fun run(params: List<Meal>): Either<Failure, Boolean> {
        mealDb.mealDao().saveMeals(params)
        return mealRepository.saveMeals(params)
    }
}