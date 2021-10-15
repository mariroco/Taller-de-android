package com.mariroco.p2_practica1.presentation.account

import com.mariroco.p2_practica1.core.presentation.BaseViewState
import com.mariroco.p2_practica1.domain.model.Cocktail
import com.mariroco.p2_practica1.domain.model.User

abstract class AccountViewState : BaseViewState(){
    data class LoggedUser(val user: User): BaseViewState()
    object UserNotFound : BaseViewState()
}