package com.mariroco.mealapp.presentation.randomMeals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mariroco.mealapp.R
import com.mariroco.mealapp.core.presentation.BaseFragment
import com.mariroco.mealapp.databinding.MealDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

class RandomFragment : BaseFragment(R.layout.meal_detail_fragment) {

    private lateinit var binding: MealDetailFragmentBinding


    override fun setBinding(view: View) {
        binding = MealDetailFragmentBinding.bind(view)
    }


}