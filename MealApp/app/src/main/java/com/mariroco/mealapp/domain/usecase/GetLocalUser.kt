package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.core.platform.AuthManager
import com.mariroco.mealapp.data.dao.MealDao
import com.mariroco.mealapp.data.dto.UsersResponse
import com.mariroco.mealapp.domain.model.User
import com.mariroco.mealapp.domain.repository.MealRepository
import javax.inject.Inject

class GetLocalUser @Inject constructor(private val mealRepository: MealRepository) :
    UseCase<User, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, UsersResponse> {
        return mealRepository.getUsers()
    }


}