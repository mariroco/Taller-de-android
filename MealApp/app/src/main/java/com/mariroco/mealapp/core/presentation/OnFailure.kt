package com.mariroco.mealapp.core.presentation
import com.mariroco.mealapp.core.exception.Failure

interface OnFailure {
    fun handleFailure(failure: Failure?)
}