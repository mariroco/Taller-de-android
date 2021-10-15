package com.mariroco.p2_practica1.domain.usecase

import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.functional.Either
import com.mariroco.p2_practica1.core.interactor.UseCase
import com.mariroco.p2_practica1.core.platform.AuthManager
import com.mariroco.p2_practica1.domain.model.User
import javax.inject.Inject

class GetLocalUser @Inject constructor(private val authManager: AuthManager) : UseCase<User, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, User> {
        val result = authManager.user

        //Si el caso de uso no es nulo, mandamos un Right
        return  result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

}