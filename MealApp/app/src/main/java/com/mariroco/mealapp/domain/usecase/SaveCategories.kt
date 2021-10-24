package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.repository.MealRepository
import com.mariroco.mealapp.framework.db.MealDb
import java.util.*
import javax.inject.Inject

class SaveCategories @Inject constructor(private val mealRepository: MealRepository, private val mealDb: MealDb):
UseCase<Boolean,List<Category>>(){
    override suspend fun run(params: List<Category>): Either<Failure, Boolean> {
        mealDb.mealDao().saveCategories(params)
        return mealRepository.saveCategories(params)
    }

}