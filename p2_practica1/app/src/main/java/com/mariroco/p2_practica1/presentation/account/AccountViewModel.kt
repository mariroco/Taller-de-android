package com.mariroco.p2_practica1.presentation.account

import androidx.lifecycle.ViewModel
import com.mariroco.p2_practica1.core.exception.Failure
import com.mariroco.p2_practica1.core.interactor.UseCase
import com.mariroco.p2_practica1.core.presentation.BaseViewModel
import com.mariroco.p2_practica1.domain.usecase.GetLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(private val getLocalUser: GetLocalUser) :
    BaseViewModel() {

    fun getLocalUser(){
        getLocalUser(UseCase.None()){
            it.fold(::userNotFound){
                //Camino de la derecha
                state.value = AccountViewState.LoggedUser(it)
                true
            }
        }
    }
    private fun userNotFound(failure: Failure){
        state.value=AccountViewState.UserNotFound
        handleFailure(failure)
    }

}