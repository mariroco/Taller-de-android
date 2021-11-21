package com.mariroco.mealapp.presentation.profile

import androidx.lifecycle.ViewModel
import com.mariroco.mealapp.domain.usecase.GetLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsers: GetLocalUser,
) : ViewModel() {
    fun doGetUsers(x:Boolean){
        getUsers(){}
    }


}