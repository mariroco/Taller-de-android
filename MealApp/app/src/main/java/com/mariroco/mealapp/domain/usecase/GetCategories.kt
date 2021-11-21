package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.data.dto.CategoriesResponse
import com.mariroco.mealapp.domain.model.Category
import com.mariroco.mealapp.domain.repository.MealRepository
import java.util.*
import javax.inject.Inject

class GetCategories @Inject constructor(private val mealRepository: MealRepository) :
    UseCase<CategoriesResponse,Boolean>(){
    override suspend fun run(params: Boolean): Either<Failure, CategoriesResponse> {
        return mealRepository.getCategories()
    }

}