package com.mariroco.mealapp.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.databinding.MealsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


class MealsFragment : BaseFragment(R.layout.meals_fragment) {
    private lateinit var binding: MealsFragmentBinding

    override fun setBinding(view: View) {
        binding = MealsFragmentBinding.bind(view)
    }


}