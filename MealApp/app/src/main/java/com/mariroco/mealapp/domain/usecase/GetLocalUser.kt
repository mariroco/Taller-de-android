package com.mariroco.mealapp.domain.usecase

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.interactor.UseCase
import com.mariroco.mealapp.core.platform.AuthManager
import com.mariroco.mealapp.domain.model.User
import javax.inject.Inject

class GetLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<User, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, User> {
        val result = authManager.user

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

}