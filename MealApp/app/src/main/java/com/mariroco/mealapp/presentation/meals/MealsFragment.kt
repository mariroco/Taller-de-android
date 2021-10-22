package com.mariroco.mealapp.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class MealsFragment : BaseFragment(R.layout.meals_fragment) {
    override fun setBinding(view: View) {
        TODO("Not yet implemented")
    }


}