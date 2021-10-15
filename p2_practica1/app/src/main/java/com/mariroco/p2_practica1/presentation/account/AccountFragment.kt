package com.mariroco.p2_practica1.presentation.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mariroco.p2_practica1.R
import com.mariroco.p2_practica1.core.extension.failure
import com.mariroco.p2_practica1.core.extension.observe
import com.mariroco.p2_practica1.core.presentation.BaseFragment
import com.mariroco.p2_practica1.core.presentation.BaseViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class AccountFragment : BaseFragment(R.layout.account_fragment) {

    private val accountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //logica de shared preferences usuario
        accountViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            getLocalUser()
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is AccountViewState.LoggedUser -> {}
            is AccountViewState.UserNotFound ->{
                //no tiene argumentos así que el parentesis queda vacio
                navController.navigate(AccountFragmentDirections.actionAccountFragmentToLoginFragment())
            }
        }
    }

    override fun setBinding(view: View) {
    }


}