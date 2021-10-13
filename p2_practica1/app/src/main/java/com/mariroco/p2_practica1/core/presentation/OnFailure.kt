package com.mariroco.p2_practica1.core.presentation

import com.mariroco.p2_practica1.core.exception.Failure

interface OnFailure {
    fun handleFailure(failure: Failure?)
}