package com.mariroco.mealapp.framework.api

import com.mariroco.mealapp.core.exception.Failure
import com.mariroco.mealapp.core.functional.Either
import com.mariroco.mealapp.core.platform.NetworkHandler
import retrofit2.Call
import java.lang.Exception

interface ApiRequest {
    fun<T,R> makeRequest(
        networkHandler: NetworkHandler,
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return when (networkHandler.isConnected){
            true->{
                try {
                    val response = call.execute()
                    when(response.isSuccessful){
                        true -> Either.Right(transform(response.body() ?: default))
                        false -> Either.Left(Failure.ServerError(500, ""))
                    }
                }catch (e: Exception){
                    Either.Left(Failure.ServerError(500,e.message))
                }
            }
            false->{
                Either.Left(Failure.NetworkConnection)
            }
        }
    }
}